package ex2;

public class Main {
	public static void main(String[] args) {
		Agenda agenda = new Agenda();

		agenda.armazenaPessoa("João", 25, 1.75f);
		agenda.armazenaPessoa("Maria", 30, 1.65f);
		agenda.armazenaPessoa("Pedro", 20, 1.80f);

		agenda.imprimeAgenda();

		System.out.println("Buscando Maria: " + agenda.buscaPessoa("Maria"));

		agenda.imprimePessoa(1);

		agenda.removePessoa("Pedro");

		agenda.imprimeAgenda();
	}
}
