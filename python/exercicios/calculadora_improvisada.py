print("-" * 4, "Calculadora Estranha", "-" * 4)
print()
primeiro_valor = float(input("Digite o primeiro valor:"))
operacao = input(
    """Qual operação voce quer realizar? 
[somar (+)]
[subtrair (-)]
[multiplicar (x)]
[dividir (/)]
Digite sua opção pelo simbolo:"""
)
segundo_valor = float(input("Segundo valor:"))

if operacao == "+":
    resultado = primeiro_valor + segundo_valor
elif operacao == "-":
    resultado = primeiro_valor - segundo_valor
elif operacao == "x":
    resultado = primeiro_valor * segundo_valor
elif operacao == "/":
    resultado = primeiro_valor / segundo_valor

print("Seu resultado é:", resultado)
while operacao != "parar":
    operacao = input("digite uma expressão para continuar ou de enter encerrar:")
    if operacao == "":
        break
    numero = float(input("Digite seu numero:"))
    if operacao == "+":
        resultado = resultado + numero
    elif operacao == "-":
        resultado = resultado - numero
    elif operacao == "x":
        resultado = resultado * numero
    elif operacao == "/":
        resultado = resultado / numero

    print("Seu resultado é:", resultado)
