
#include <stdio.h>

int main()

{
    int i, contador = 0;
    char vetor[10], lista[10];

    for (i = 0; i < 10; i++)
    {

        printf("%i Digite um caracter:", i + 1);
        scanf("%c", &vetor[i]);
        fflush(stdin);

        if (vetor[i] == 'a' || vetor[i] == 'e' || vetor[i] == 'i' || vetor[i] == 'o' || vetor[i] == 'u'){
            lista[i]='-';
        }
        else{
            lista[i] = vetor[i];
            contador += 1;
        }
    };

    printf("\nQuantidade de consoantes:%i", contador);
    printf("\nconsoantes:");

    for (i = 0; i < 10; i++) {
        if (lista[i] != '-') {
            printf("%c ", lista[i]);
        }
    }
    return 0;
}
