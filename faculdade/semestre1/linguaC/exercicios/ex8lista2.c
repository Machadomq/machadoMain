
#include <stdio.h>
#include <stdlib.h>

int main(void)
{

    int num1, num2, num3, temp;
    printf("Digite tres numeros:");
    scanf("%i %i %i", &num1, &num2, &num3);
    fflush(stdin);

    if (num1 > num2)
    {
        temp = num2;
        num2 = num1;
        num1 = temp;
    }
    if (num2 > num3)
    {
        temp = num3;
        num3 = num2;
        num2 = temp;
    }
    if (num1 > num2)
    {
        temp = num2;
        num2 = num1;
        num1 = temp;
    }
    printf("%i %i %i", num1,num2, num3);
    return 0;

}