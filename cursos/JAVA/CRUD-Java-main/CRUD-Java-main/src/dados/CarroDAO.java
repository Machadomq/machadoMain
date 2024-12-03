package dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Carro;

public class CarroDAO {
	
	public void salvar(Carro c) throws SQLException, ClassNotFoundException {
	
		String sql = "insert into "
					+ "carro(chassi, marca, modelo, ano, preco) values (?, ?, ?, ?, ?)";
		//Conectar ao BD
	
		ConexaoMySQL conexao = new ConexaoMySQL();
	
		Connection con = conexao.conectar();
	
		//Definir dados que serao gravados na(s) tabela(s)
	
		PreparedStatement comando = con.prepareStatement(sql);
	
			comando.setString(1, c.getChassi());//Chassi
		
			comando.setString(2, c.getMarca());//Marca 
		
			comando.setString(3, c.getModelo());//Modelo
		
			comando.setInt(4, c.getAno());//Ano
		
			comando.setFloat(5, c.getPreco());//Preco
	
				//Executar o comando SQL
				comando.execute();
	
					//Fechar a conexao com o BD
					con.close();
	
	}
	
	public void alterar(Carro c, String chassiAntigo) throws ClassNotFoundException, SQLException {
		//Comando para atualizar o BD: uptade
		String sql = "update carro set "
						+"chassi='?', marca='?', modelo='?', ano=?, preco=? "
						+"where chassi like '?'";
		
		//Criar conex�o com o BD
		ConexaoMySQL conexao = new ConexaoMySQL();
		
		//Conectar ao BD
		Connection con = conexao.conectar();
		
			//Comando que faz o comando *sql
		
		PreparedStatement comando = con.prepareStatement(sql);
		
		//Comando para substituir a *?*
		
			//Chassi
			comando.setString(1, c.getChassi());
		
			//Marca
			comando.setString(2, c.getMarca());
		
			//Modelo
			comando.setString(3, c.getModelo());
		
			//Ano
			comando.setInt(4, c.getAno());
			
			//Preco
			comando.setFloat(5, c.getPreco());
			
			//Antigo---------------------
		
			//Chassi antigo
			comando.setString(6, chassiAntigo);
		
				//Executar os comandos
				comando.execute();
				
					//Fechar conexao
					con.close();
	}
	
	public void delete(Carro c) throws ClassNotFoundException, SQLException {
			//Comando para deletar coisas da tabela
			String sql = "delete from carro "
						+"where chassi like '?'";
			
			//Criar conex�o com o BD
			ConexaoMySQL conexao = new ConexaoMySQL();
			
			//Conectar ao BD
			Connection con = conexao.conectar();
			
				//Comando que faz o comando *sql
			
			PreparedStatement comando = con.prepareStatement(sql);
			
			//Comando que substitui os *?*
			
			//Deletar Chassi
			comando.setString(1, c.getChassi());
			
				//Executar os comandos
				comando.execute();
				
					//Fechar conex�o
					con.close();
	}
	
	//Comando select
	public ArrayList<Carro> listar (Carro c) throws ClassNotFoundException, SQLException {
		//Comando SQL para o Insert
		
		String sql = "select chassi, marca, modelo, ano, preco "
						+"from carro ";
		
		//Criar conex�o com o BD
		ConexaoMySQL conexao = new ConexaoMySQL();
		//Conectar ao BD
		Connection con = conexao.conectar();
		//Criar um objeto que constrou o comando SQL
		PreparedStatement comando = con.prepareStatement(sql);
		
		ArrayList<Carro> resultado = new ArrayList<Carro>();
		//ResultSet -> conjunto de dados do Select
		ResultSet rs = comando.executeQuery();
		
		//.next() -> pr�ximo resultado do ResultSet
		while(rs.next()) {
				
				Carro c1 = new Carro();
				c1.setChassi(rs.getString("chassi"));
				c1.setMarca(rs.getString("marca"));
				c1.setModelo(rs.getString("modelo"));
				c1.setAno(rs.getInt("ano"));
				c1.setPreco(rs.getFloat("preco"));
				resultado.add(c1);
		
		}//Vai repetir enquanto o .next() == true
		
		
		
		con.close();
		return resultado;
		
	}
}
