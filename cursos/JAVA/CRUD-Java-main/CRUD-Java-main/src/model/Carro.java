package model;

import javax.swing.JTextField;

public class Carro extends Veiculo{
	private Integer portas;
	private String tipoCarro; //hatch ou sedan
	private String tipoBanco; //couro ou tecido
	private Float tamanhoPortaMalas; //100L, 80L...
	private String tipoRoda; //Roda de liga ou Calota
	private String tipoRetrovisor; //Elétrico ou Não Elétrico
	private String tipoCobustivel; //Gasolina ou Diesel
	private String modelo; //Modelo no Carro
	
	
	
	
	//MÉTODO CONSTRUTOR da Classe
	
	public Carro(String chassi, String marca, Integer ano, Float preco, Integer portas, String tipoCarro,
			String tipoBanco, Float tamanhoPortaMalas, String tipoRoda, String tipoRetrovisor, String tipoCobustivel, String modelo) {
		super(chassi, marca, ano, preco);
		this.portas = portas;
		this.tipoCarro = tipoCarro;
		this.tipoBanco = tipoBanco;
		this.tamanhoPortaMalas = tamanhoPortaMalas;
		this.tipoRoda = tipoRoda;
		this.tipoRetrovisor = tipoRetrovisor;
		this.tipoCobustivel = tipoCobustivel;
		this.modelo = modelo;
	}
	
	
	public Carro(String chassi, String marca, String modelo, int ano, float precoVeiculo) {
		// TODO Auto-generated constructor stub
		
		setChassi(chassi);
		setMarca(marca);
		setModelo(modelo);
		setAno(ano);
		setPreco(precoVeiculo);
		
	}


	public Carro(String chassi) {
		// TODO Auto-generated constructor stub
		setChassi(chassi);
	}



	public Carro() {
		// TODO Auto-generated constructor stub
	}


	//GET-SET Portas
	public Integer getPortas() {
		return portas;
	}
	public void setPortas(Integer portas) {
		this.portas = portas;
	}
	
	//-------------------------------------------
	
	//GET-SET Tipo do Carro
	public String getTipoCarro() {
		return tipoCarro;
	}
	public void setTipoCarro(String tipoCarro) {
		this.tipoCarro = tipoCarro;
	
	//-------------------------------------------
	
	//GET-SET Tipo dos Bancos
	}
	public String getTipoBanco() {
		return tipoBanco;
	}
	public void setTipoBanco(String tipoBanco) {
		this.tipoBanco = tipoBanco;
	
	//-------------------------------------------
	
	//GET-SET Tamanho do Porta-malas
	}
	public Float getTamanhoPortaMalas() {
		return tamanhoPortaMalas;
	}
	public void setTamanhoPortaMalas(Float tamanhoPortaMalas) {
		this.tamanhoPortaMalas = tamanhoPortaMalas;
	
	//-------------------------------------------
		
	//GET-SET Tipo das Rodas
	}
	public String getTipoRoda() {
		return tipoRoda;
	}
	public void setTipoRoda(String tipoRoda) {
		this.tipoRoda = tipoRoda;
	
	//-------------------------------------------
		
	//GET-SET Tipo dos Retrovisores
	}
	public String getTipoRetrovisor() {
		return tipoRetrovisor;
	}
	public void setTipoRetrovisor(String tipoRetrovisor) {
		this.tipoRetrovisor = tipoRetrovisor;
	
	//-------------------------------------------
	
	//GET-SET Tipo de Combustivel;
	}
	public String getTipoCobustivel() {
		return tipoCobustivel;
	}
	public void setTipoCobustivel(String tipoCobustivel) {
		this.tipoCobustivel = tipoCobustivel;
	}

	//-------------------------------------------
	
	//GET-SET Modelo do Carro
	public String getModelo() {
		return modelo;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	
}