string = "palavra"
string_invertida = ""
i = len(string) - 1

while i >= 0:
    string_invertida += string[i]
    i -= 1

print(string_invertida)