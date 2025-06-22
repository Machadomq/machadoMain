from flask import Flask
from flask_cors import CORS
from routes.cadastrar import cadastrar_documento
from routes.pesquisar import pesquisar_por_nome, pesquisar_por_rua, pesquisar_por_compras
from routes.geral import listar_todos_documentos, home

app = Flask(__name__)
CORS(app)

app.route('/cadastrar', methods=['POST'])(cadastrar_documento)
app.route('/pesquisar_nome', methods=['GET'])(pesquisar_por_nome)
app.route('/pesquisar_rua', methods=['GET'])(pesquisar_por_rua)
app.route('/pesquisar_compras', methods=['GET'])(pesquisar_por_compras)
app.route('/listar_todos', methods=['GET'])(listar_todos_documentos)
app.route('/', methods=['GET'])(home)

if __name__ == '__main__':
    print(" Iniciando API de Documentos...")
    print(" Endpoints disponíveis:")
    print("   POST /cadastrar")
    print("   GET  /pesquisar_nome?nome=<nome>")
    print("   GET  /pesquisar_rua?rua=<rua>")
    print("   GET  /pesquisar_compras?produto=<produto>")
    print("   GET  /listar_todos")
    print("   GET  / (informações da API)")
    print(" Servidor rodando em: http://localhost:5000")
    app.run(debug=True, host='0.0.0.0', port=5000)
