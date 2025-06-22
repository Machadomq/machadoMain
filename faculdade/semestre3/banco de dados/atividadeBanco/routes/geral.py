from flask import jsonify
from database import documentos

def listar_todos_documentos():
    try:
        todos_documentos = [doc.to_dict() for doc in documentos]
        
        return jsonify({
            'documentos': todos_documentos,
            'total': len(todos_documentos),
            'status': 'sucesso'
        }), 200
        
    except Exception as e:
        return jsonify({
            'erro': f'Erro interno do servidor: {str(e)}',
            'status': 'erro'
        }), 500

def home():
    return jsonify({
        'mensagem': 'API de Documentos - Atividade Banco de Dados',
        'endpoints': {
            'POST /cadastrar': 'Cadastrar novo documento',
            'GET /pesquisar_nome?nome=<nome>': 'Pesquisar por nome',
            'GET /pesquisar_rua?rua=<rua>': 'Pesquisar por rua',
            'GET /pesquisar_compras?produto=<produto>': 'Pesquisar por produto comprado',
            'GET /listar_todos': 'Listar todos os documentos'
        },
        'total_documentos': len(documentos),
        'status': 'ativo'
    }), 200
