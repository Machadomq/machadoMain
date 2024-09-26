package ex4;

public class Main {
	public static void main(String[] args) {
		Televisao tv = new Televisao();
		ControleRemoto controle = new ControleRemoto(tv);

		controle.aumentarVolume();
		controle.consultarVolume();

		controle.diminuirVolume();
		controle.consultarVolume();

		controle.aumentarCanal();
		controle.consultarCanal();

		controle.trocarCanal(10);
		controle.consultarCanal();
	}
}
