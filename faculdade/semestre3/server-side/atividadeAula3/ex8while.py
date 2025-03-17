lista = [1, 2, 30, 4, 5, 6, 7, 8, 9, 10, 2, 5, 7, 8, 2, 4, 5]
lista_unica = []
i = 0

while i < len(lista):
    if lista[i] not in lista_unica:
        lista_unica.append(lista[i])
    i += 1

print(lista_unica)