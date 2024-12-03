package dados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMySQL {
	//Atributos de acesso ao banco de dados
	
	private String database = "concessionaria"; // Nome do Banco de Dados
	private String usuario = "root"; //Nome do usu�rio de acesso
	private String senha = "1213"; //Senha para acessar o Banco de Dados
	
	// Url � o endere�o do servidor MySQL
	
	private String url = "jdbc:mysql://localhost:3306/"+database;
	
	//Criar m�todos 
	
	public Connection conectar() throws ClassNotFoundException, SQLException {
		//Carregar a API
		Class.forName("com.mysql.cj.jdbc.Driver");
		//Fazer a conex�o
		Connection conexao = DriverManager.getConnection(url, usuario, senha);
		return conexao;
	}
}
