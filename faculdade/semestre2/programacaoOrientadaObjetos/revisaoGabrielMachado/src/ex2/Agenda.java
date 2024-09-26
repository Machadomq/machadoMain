package ex2;

public class Agenda {
	Pessoa[] pessoas;
	int contador;

	public Agenda() {
		pessoas = new Pessoa[10];
		contador = 0;
	}

	public void armazenaPessoa(String nome, int idade, float altura) {
		if (contador < 10) {
			pessoas[contador] = new Pessoa(nome, idade, altura);
			contador++;
		} else {
			System.out.println("Agenda cheia!");
		}
	}

	public void removePessoa(String nome) {
		for (int i = 0; i < contador; i++) {
			if (pessoas[i].nome.equalsIgnoreCase(nome)) {

				for (int j = i; j < contador - 1; j++) {
					pessoas[j] = pessoas[j + 1];
				}
				pessoas[contador - 1] = null;
				contador--;
				System.out.println("Pessoa removida com sucesso.");
				return;
			}
		}
		System.out.println("Pessoa não encontrada.");
	}

	public int buscaPessoa(String nome) {
		for (int i = 0; i < contador; i++) {
			if (pessoas[i].nome.equalsIgnoreCase(nome)) {
				return i;
			}
		}
		return -1;
	}

	public void imprimeAgenda() {
		if (contador == 0) {
			System.out.println("Agenda vazia.");
			return;
		}
		for (int i = 0; i < contador; i++) {
			System.out.print((i + 1) + ". ");
			pessoas[i].imprimePessoa();
		}
	}

	public void imprimePessoa(int index) {
		if (index >= 0 && index < contador) {
			pessoas[index].imprimePessoa();
		} else {
			System.out.println("Índice inválido.");
		}
	}
}
