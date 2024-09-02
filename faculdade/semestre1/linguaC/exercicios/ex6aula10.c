#include <stdio.h>

int main(void)
{
    int l, c;
    int matrizA[3][3]={
        {1, 7, 3},
        {4, 5, 6},
        {3, 8, 5}};

    int matrizB[3][3]={
        {10, 20, 30},
        {40, 50, 60},
        {70, 80, 90}};

    int matrizC[3][3];

    for (l = 0; l < 3; l++)
    {
        for (c = 0; c < 3; c++)
        {
            matrizC[l][c] = matrizA[l][c] + matrizB[l][c];
        }
    }


  for (l = 0; l < 3; l++)
    {
        for (c = 0; c < 3; c++)
        {
           printf("[%i] ", matrizC[l][c]);
        }
        printf("\n");
    }
    
}