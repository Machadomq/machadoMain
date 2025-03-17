itens = ["texto", 123, 45.67, True, None, [1, 2, 3], {"chave": "valor"}, (4, 5), {6, 7}]

print("Lista de itens:")
for i, item in enumerate(itens):
    print(f"{i}: {item}")

indice = int(input("Escolha um índice para ver o elemento: "))
elemento = itens[indice]
print(f"Você escolheu: {elemento}")

tipo_adivinhado = input("Tente adivinhar o tipo do elemento (str, int, float, bool, NoneType, list, dict, tuple, set): ")

tipo_real = type(elemento).__name__

if tipo_adivinhado == tipo_real:
    print("Parabéns, você acertou!")
else:
    print(f"Você errou. O tipo correto é {tipo_real}.")