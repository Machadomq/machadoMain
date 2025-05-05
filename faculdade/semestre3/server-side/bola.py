class Bola:
    def __init__(self, cor, circunferencia, material):
        self.cor = cor
        self.circunferencia = circunferencia
        self.material = material
    
    def troca_cor(self, nova_cor):
        self.cor = nova_cor
    
    def mostra_cor(self):
        return self.cor

# Exemplo de uso
bola = Bola("Vermelha", 30, "Couro")
print(bola.mostra_cor())  # Saída: Vermelha

bola.troca_cor("Azul")
print(bola.mostra_cor())  # Saída: Azul


class quadrado:
    def __init__(self, lado):
        self.lado=lado
        
    def definir_lado(self, lado):
        self.lado=lado

    def clacilar_area(self):
        return self.lado**2