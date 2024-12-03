package dados;

import java.sql.Connection;
import java.sql.SQLException;

public class TesteConexao {

    public static void main(String[] args) {
        ConexaoMySQL conexao = new ConexaoMySQL();
        
        try {
            Connection con = conexao.conectar();
            System.out.println("Conexão bem-sucedida ao banco de dados");
            con.close();
        } catch (SQLException | ClassNotFoundException e) {
            
            System.out.println("Erro ao conectar ao banco de dados");
            e.printStackTrace();
        }
    }
}
