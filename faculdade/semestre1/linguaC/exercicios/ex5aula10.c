#include <stdio.h>

int main(void){

    int i;
    char palavras [15][100];

    for (i=0; i<15; i++){

        printf("%i) Digite uma palavra:", i+1);
        scanf("%s", palavras[i]);
        fflush(stdin);
    }

     for (i=14; i>=0; i--){
        printf("\n%s", palavras[i]);
     }

}
