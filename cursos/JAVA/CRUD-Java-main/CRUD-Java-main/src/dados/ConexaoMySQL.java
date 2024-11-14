package dados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMySQL {
	//Atributos de acesso ao banco de dados
	
	private String database = "concessionaria"; // Nome do Banco de Dados
	private String usuario = "root"; //Nome do usuário de acesso
	private String senha = "211004cd"; //Senha para acessar o Banco de Dados
	
	// Url é o endereço do servidor MySQL
	
	private String url = "jdbc:mysql://localhost:3306/"+database;
	
	//Criar métodos 
	
	public Connection conectar() throws ClassNotFoundException, SQLException {
		//Carregar a API
		Class.forName("com.mysql.cj.jdbc.Driver");
		//Fazer a conexão
		Connection conexao = DriverManager.getConnection(url, usuario, senha);
		return conexao;
	}
}
