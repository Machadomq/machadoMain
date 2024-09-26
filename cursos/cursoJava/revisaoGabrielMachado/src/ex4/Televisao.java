package ex4;

public class Televisao {
	private int volume;
	private int canal;
	private int maxVolume;
	private int maxCanal;

	public Televisao() {
		this.volume = 10;
		this.canal = 1;
		this.maxVolume = 100;
		this.maxCanal = 99;
	}

	public void aumentarVolume() {
		if (volume < maxVolume) {
			volume++;
		} else {
			System.out.println("Volume máximo atingido!");
		}
	}

	public void diminuirVolume() {
		if (volume > 0) {
			volume--;
		} else {
			System.out.println("Volume já está no mínimo");
		}
	}

	public void aumentarCanal() {
		if (canal < maxCanal) {
			canal++;
		} else {
			canal = 1;
		}
	}

	public void diminuirCanal() {
		if (canal > 1) {
			canal--;
		} else {
			canal = maxCanal;
		}
	}

	public void trocarCanal(int novoCanal) {
		if (novoCanal >= 1 && novoCanal <= maxCanal) {
			canal = novoCanal;
		} else {
			System.out.println("Canal inválido! Selecione um canal entre 1 e " + maxCanal + ".");
		}
	}

	public int consultarVolume() {
		return volume;
	}

	public int consultarCanal() {
		return canal;
	}
}
