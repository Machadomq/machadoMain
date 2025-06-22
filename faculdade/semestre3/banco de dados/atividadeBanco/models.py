from datetime import datetime
import uuid

class Documento:
    def __init__(self, nome, rua, endereco_completo, produtos_comprados, telefone=None, email=None):
        self.id = str(uuid.uuid4())
        self.nome = nome
        self.rua = rua
        self.endereco_completo = endereco_completo
        self.produtos_comprados = produtos_comprados
        self.telefone = telefone
        self.email = email
        self.data_cadastro = datetime.now().isoformat()
    
    def to_dict(self):
        return {
            'id': self.id,
            'nome': self.nome,
            'rua': self.rua,
            'endereco_completo': self.endereco_completo,
            'produtos_comprados': self.produtos_comprados,
            'telefone': self.telefone,
            'email': self.email,
            'data_cadastro': self.data_cadastro
        }
