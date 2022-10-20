package DAOS;

import Classes.Venda;
import Conexao.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VendaDAO {
	private Connection con = null;

    public VendaDAO() {
        con = Conexao.getConnection();
    }
    
    public void add_venda(Venda v) {
        String sql = "INSERT INTO comercio.venda (id_venda, data_venda, id_cliente_fk, id_carro_fk) VALUES (DEFAULT, ?, ?, ?)";

        try {
            con = Conexao.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, v.getData_venda());
            stmt.setString(2, v.getP().getCpf());
            stmt.setString(3, v.getC().getNumero_chassi());
            stmt.execute();
            System.out.println("\nVenda Adicionada no Banco de Dados\n");

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        } finally {
            Conexao.closeConnection(con);
        }
    }
    
    public void mostrar_vendas() {

        String sql = "SELECT v.id_venda, p.cpf || ' - ' || p.nome as COMPRADOR, "
                + "c.numero_chassi || ' - ' || c.nome as carro, c.valor, v.data_venda  FROM comercio.venda as v, "
                + "comercio.cliente as p, comercio.carro as c where p.cpf = v.id_cliente_fk and c.numero_chassi = v.id_carro_fk";

        try {
            con = Conexao.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            System.out.println("\nTodas as Vendas\n");

            while (rs.next()) {
            	System.out.println("*** Grupo3 Multimarcas ***");
                System.out.println("\nNúmero da venda: " + rs.getInt("id_venda"));
                System.out.println("Cpf do Comprador: " + rs.getString("comprador"));
                System.out.println("Chassi do Carro: " + rs.getString("carro"));
                System.out.println("Valor: " + rs.getDouble("valor"));
                System.out.println("Data da venda: " + rs.getString("data_venda"));
                System.out.print("\n");
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        } finally {
            Conexao.closeConnection(con);
        }
    }
}
