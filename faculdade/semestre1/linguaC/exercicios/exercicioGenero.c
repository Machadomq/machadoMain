#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

int main()
{
    char letra;
    int valido = 0;

    while (!valido) {
        printf("digite o seu genero (M ou F):");
        scanf(" %c", &letra);
        fflush(stdin);
        letra = toupper((unsigned char)letra);
        if (letra == 'M' || letra == 'F') {
            valido = 1;
        } else {
            printf("Valor invalido tente novamente\n");
        }
    }
    switch (letra)
    {
        case 'M':
            printf("Seu genero é masculino");
            break;
        case 'F':
            printf("Seu genero é Feminino");
            break;
    default:
        break;
    }
    return 0;
}

