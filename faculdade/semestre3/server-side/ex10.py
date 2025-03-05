turno = input("Em que turno você estuda? Digite M-matutino, V-vespertino ou N-noturno: ").upper()

if turno == "M":
    print("Bom Dia!")
elif turno == "V":
    print("Boa Tarde!")
elif turno == "N":
    print("Boa Noite!")
else:
    print("Valor Inválido!")