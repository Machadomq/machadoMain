package Consulta;

import java.util.Scanner;

public class Entidades {

	private int clienteNumero;
	private double saldo = 0;
	private String clienteNome;
	
	public Entidades (int clienteNumero) {
		
		this.clienteNumero= clienteNumero;
		this.saldo = 0;
	}
	
	public int getClienteNumero() {
		return clienteNumero;
	}
	
	public String getClienteNome(){
		return clienteNome;
	}
	
	public void setClienteNome(String novoNome) {
		this.clienteNome = novoNome;
	}
	
	public double getSaldo(){
		return saldo;
	}
	
	public void saque(double saque) {
		this.saldo-=saque;
		this.saldo-=5;
	}
	
	public void deposito(double deposito) {
		this.saldo+=deposito;
	}
	
	//----------------------------------------------------------------------
	 Scanner sc = new Scanner(System.in);

	    public void mudarNome() {
	        System.out.println("Digite um novo nome: ");
	        sc.nextLine();
	        String nome = sc.nextLine();
	        setClienteNome(nome);
	    }

	    public void pedirSaldoInicial() {
	        System.out.println("Digite o deposito inicial:");
	        saldo=sc.nextDouble();
	    }
	
}


