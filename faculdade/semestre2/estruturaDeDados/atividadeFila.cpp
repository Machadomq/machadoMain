#include <stdio.h>
#include <stdlib.h>
#include <conio.h>

typedef struct pilha {
	int num;
	struct pilha *proximo;
} PILHA;


int main(void) {
	
	PILHA *topo = NULL;
	PILHA *auxiliar;
	
	int opcao;
	
	do {
		system("cls"); // limpa o terminal
		
		printf("\nDigite a opcao: ");
		printf("\n1 - inserir item");
		printf("\n2 - imprimir pilha");
		printf("\n3 - remover da pilha");
		printf("\n4 - esvaziar");
		printf("\n5 - sair");
		printf("\nDigite sua opcao:");
		scanf("%d", &opcao);
		
		fflush(stdin);// limpar o buffer de entrada de dados
		
		
		if (opcao < 0 || opcao > 5) {
			printf("\nOpcao invalida.");
		} else {
			//adicionando item a pilha
			if (opcao == 1){
				printf("Digite o item para colocar na pilha:");
				PILHA *novo = (PILHA*) malloc(sizeof(PILHA));
				
				scanf("%i", &novo->num);
				fflush(stdin);
				
				novo->proximo = topo;
				topo = novo;
				
				printf("numero inserido na pilha (pressione uma tecla para continuar)");
				getch(); //aguarda uma entrada de um caractere
			}
			
			//imprime a pilha
			if (opcao == 2){
				if(topo == NULL) {
					printf("\nPilha vazia");
				} else {
					auxiliar = topo;
					printf("\nImprimindo a pilha");
					
					while(auxiliar != NULL) {
						printf("\n%d", auxiliar->num);
						auxiliar = auxiliar->proximo;
					}
				}
				
				printf("\n(pressione uma tecla para continuar)");
				getch(); //aguarda uma entrada de um caractere
			}
			
			//remove item a pilha
			if (opcao == 3){
				if(topo == NULL) {
					printf("\nPilha vazia");
				} else {
					printf("\n%i removido da pilha...", topo->num);
					topo = topo->proximo;
				}
				printf("\n(pressione uma tecla para continuar)");
				getch(); //aguarda uma entrada de um caractere
			}
			
			//esvaziar a pilha
			if (opcao == 4){
				if(topo == NULL) {
					printf("\nPilha vazia");
				} else {
					topo = NULL;
				}
				printf("\nPilha esvaziada (pressione uma tecla para continuar)");
				getch(); //aguarda uma entrada de um caractere
			}
		}
		
		
		
		
		
		
		
		
	} while(opcao != 5);
return 0;
}