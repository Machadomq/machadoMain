#include <stdio.h>
#include <stdlib.h>

int main()
{

    char opcao;

    printf("Em que turno vc estuda (M, V ou N):");
    scanf("%c", &opcao);

    switch (opcao)
    {
    case 'M':
        printf("Bom dia");
        break;

    case 'V':
        printf("Boa tarde");
        break;

    case 'N':
        printf("Boa noite");
        break;

    default:
        printf("Valor invalido");
        break;
    }
}