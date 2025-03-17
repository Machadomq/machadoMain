maior=0
lista=[1,2,3,4,5,6,7,8,99,10]
for i in lista:
    if i<maior:
        print("nao esta em ordem crescente")
        break
    maior=i
else:
    print("esta em ordem crescente")