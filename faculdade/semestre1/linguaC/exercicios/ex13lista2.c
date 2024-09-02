#include <stdio.h>
#include <stdlib.h>

int main()
{

    int aluno1, aluno2, aluno3, aluno4;
    float media;

    printf("Digite a idade de quatro alunos:");
    scanf("%i %i %i %i", &aluno1, &aluno2, &aluno3, &aluno4);
    fflush(stdin);

    media = (aluno1 + aluno2 + aluno3 + aluno4) / 4;
    printf("media:%.2f\n", media);

    if (media < 25)
    {
        printf("Turma jovem");
    }
    else if (25 <= media && media < 40)
    {
        printf("Turma adulta");
    }
    else if (media > 40)
    {
        printf("Turma idosa");
    }
    return 0;
}