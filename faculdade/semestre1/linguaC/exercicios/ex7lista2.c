

#include <stdio.h>
#include <stdlib.h>

int main(void)
{

    char letra;

    printf("Digite uma letra:");
    scanf("%c", &letra);
    switch (letra)
    {
    case 'a':
    case 'e':
    case 'i':
    case 'o':
    case 'u':
        printf("Uma vogal");
        break;
    default:
        printf("uma consoante");
        break;
    }

    return 0;
}