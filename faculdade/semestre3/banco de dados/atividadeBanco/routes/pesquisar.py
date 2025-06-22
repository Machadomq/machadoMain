from flask import request, jsonify
from database import documentos

def pesquisar_por_nome():
    try:
        nome_pesquisa = request.args.get('nome', '').strip()
        
        if not nome_pesquisa:
            return jsonify({
                'erro': 'Parâmetro nome é obrigatório',
                'status': 'erro'
            }), 400
        
        resultados = []
        for doc in documentos:
            if nome_pesquisa.lower() in doc.nome.lower():
                resultados.append(doc.to_dict())
        
        return jsonify({
            'resultados': resultados,
            'total_encontrados': len(resultados),
            'termo_pesquisa': nome_pesquisa,
            'status': 'sucesso'
        }), 200
        
    except Exception as e:
        return jsonify({
            'erro': f'Erro interno do servidor: {str(e)}',
            'status': 'erro'
        }), 500

def pesquisar_por_rua():
    try:
        rua_pesquisa = request.args.get('rua', '').strip()
        
        if not rua_pesquisa:
            return jsonify({
                'erro': 'Parâmetro rua é obrigatório',
                'status': 'erro'
            }), 400
        
        resultados = []
        for doc in documentos:
            if rua_pesquisa.lower() in doc.rua.lower():
                resultados.append(doc.to_dict())
        
        return jsonify({
            'resultados': resultados,
            'total_encontrados': len(resultados),
            'termo_pesquisa': rua_pesquisa,
            'status': 'sucesso'
        }), 200
        
    except Exception as e:
        return jsonify({
            'erro': f'Erro interno do servidor: {str(e)}',
            'status': 'erro'
        }), 500

def pesquisar_por_compras():
    try:
        produto_pesquisa = request.args.get('produto', '').strip()
        
        if not produto_pesquisa:
            return jsonify({
                'erro': 'Parâmetro produto é obrigatório',
                'status': 'erro'
            }), 400
        
        resultados = []
        for doc in documentos:
            produtos_encontrados = []
            if isinstance(doc.produtos_comprados, list):
                for produto in doc.produtos_comprados:
                    if produto_pesquisa.lower() in str(produto).lower():
                        produtos_encontrados.append(produto)
            else:
                if produto_pesquisa.lower() in str(doc.produtos_comprados).lower():
                    produtos_encontrados.append(doc.produtos_comprados)
            
            if produtos_encontrados:
                doc_dict = doc.to_dict()
                doc_dict['produtos_encontrados'] = produtos_encontrados
                resultados.append(doc_dict)
        
        return jsonify({
            'resultados': resultados,
            'total_encontrados': len(resultados),
            'termo_pesquisa': produto_pesquisa,
            'status': 'sucesso'
        }), 200
        
    except Exception as e:
        return jsonify({
            'erro': f'Erro interno do servidor: {str(e)}',
            'status': 'erro'
        }), 500
