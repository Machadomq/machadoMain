

#include <stdio.h>
#include <stdlib.h>

int main()
{

    int dia;

    printf("Digite um numero de um a sete:");
    scanf("%i", &dia);

    switch (dia)
    {
    case 1:
        printf("Domingo"); 
        break;
    case 2:
        printf("segunda"); 
        break;
    case 3:
        printf("terca");
        break;
    case 4:
        printf("quarta");
        break;
    case 5:
        printf("quinta"); 
        break;
    case 6:
        printf("sexta");
        break;
    case 7:
        printf("sabado"); 
        break;

    default:
        printf("valor ivalido");
        break;
    }
    return 0;
}