package DAOS;

import Classes.Carro;
import Conexao.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CarroDAO {
	private Connection con = null;
	
	public CarroDAO() {
        con = Conexao.getConnection();
    }
	
	public void add_carro(Carro c) {
        String sql = "INSERT INTO comercio.carro (numero_chassi, nome, cor, ano, potencia, valor) VALUES (?, ?, ?, ?, ?, ?)";

        try {
        	con = Conexao.getConnection();
        	PreparedStatement stmt = con.prepareStatement(sql);
        	stmt.setString(1, c.getNumero_chassi());
        	stmt.setString(2, c.getNome());
            stmt.setString(3, c.getCor());
            stmt.setInt(4, c.getAno());
            stmt.setInt(5, c.getPotencia_cv());
            stmt.setDouble(6, c.getValor());
            stmt.execute();
            System.out.println("\nCarro Adicionado no Banco de Dados\n");
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        } finally {
            Conexao.closeConnection(con);
        }
	}
	
    public ArrayList<Carro> mostrar_carros() {
    	ArrayList<Carro> retorno = new ArrayList<>();
    	String sql = "SELECT * from comercio.carro EXCEPT SELECT c.numero_chassi, c.nome, c.cor, c.ano, c.potencia, c.valor FROM comercio.carro as c, comercio.venda as v where v.id_carro_fk = c.numero_chassi";

        try {
            con = Conexao.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
            	Carro c = new Carro();
                c.setNumero_chassi(rs.getString("numero_chassi"));
                c.setNome(rs.getString("nome"));
                c.setCor(rs.getString("cor"));
                c.setAno(rs.getInt("ano"));
                c.setPotencia_cv(rs.getInt("potencia"));
                c.setValor(rs.getDouble("valor"));
                retorno.add(c);
            }
            rs.close();
            return retorno;
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
            return null;
        } finally {
            Conexao.closeConnection(con);
        }
    }
   
   public void delete_carro(String chassi) {
		String sql = "DELETE FROM comercio.carro WHERE numero_chassi = ?";
		
		try {
        	con = Conexao.getConnection();
           	PreparedStatement stmt = con.prepareStatement(sql);
        	stmt.setString(1, chassi);
        	stmt.executeUpdate();
            
        	System.out.println("\nCarro Deletado do Banco de Dados\n");
        } catch (SQLException ex) {
        	System.out.println("Erro: " + ex);
        } finally {
        	Conexao.closeConnection(con);
        }
	}
   
   public Carro achar_carro(String chassi) {

        Carro c = new Carro();
        String sql = "SELECT * FROM comercio.carro WHERE numero_chassi = ?";

        try {
            con = Conexao.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, chassi);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                c.setNumero_chassi(rs.getString("numero_chassi"));
                c.setNome(rs.getString("nome"));
                c.setCor(rs.getString("cor"));
                c.setAno(rs.getInt("ano"));
                c.setPotencia_cv(rs.getInt("potencia"));
                c.setValor(rs.getDouble("valor"));
            }
            return c;
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
            return null;
        } finally {
            Conexao.closeConnection(con);
        }
    }
   
   public void alterar_carro(String chassi, String nome, String cor, int ano, int potencia, double valor) {
        String sql = "UPDATE comercio.carro SET nome = ?, cor = ?, ano = ?, potencia = ?, valor = ? WHERE numero_chassi = ?";

        try {
            con = Conexao.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setString(2, cor);
            stmt.setInt(3, ano);
            stmt.setInt(4, potencia);
            stmt.setDouble(5, valor);
            stmt.setString(6, chassi);
            stmt.executeUpdate();
            System.out.println("\nCarro Editado no Banco de Dados\n");
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        } finally {
            Conexao.closeConnection(con);
        }
    }

}
