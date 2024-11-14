package dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JTextField;

import model.Moto;

public class MotoDAO {
		
	public void salvar(Moto m) throws ClassNotFoundException, SQLException {
		
		String sql = "insert into "
					+"moto (chassi, marca, modelo, ano, cilindradaMoto, marcaMotorMoto, preco) values (?, ?, ?, ?, ?, ?, ?)";
		
		//Conectar ao BD
		
		ConexaoMySQL conexao = new ConexaoMySQL();
		
		Connection con = conexao.conectar();
		
		
		//Definir dados que serão gravados na(s) tabela(s)
		
		PreparedStatement comando = con.prepareStatement(sql);
		
		comando.setString(1, m.getChassi());//Chassi Moto
		
		comando.setString(2, m.getMarca());//Marca
		
		comando.setString(3, m.getModeloMoto());//Modelo da moto
		
		comando.setInt(4, m.getAno());//Ano da moto
		
		comando.setInt(5, m.getCilindrada());//Cilindrada da moto
		
		comando.setString(6, m.getMarcaMotor());//Marca do motor
		
		comando.setFloat(7, m.getPreco());//Preco da moto
		
		//Executar o comando SQL
		comando.execute();
		
		//Fechar a conexão com o BD
		con.close();
		
	}
	
	public void alterar(Moto m, String chassiAntigoMoto) throws ClassNotFoundException, SQLException {
	
		//Comando para atualizar o BD: update
		String sql = "update moto set "
					+"chassi='?', marca='?', modelo='?', ano=?, cilindradadaMoto=?, marcaMotorMoto='?', preco=? "
					+"where chassi like '?'";
		
			//Criar conexão com o BD
			ConexaoMySQL conexao = new ConexaoMySQL();
			
			//Conectar ao BD
			Connection con = conexao.conectar();
			
				//Comando que executa o comando *sql
			
			PreparedStatement comando = con.prepareStatement(sql);
			
			//Comando para substituir a *?*
			
				//Chassi
				comando.setString(1, m.getChassi());
				
				//Marca
				comando.setString(2, m.getMarca());
				
				//Modelo
				comando.setString(3, m.getModeloMoto());
				
				//Ano
				comando.setInt(4, m.getAno());
				
				//Cilindrada
				comando.setInt(5, m.getCilindrada());
				
				//Marca do Motor
				comando.setString(6, m.getMarcaMotor());
				
				//Preco
				comando.setFloat(7, m.getPreco());
				
				//Antigos-----------------------------------------
				
				//Chassi antigo
				comando.setString(8, chassiAntigoMoto);
					
					//Executar o comando SQL
					comando.execute();
					
						//Fechar a conexão com o BD
						con.close();
		
	}
	
	public void delete (Moto m) throws ClassNotFoundException, SQLException {
		//Comando para deletar atributos da tabela: delete
		String sql = "delete from moto "
					+"where chassi like '?' and marca like '?' and modelo '?' and ano like ? and cilindradaMoto like ? and marcaMotorMoto like '?'";
			
		//Criar conexao com o BD
			ConexaoMySQL conexao = new ConexaoMySQL();
			
		//Conectar ao BD
			Connection con = conexao.conectar();
		
		//Comando que roda o código do *sql
			
		PreparedStatement comando = con.prepareStatement(sql);
		
		//Comandos que substitui os *?*
		
		//Deletar Chassi
		comando.setString(1, m.getChassi());
		
		//Deletar marca
		comando.setString(2, m.getMarca());
		
		//Deletar modelo
		comando.setString(3, m.getModeloMoto());
		
		//Deletar ano
		comando.setInt(4, m.getAno());
		
		//Deletar Cilindrada
		comando.setInt(5, m.getCilindrada());
		
		//Deletar Marca Motor
		comando.setString(6, m.getMarcaMotor());
		
			//Executar os comandos
			comando.execute();
			
				//Fechar conexão com o BD
				con.close();
	
	}
	
	//select -> mostrar dados das motos no banco de dados
	public ArrayList<Moto> listar (Moto m) throws ClassNotFoundException, SQLException{
		
		//Comando sql SELECT(Read)
		String sql = "select chassi, marca, modelo, ano, cilindradaMoto, marcaMotorMoto, preco "
						+"from moto ";
		
		//Criar o objeto para conexão com o BD
		ConexaoMySQL conexao = new ConexaoMySQL();
		
		//Conectar ao BD
		Connection con = conexao.conectar();
		
		//Objeto que constroi o comando SQL
		PreparedStatement comando = con.prepareStatement(sql);
		
		//Array list
		ArrayList<Moto> resultado = new ArrayList<Moto>();
		//ResultSer -> conjunto de dados do Select
		ResultSet rs = comando.executeQuery();
		
		//.next() -> próximo resultado do ResultSet
		while(rs.next()) {//Repedir o número de linhas do BD
			
			  //Moto m1 = new Moto(rs.getString("chassi").....) <-- Outra maneira de fazer 
				Moto m1 = new Moto();
				m1.setChassi(rs.getString("chassi"));
				m1.setMarca(rs.getString("marca"));
				m1.setModeloMoto(rs.getString("modelo"));
				m1.setAno(rs.getInt("ano"));
				m1.setCilindrada(rs.getInt("cilindrada"));
				m1.setMarcaMotor(rs.getString("marcaMotorMoto"));
				m1.setPreco(rs.getFloat("preco"));
				resultado.add(m1);
			
					//Repete enquanto o .next() == true
		}
		
			con.close();
			return resultado;
		
	}
}
