#include <stdio.h>
#include <stdlib.h>

int main()
{

    float nota1, nota2, nota3;

    printf("Digite as tres notas do aluno:");
    scanf("%f %f %f", &nota1, &nota2, &nota3);

    float media = (nota1 + nota2 + nota3) / 3;

    if (media == 10)
    {
        printf("aprovado com distincao media: %.2f", media);
    }
    else if (media > 7)
    {
        printf("aprovado media: %.2f", media);
    }
    else if (media < 7)
    {
        printf("reprovado media: %.2f", media);
    }
    else
    {
        printf("Erro");
    }
}