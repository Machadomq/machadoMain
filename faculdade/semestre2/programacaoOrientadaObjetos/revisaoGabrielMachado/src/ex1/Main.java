package ex1;

import java.time.LocalDate;

public class Main {

	public static void main(String[] args) {

		Pessoa pessoa = new Pessoa("Gabriel Machado Queiroz", LocalDate.of(2004, 01, 29), 1.70);
		
		pessoa.imprimirIdade();
	}
}
