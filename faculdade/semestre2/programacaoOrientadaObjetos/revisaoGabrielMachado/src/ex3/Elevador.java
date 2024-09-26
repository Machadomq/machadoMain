package ex3;

public class Elevador {

	private int andarAtual;
	private int totalAndares;
	private int capacidade;
	private int pessoasPresentes;

	public void inicializa(int capacidade, int totalAndares) {

		this.capacidade = capacidade;
		this.totalAndares = totalAndares;
		this.andarAtual = 0;
		this.pessoasPresentes = 0;
	}

	public void entra() {

		if (pessoasPresentes < capacidade) {
			pessoasPresentes++;
		} else {
			System.out.println("Elelvador cheio");
		}
	}

	public void sai() {
		if (pessoasPresentes > 0) {
			pessoasPresentes--;
		} else {
			System.out.println("nao ha ninguem no elevador");
		}

	}

	public void sobe() {
		if (andarAtual < totalAndares) {
			andarAtual++;
		} else {
			System.out.println("andar maximo");
		}
	}

	public void desce() {
		if (andarAtual > 0) {
			andarAtual--;
		} else {
			System.out.println("está no terreo");
		}
	}

	public int getAndarAtual() {
		return andarAtual;
	}

	public void setAndarAtual(int andarAtual) {
		if (andarAtual >= 0 && andarAtual <= totalAndares) {
			this.andarAtual = andarAtual;
		}
	}

	public int getTotalAndares() {
		return totalAndares;
	}

	public void setTotalAndares(int totalAndares) {
		this.totalAndares = totalAndares;
	}

	public int getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}

	public int getPessoasPresentes() {
		return pessoasPresentes;
	}

	public void setPessoasPresentes(int pessoasPresentes) {
		if (pessoasPresentes >= 0 && pessoasPresentes <= capacidade) {
			this.pessoasPresentes = pessoasPresentes;
		}
	}

}
