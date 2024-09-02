#include <stdio.h>

int main(void)
{
    int l, c;
    int matrizA[5][5]={
        {1, 7, 3, 4, 5},
        {4, 5, 6, 7, 8},
        {3, 8, 5, 6, 7},
        {9, 7, 6, 4, 2},
        {1, 2, 3, 4, 5}};

    int matrizB[5][5]={
        {10, 70, 30, 40, 50},
        {40, 50, 60, 70, 80},
        {30, 80, 50, 60, 70},
        {40, 50, 60, 70, 80},
        {30, 80, 50, 60, 70}};

    int matrizC[5][5];

    for (l = 0; l < 5; l++)
    {
        for (c = 0; c < 5; c++)
        {
            matrizC[l][c] = matrizB[l][c] - matrizA[l][c];
        }
    }

  for (l = 0; l < 5; l++)
    {
        for (c = 0; c < 5; c++)
        {
           printf("[%i] ", matrizC[l][c]);
        }
        printf("\n");
    }
    
}