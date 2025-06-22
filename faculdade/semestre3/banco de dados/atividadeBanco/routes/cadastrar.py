from flask import request, jsonify
from models import Documento
from database import documentos

def cadastrar_documento():
    try:
        dados = request.get_json()
        
        campos_obrigatorios = ['nome', 'rua', 'endereco_completo', 'produtos_comprados']
        for campo in campos_obrigatorios:
            if campo not in dados or not dados[campo]:
                return jsonify({
                    'erro': f'Campo {campo} é obrigatório',
                    'status': 'erro'
                }), 400
        
        novo_documento = Documento(
            nome=dados['nome'],
            rua=dados['rua'],
            endereco_completo=dados['endereco_completo'],
            produtos_comprados=dados['produtos_comprados'],
            telefone=dados.get('telefone'),
            email=dados.get('email')
        )
        
        documentos.append(novo_documento)
        
        return jsonify({
            'mensagem': 'Documento cadastrado com sucesso',
            'documento': novo_documento.to_dict(),
            'status': 'sucesso'
        }), 201
        
    except Exception as e:
        return jsonify({
            'erro': f'Erro interno do servidor: {str(e)}',
            'status': 'erro'
        }), 500
