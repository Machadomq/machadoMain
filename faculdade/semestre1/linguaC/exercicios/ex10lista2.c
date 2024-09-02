#include <stdio.h>
#include <stdlib.h>

int main(){

float num1, num2, resultado;
int operador;

printf("Digite o primeiro numero:");
scanf("%f", &num1);

printf("Digite o operador:\n");
printf("[1] Adicao\n[2] subtracao\n[3] divisao\n[4] multiplicacao\n[5] fim\n");
printf("opcao:");
scanf("%i",&operador );

printf("Digite o segundo numero:");
scanf("%f", &num2);

if (operador==1){
    resultado=num1 + num2;
}
else if(operador==2){
    resultado= num1 - num2;
}
else if(operador==3){
    if (num2==0){
        printf("Divisao impossivel\n");
    }
    else{
    resultado = num1 /num2;
    }
}
else if(operador==4){
    resultado= num1 * num2;
}
else if(operador==5){
    printf("Fim");
}
else{
    printf("Valor invalido.");
}

printf("resultado:%.2f", resultado);
return 0;
}