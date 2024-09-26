package Consulta;


public class Main {

    public static void main(String[] args) {
    	
    	Entidades cliente = new Entidades(12345);
    	cliente.pedirSaldoInicial();
    	cliente.mudarNome();
    	
    	cliente.deposito(150);
    	System.out.println("Saldo:"+cliente.getSaldo());
    	cliente.saque(50);
    	System.out.println("Saldo:"+cliente.getSaldo());
    	
    	System.out.println("Nome:"+cliente.getClienteNome());
    	System.out.println("Saldo final:"+cliente.getSaldo());
    }
}