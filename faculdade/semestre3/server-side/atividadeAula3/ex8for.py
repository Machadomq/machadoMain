lista=[1,2,3,4,5,6,7,7,7,8,9,10,2,5,7,8,2,4,5]
listaUnica=[]

for i in lista:
    if i not in listaUnica:
        listaUnica.append(i)
print(listaUnica)