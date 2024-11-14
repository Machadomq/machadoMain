package model;

public class Endereco {
	//classe do prof:
	private String logradouro; //rua
	private int numero;
	private String complemento;
	private String bairro;
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		if(logradouro.equals(""))
			this.logradouro = logradouro;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

}
