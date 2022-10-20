package DAOS;

import Classes.Cliente;
import Conexao.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClienteDAO {
	private Connection con = null;
	public ClienteDAO() {
        con = Conexao.getConnection();
    }
	
	public void add_cliente(Cliente p) {

        String sql = "INSERT INTO comercio.cliente (cpf, rg, nome, idade, email, telefone)"
        		+ "VALUES (?, ?, ?, ?, ?, ?)";

        try {
            con = Conexao.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, p.getCpf());
            stmt.setString(2, p.getRg());
            stmt.setString(3, p.getNome());
            stmt.setString(4, p.getIdade());
            stmt.setString(5, p.getEmail());
            stmt.setString(6, p.getTelefone());
            stmt.execute();
            System.out.println("\nCliente Adicionado no Banco de Dados\n");
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        } finally {
            Conexao.closeConnection(con);
        }
    }
	
	public ArrayList<Cliente> mostrar_clientes() {
		ArrayList<Cliente> retorno = new ArrayList<>();
		String sql = "SELECT * FROM comercio.cliente";

        try {
            con = Conexao.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
            	Cliente p = new Cliente();
                p.setCpf(rs.getString("cpf"));
                p.setRg(rs.getString("rg"));
                p.setNome(rs.getString("nome"));
                p.setIdade(rs.getString("idade"));
                p.setEmail(rs.getString("email"));
                p.setTelefone(rs.getString("telefone"));
                retorno.add(p);
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
	
	public void delete_cliente(String cpf) {
       String sql = "DELETE FROM comercio.cliente WHERE cpf = ?";

        try {
            con = Conexao.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, cpf);
            stmt.executeUpdate();
            System.out.println("\nCliente Deletado do Banco de Dados\n");
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        } finally {
            Conexao.closeConnection(con);
        }
    }
	
	public Cliente achar_cliente(String cpf) {

        Cliente p = new Cliente();
        String sql = "SELECT * FROM comercio.cliente WHERE cpf = ?";

        try {
            con = Conexao.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
               p.setCpf(rs.getString("cpf"));
                p.setRg(rs.getString("rg"));
                p.setNome(rs.getString("nome"));
                p.setIdade(rs.getString("idade"));
                p.setEmail(rs.getString("email"));
                p.setTelefone(rs.getString("telefone"));
            }
            return p;
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
            return null;
        } finally {
            Conexao.closeConnection(con);
        }
    }
	
	public void alterar_cliente(String cpf, String rg, String nome, String idade, String email, String telefone) {

        String sql = "UPDATE comercio.cliente SET rg = ?, nome = ?, idade = ?, email = ?, telefone = ? WHERE cpf = ?";

        try {
            con = Conexao.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, rg);
            stmt.setString(2, nome);
            stmt.setString(3, idade);
            stmt.setString(4, email);
            stmt.setString(5, telefone);
            stmt.setString(6, cpf);
            stmt.executeUpdate();
            System.out.println("\nCliente Editado no Banco de Dados\n");
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        } finally {
            Conexao.closeConnection(con);
        }
    }
	
	public void mostrar_meus_carros(String cpf) {

        String sql = "SELECT v.id_venda, p.cpf || ' - ' || p.nome as COMPRADOR, c.numero_chassi || ' - ' || c.nome as carro, c.valor, v.data_venda "
        		+ "FROM comercio.venda as v, comercio.cliente as p, comercio.carro as c where p.cpf = ? and c.numero_chassi = v.id_carro_fk";

        try {
            con = Conexao.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();
            System.out.println("\nTodas os carros:\n");

            while (rs.next()) {
                System.out.println("Chassi do Carro: " + rs.getString("carro"));
            }

            System.out.print("\n");
            rs.close();
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        } finally {
            Conexao.closeConnection(con);
        }
    }
}
