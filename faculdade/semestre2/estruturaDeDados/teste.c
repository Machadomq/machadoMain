#include <stdio.h>

int main() {
    const int TAMANHO = 6; // Tamanho da lista
    double numeros[TAMANHO]; // Lista estática para armazenar números reais
    double soma = 0.0;
    
    // Solicitar ao usuário que insira os números
    for (int i = 0; i < TAMANHO; i++) {
        printf("Digite o número %d: ", i + 1);
        scanf("%lf", &numeros[i]); // Usar %lf para ler números reais (double)
        soma += numeros[i]; // Somar os números
    }
    
    // Calcular a média
    double media = soma / TAMANHO;
    
    // Exibir a média
    printf("A média dos números é: %.2lf\n", media); // %.2lf exibe dois decimais
    
    return 0;
}
