string="palavra"
stringInvertida=""

for i in range(len(string)-1,-1,-1):
    stringInvertida+=string[i]
    
print(stringInvertida)