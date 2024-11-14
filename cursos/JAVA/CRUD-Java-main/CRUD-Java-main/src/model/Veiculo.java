package model;

public class Veiculo{
	private String chassi; //Chassi do Veículo
	private String marca; //Marca do Veículo
	private String cor; // Cor do Veículo
	private String placa; // Placa do Veículo
	private String tipoMarcha; //Automático ou manual
	private Integer potencia; //Quantidade de cavalos do veículo
	private Integer ano; // Ano do Veículo
	private Float preco; // Preço do Veículo
	private Float kilometragem; //Km's rodas por veículo
	
	
	//MÉTODO CONSTRUTOR
	public Veiculo(String chassi, String marca, Integer ano, Float preco) {
		super();
		setChassi(chassi);
		setMarca(marca);
		setAno(ano);
		setPreco(preco);
	}
	
	//CONSTRUTOR SEM PARAMETROS
	public Veiculo() {
		// TODO Auto-generated constructor stub
	}
	
	//GET-SET Chassi
	public String getChassi() {
		return chassi;
	}
	public void setChassi(String chassi) {
			this.chassi = chassi;
	}
	//---------------------------
	
	//GET-SET Marca
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
			this.marca = marca;
	}
	//---------------------------
	
	//GET-SET Ano
	public Integer getAno() {
		return ano;
	}
	public boolean setAno(Integer ano) {
		if(ano > 1900) {
			this.ano = ano;
		return true;
		}
			else {
				return false;
			}
	}
	//---------------------------
	
	//GET-SET Preco
	public Float getPreco() {
		return preco;
	}
	public boolean setPreco(Float preco) {
		if(preco > 0) {
			this.preco = preco;
		return true;
		}
			else {
				return false;
			}
	}

	//-------------------------------------------
	
	//GET-SET Cor do Veículo
	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	//-------------------------------------------
	
	//GET-SET Placa do Veículo
	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	//-------------------------------------------
	
	//GET-SET Tipo da marcha do Veículo
	public String getTipoMarcha() {
		return tipoMarcha;
	}

	public void setTipoMarcha(String tipoMarcha) {
		this.tipoMarcha = tipoMarcha;
	}

	//-------------------------------------------
	
	//GET-SET Potência do Veículo
	public Integer getPotencia() {
		return potencia;
	}

	public void setPotencia(Integer potencia) {
		this.potencia = potencia;
	}

	//-------------------------------------------
	
	//GET-SET Kilometragem do Veículo
	public Float getKilometragem() {
		return kilometragem;
	}

	public void setKilometragem(Float kilometragem) {
		this.kilometragem = kilometragem;
	}
	
	
	
}
