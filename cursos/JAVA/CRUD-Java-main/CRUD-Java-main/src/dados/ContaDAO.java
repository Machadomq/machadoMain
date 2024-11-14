package dados;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//conexão:
import java.sql.Connection;

//conta:
import model.Conta;

public class ContaDAO {
	//DAO -> Data access object
	//CRUD - salvar() alterar() excluir()
	//método salvar:
	public void salvar(Conta c) throws SQLException, ClassNotFoundException {
		String SQL = "insert into " +"conta(nome, cpf, fone, dataNasc) values (?, ?, ?, ?)";
		//conectar ao banco de dados:
		ConexaoMySQL conexao = new ConexaoMySQL();
		//connection = static
		Connection con = conexao.conectar();
		//definir dados gravados:
		PreparedStatement comando = con.prepareStatement(SQL);
		//? = 1 NOME
		comando.setString(1, c.getNome());
		//? = 2 CPF
		comando.setString(2, c.getCpf());
		//? = 3 FONE
		comando.setLong(3, c.getFone());
		//? = 4 DATANASC
		comando.setDate(4, new java.sql.Date(c.getDataNasc().getTime()));
		//executar o comando em SQL:
		comando.execute();
		//fechando conexão:
		con.close();
	}
	//método update:
	public void alterar(Conta c, String nomeAntigo) throws ClassNotFoundException, SQLException {
		//comando SQL (update):
		String sql = "update conta set "
				+ "nome='?', cpf = ?, fone = ?, dataNasc = ? "
				+ "where nome like '?'";
		//objeto para conexão com bd
		ConexaoMySQL conexao = new ConexaoMySQL();
		//concetar ao banco de dados:
		Connection con = conexao.conectar();
		//comando SQL:
		PreparedStatement comando = con.prepareStatement(sql);
		//? 1 novo nome:
		comando.setString(1, c.getNome());
		//? 2 novo cpf:
		comando.setString(2, c.getCpf());
		//? 3 novo fone:
		comando.setLong(3, c.getFone());;
		//? 4 nova data nascimento:
		comando.setDate(4, new java.sql.Date(c.getDataNasc().getTime()));
		//?5 nome antigo
		comando.setString(5, nomeAntigo);	
		//executar o comando em SQL:
		comando.execute();
		//fechando conexão:
		con.close();
	}
	//método deletar
	public void deletar(String nome) throws ClassNotFoundException, SQLException {
		//comando SQL:
		String sql = "delete from conta where "+"nome=?";
		//objeto conexao:
		ConexaoMySQL conexao = new ConexaoMySQL();
		//conectar com o banco de dados>
		Connection con = conexao.conectar();
		//comando sql
		PreparedStatement comando = con.prepareStatement(sql);
		//? 1:
		comando.setString(1,nome);
		//executar comando sql:
		comando.execute();
		//fechando conexão:
		con.close();
	}
	//método update:
	public ArrayList<Conta> listar(Conta c) throws ClassNotFoundException, SQLException{
		//comando SQL para o insert:
		String sql = "select * "
				+"from produto ";
		//conexao com o BD
		ConexaoMySQL conexao = new ConexaoMySQL();
		//conectando ao bd
		Connection con = conexao.conectar();
		//objeto para construir o comando SQL
		PreparedStatement comando = con.prepareStatement(sql);
		//
		ArrayList <Conta> resultado = new ArrayList<Conta>();
		//resultset: (conjunto de dados do SELECT)
		ResultSet rs  =comando.executeQuery();
		//próximo resultado do result set:
		while(rs.next()) { //repetir para o número de linhas do BD
			Conta c1 = new Conta();
			c1.setNome(rs.getString("nome"));
			c1.setCpf(rs.getString("cpf"));
			resultado.add(c1);
		} //repente conforme o tamanfo do vetor
		con.close();
		//retorna resultado so select
		return resultado;
	}
}
