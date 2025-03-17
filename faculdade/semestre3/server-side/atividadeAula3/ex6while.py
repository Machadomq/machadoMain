numeros = [1, 2, 3, 4, 5, 6, 7, 8, 99, 10]
maior = numeros[0]
i = 0

while i < len(numeros):
    if numeros[i] > maior:
        maior = numeros[i]
    i += 1

print(maior)