package ex3;

public class Main {
	public static void main(String[] args) {

		Elevador elevador = new Elevador();

		elevador.inicializa(5, 10);

		elevador.entra();
		elevador.entra();
		System.out.println("Pessoas presentes: " + elevador.getPessoasPresentes());

		elevador.sai();
		System.out.println("Pessoas presentes após saída: " + elevador.getPessoasPresentes());

		elevador.sobe();
		elevador.sobe();
		System.out.println("Andar atual: " + elevador.getAndarAtual());

		elevador.desce();
		System.out.println("Andar atual após descer: " + elevador.getAndarAtual());
	}
}
