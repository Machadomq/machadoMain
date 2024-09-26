package ex1;

import java.time.LocalDate;
import java.time.Period;

public class Pessoa {

	private String name;
	private LocalDate dataNascimento;
	private double height;

	public Pessoa(String name, LocalDate dataNascimento, double height) {
		this.name = name;
		this.dataNascimento = dataNascimento;
		this.height = height;
	}

	public int calcularIdade() {
		return Period.between(dataNascimento, LocalDate.now()).getYears();
	}

	public void imprimirIdade() {
		System.out.println("Idade: " + calcularIdade() + " anos");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
	
}
