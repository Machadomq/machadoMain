package ex2;

public class Pessoa {
	String nome;
	int idade;
	float altura;

	public Pessoa(String nome, int idade, float altura) {
		this.nome = nome;
		this.idade = idade;
		this.altura = altura;
	}

	public void imprimePessoa() {
		System.out.println("Nome: " + nome + ", Idade: " + idade + ", Altura: " + altura);
	}
}