package dados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMySQL {
	
	
	private String database = "concessionaria"; // Nome do Banco de Dados
	private String usuario = "root"; //Nome do usuario de acesso
	private String senha = "1234"; //Senha para acessar o Banco de Dados
	
	
	
	private String url = "jdbc:mysql://localhost:3306/"+database;
	
		
	public Connection conectar() throws ClassNotFoundException, SQLException {
		//Carregar a API
		Class.forName("com.mysql.cj.jdbc.Driver");
		//Fazer a conexao
		Connection conexao = DriverManager.getConnection(url, usuario, senha);
		return conexao;
	}
}
