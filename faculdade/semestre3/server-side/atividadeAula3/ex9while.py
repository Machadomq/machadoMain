lista = [1, 2, 3, 4, 5, 6, 7, 8, 99, 10]
crescente = True
i = 0

while i < len(lista) - 1:
    if lista[i] > lista[i + 1]:
        crescente = False
        break
    i += 1

if crescente:
    print("A lista está em ordem crescente")
else:
    print("A lista não está em ordem crescente")