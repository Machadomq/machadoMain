package model;

public class Moto extends Veiculo{
	private int cilindrada; //Cilindrada da moto
	private String marcaMotor; //Marca do motor da moto
	private String modeloMoto; //Modelo da moto
	
	//Construtor da classe
	public Moto(String chassi, String marca, Integer ano, Float preco, int cilindrada, String marcaMotor,
			String modeloMoto) {
		super(chassi, marca, ano, preco);
		this.cilindrada = cilindrada;
		this.marcaMotor = marcaMotor;
		this.modeloMoto = modeloMoto;
	}
	
	public Moto(String chassi) {
	}
	
	public Moto(String text, String text2, String text3, String string, String string2, String text6) {
		// TODO Auto-generated constructor stub
		
	}
	public Moto(String text, String text2, String text3, int parseInt, int parseInt2, String text4) {
		// TODO Auto-generated constructor stub
	}
	public Moto(String text, String text2, String text3, int parseInt, int parseInt2, String text4, float parseFloat) {
		// TODO Auto-generated constructor stub
	}
	
	public Moto() {
		// TODO Auto-generated constructor stub
	}

	//GET-SET Cilindrada
	public int getCilindrada() {
		return cilindrada;
	}
	public void setCilindrada(int cilindrada) {
		this.cilindrada = cilindrada;
	}
	
	//----------------------------------------
	
	//GET-SET Marca
	public String getMarcaMotor() {
		return marcaMotor;
	}
	public void setMarcaMotor(String marcaMotor) {
		this.marcaMotor = marcaMotor;
	
	//----------------------------------------
		
	//GET-SET Modelo da Moto
	}
	public String getModeloMoto() {
		return modeloMoto;
	}
	public void setModeloMoto(String modeloMoto) {
		this.modeloMoto = modeloMoto;
	}
	


}

