from flask import Flask, request, jsonify
from flask_cors import CORS
import pymysql
import bcrypt
import jwt
import datetime
from functools import wraps
import os
from dotenv import load_dotenv

load_dotenv()

app = Flask(__name__)
app.config['SECRET_KEY'] = os.getenv('SECRET_KEY')
CORS(app)

def get_db_connection():
    return pymysql.connect(
        host=os.getenv('MYSQL_HOST'),
        user=os.getenv('MYSQL_USER'),
        password=os.getenv('MYSQL_PASSWORD'),
        database=os.getenv('MYSQL_DB'),
        charset='utf8mb4',
        cursorclass=pymysql.cursors.DictCursor
    )

def token_required(f):
    @wraps(f)
    def decorated(*args, **kwargs):
        token = request.headers.get('Authorization')
        if not token:
            return jsonify({'message': 'Token necessario'}), 401
        
        try:
            if token.startswith('Bearer '):
                token = token[7:]
            data = jwt.decode(token, app.config['SECRET_KEY'], algorithms=['HS256'])
            current_user_id = data['user_id']
        except:
            return jsonify({'message': 'Token invalido'}), 401
        
        return f(current_user_id, *args, **kwargs)
    return decorated

@app.route('/api/register', methods=['POST'])
def register():
    data = request.get_json()
    username = data.get('username')
    password = data.get('password')
    
    if not username or not password:
        return jsonify({'message': 'Username e password obrigatorios'}), 400
    
    hashed_password = bcrypt.hashpw(password.encode('utf-8'), bcrypt.gensalt())
    
    connection = get_db_connection()
    try:
        with connection.cursor() as cursor:
            cursor.execute("SELECT id FROM users WHERE username = %s", (username,))
            if cursor.fetchone():
                return jsonify({'message': 'Usuario ja existe'}), 400
            
            cursor.execute(
                "INSERT INTO users (username, password) VALUES (%s, %s)",
                (username, hashed_password.decode('utf-8'))
            )
            connection.commit()
            
            user_id = cursor.lastrowid
            
            token = jwt.encode({
                'user_id': user_id,
                'exp': datetime.datetime.utcnow() + datetime.timedelta(hours=24)
            }, app.config['SECRET_KEY'])
            
            return jsonify({
                'message': 'Usuario criado com sucesso',
                'token': token,
                'user_id': user_id
            }), 201
            
    except Exception as e:
        return jsonify({'message': 'Erro interno do servidor'}), 500
    finally:
        connection.close()

@app.route('/api/login', methods=['POST'])
def login():
    data = request.get_json()
    username = data.get('username')
    password = data.get('password')
    
    if not username or not password:
        return jsonify({'message': 'Username e password obrigatorios'}), 400
    
    connection = get_db_connection()
    try:
        with connection.cursor() as cursor:
            cursor.execute("SELECT id, password FROM users WHERE username = %s", (username,))
            user = cursor.fetchone()
            
            if not user or not bcrypt.checkpw(password.encode('utf-8'), user['password'].encode('utf-8')):
                return jsonify({'message': 'Credenciais invalidas'}), 401
            
            token = jwt.encode({
                'user_id': user['id'],
                'exp': datetime.datetime.utcnow() + datetime.timedelta(hours=24)
            }, app.config['SECRET_KEY'])
            
            return jsonify({
                'message': 'Login realizado com sucesso',
                'token': token,
                'user_id': user['id']
            }), 200
            
    except Exception as e:
        return jsonify({'message': 'Erro interno do servidor'}), 500
    finally:
        connection.close()

@app.route('/api/progress', methods=['POST'])
@token_required
def update_progress(current_user_id):
    data = request.get_json()
    stage_name = data.get('stage_name')
    
    if not stage_name:
        return jsonify({'message': 'Nome da fase obrigatorio'}), 400
    
    connection = get_db_connection()
    try:
        with connection.cursor() as cursor:
            cursor.execute("SELECT id FROM stages WHERE name = %s", (stage_name,))
            stage = cursor.fetchone()
            
            if not stage:
                return jsonify({'message': 'Fase nao encontrada'}), 404
            
            stage_id = stage['id']
            
            cursor.execute(
                "SELECT id FROM user_progress WHERE user_id = %s AND stage_id = %s",
                (current_user_id, stage_id)
            )
            
            if cursor.fetchone():
                return jsonify({'message': 'Progresso ja existe para esta fase'}), 400
            
            cursor.execute(
                "INSERT INTO user_progress (user_id, stage_id, completed_at) VALUES (%s, %s, %s)",
                (current_user_id, stage_id, datetime.datetime.now())
            )
            connection.commit()
            
            cursor.execute(
                """SELECT a.id, a.name, a.description 
                   FROM achievements a 
                   WHERE a.stage_id = %s 
                   AND a.id NOT IN (
                       SELECT achievement_id FROM user_achievements 
                       WHERE user_id = %s
                   )""",
                (stage_id, current_user_id)
            )
            
            new_achievements = cursor.fetchall()
            
            for achievement in new_achievements:
                cursor.execute(
                    "INSERT INTO user_achievements (user_id, achievement_id, earned_at) VALUES (%s, %s, %s)",
                    (current_user_id, achievement['id'], datetime.datetime.now())
                )
            
            connection.commit()
            
            return jsonify({
                'message': 'Progresso atualizado com sucesso',
                'new_achievements': new_achievements
            }), 200
            
    except Exception as e:
        return jsonify({'message': 'Erro interno do servidor'}), 500
    finally:
        connection.close()

@app.route('/api/achievements/<int:user_id>', methods=['GET'])
@token_required
def get_user_achievements(current_user_id, user_id):
    connection = get_db_connection()
    try:
        with connection.cursor() as cursor:
            cursor.execute(
                """SELECT a.id, a.name, a.description, s.name as stage_name, ua.earned_at
                   FROM user_achievements ua
                   JOIN achievements a ON ua.achievement_id = a.id
                   JOIN stages s ON a.stage_id = s.id
                   WHERE ua.user_id = %s
                   ORDER BY ua.earned_at DESC""",
                (user_id,)
            )
            
            achievements = cursor.fetchall()
            
            cursor.execute("SELECT username FROM users WHERE id = %s", (user_id,))
            user = cursor.fetchone()
            
            if not user:
                return jsonify({'message': 'Usuario nao encontrado'}), 404
            
            return jsonify({
                'user_id': user_id,
                'username': user['username'],
                'achievements': achievements,
                'total_achievements': len(achievements)
            }), 200
            
    except Exception as e:
        return jsonify({'message': 'Erro interno do servidor'}), 500
    finally:
        connection.close()

@app.route('/api/achievements', methods=['GET'])
@token_required
def get_all_achievements(current_user_id):
    connection = get_db_connection()
    try:
        with connection.cursor() as cursor:
            cursor.execute(
                """SELECT a.id, a.name, a.description, s.name as stage_name
                   FROM achievements a
                   JOIN stages s ON a.stage_id = s.id
                   ORDER BY a.id"""
            )
            
            achievements = cursor.fetchall()
            
            return jsonify({
                'achievements': achievements,
                'total': len(achievements)
            }), 200
            
    except Exception as e:
        return jsonify({'message': 'Erro interno do servidor'}), 500
    finally:
        connection.close()

@app.route('/api/leaderboard', methods=['GET'])
@token_required
def get_leaderboard(current_user_id):
    connection = get_db_connection()
    try:
        with connection.cursor() as cursor:
            cursor.execute(
                """SELECT u.id, u.username, COUNT(ua.achievement_id) as achievement_count
                   FROM users u
                   LEFT JOIN user_achievements ua ON u.id = ua.user_id
                   GROUP BY u.id, u.username
                   ORDER BY achievement_count DESC
                   LIMIT 10"""
            )
            
            leaderboard = cursor.fetchall()
            
            return jsonify({
                'leaderboard': leaderboard
            }), 200
            
    except Exception as e:
        return jsonify({'message': 'Erro interno do servidor'}), 500
    finally:
        connection.close()

@app.route('/api/user/stats/<int:user_id>', methods=['GET'])
@token_required
def get_user_stats(current_user_id, user_id):
    connection = get_db_connection()
    try:
        with connection.cursor() as cursor:
            cursor.execute("SELECT COUNT(*) as total_achievements FROM user_achievements WHERE user_id = %s", (user_id,))
            achievements_count = cursor.fetchone()['total_achievements']
            
            cursor.execute("SELECT COUNT(*) as total_stages FROM user_progress WHERE user_id = %s", (user_id,))
            stages_completed = cursor.fetchone()['total_stages']
            
            cursor.execute("SELECT COUNT(*) as total_available FROM achievements")
            total_achievements = cursor.fetchone()['total_available']
            
            cursor.execute("SELECT COUNT(*) as total_stages FROM stages")
            total_stages = cursor.fetchone()['total_stages']
            
            return jsonify({
                'user_id': user_id,
                'achievements_earned': achievements_count,
                'total_achievements': total_achievements,
                'stages_completed': stages_completed,
                'total_stages': total_stages,
                'completion_percentage': round((achievements_count / total_achievements * 100), 2) if total_achievements > 0 else 0
            }), 200
            
    except Exception as e:
        return jsonify({'message': 'Erro interno do servidor'}), 500
    finally:
        connection.close()

@app.route('/api/endpoints', methods=['GET'])
def list_endpoints():
    endpoints = []
    for rule in app.url_map.iter_rules():
        if rule.endpoint != 'static':
            endpoints.append({
                'endpoint': rule.rule,
                'methods': sorted(list(rule.methods - {'HEAD', 'OPTIONS'})),
                'description': get_endpoint_description(rule.rule)
            })
    
    return jsonify({
        'total_endpoints': len(endpoints),
        'endpoints': sorted(endpoints, key=lambda x: x['endpoint'])
    }), 200

def get_endpoint_description(endpoint):
    descriptions = {
        '/api/register': 'Registrar novo usuario',
        '/api/login': 'Fazer login e obter token JWT',
        '/api/progress': 'Completar uma fase do jogo',
        '/api/achievements/<int:user_id>': 'Ver conquistas de um usuario especifico',
        '/api/achievements': 'Listar todas as conquistas disponiveis',
        '/api/leaderboard': 'Ver ranking dos 10 melhores jogadores',
        '/api/user/stats/<int:user_id>': 'Ver estatisticas detalhadas do usuario',
        '/api/endpoints': 'Listar todos os endpoints da API'
    }
    return descriptions.get(endpoint, 'Endpoint da API')

if __name__ == '__main__':
    app.run(debug=True, host='0.0.0.0', port=5000)
