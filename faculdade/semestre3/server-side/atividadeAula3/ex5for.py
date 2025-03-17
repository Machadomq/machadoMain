acumulador=1
acumuladorAnterior=0
for i in range(0,10):
    proximo=acumulador+acumuladorAnterior
    acumuladorAnterior=acumulador
    acumulador=proximo
    print(proximo)
