import random

tupla = (1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
lista = list(tupla)
random.shuffle(lista)
tupla_randomizada = tuple(lista)

print(tupla_randomizada)