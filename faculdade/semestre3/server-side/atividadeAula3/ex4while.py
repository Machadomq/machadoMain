string = "exemplo de string"
vogais = "aeiouAEIOU"
contagem = 0
i = 0

while i < len(string):
    if string[i] in vogais:
        contagem += 1
    i += 1

print(contagem)