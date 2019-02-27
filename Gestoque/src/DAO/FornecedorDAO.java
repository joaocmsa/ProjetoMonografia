package DAO;

import Factory.ConexaoBanco;
import Modelo.Fornecedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author DarthVader
 */
public class FornecedorDAO {

    private Connection connection;
    private String pesquisa;
    private ResultSet resultado;

    public String getPesquisa() {
        return pesquisa;
    }

    public void setPesquisa(String pesquisa) {
        this.pesquisa = pesquisa;
    }

    public FornecedorDAO() {//Realiza a conexaão com o banco
        try {
            this.connection = new ConexaoBanco().Conecta();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar!");
        }
    }

    public void adicionaFornecedor(Fornecedor fornecedor) {

        String sql = "INSERT INTO fornecedor(Nome_fantasia, Endereco, Email, "
                + "Site, Tempo_entrega, CNPJ, Telefone) VALUES(?,?,?,?,?,?,?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, fornecedor.getNome_fantasia());
            stmt.setString(2, fornecedor.getEndereco());
            stmt.setString(3, fornecedor.getEmail());
            stmt.setString(4, fornecedor.getSite());
            stmt.setLong(5, fornecedor.getTempo_entrega());
            stmt.setString(6, fornecedor.getCNPJ());
            stmt.setString(7, fornecedor.getTelefone());
            stmt.execute();
            stmt.close();
        } catch (SQLException u) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar!");
        }
    }// fim da inserção.

    public void buscaFornecedor(Fornecedor fornecedor, String cod) {
        PreparedStatement stmt;

        try {
            stmt = this.connection.prepareStatement("SELECT * FROM fornecedor where CNPJ = ?");
            stmt.setString(1, cod);
            ResultSet resultado = stmt.executeQuery();

            while (resultado.next()) {
                fornecedor.setCNPJ(resultado.getString("CNPJ"));
                fornecedor.setCod_Fornc(resultado.getLong("Cod_Fornc"));
                fornecedor.setEmail(resultado.getString("Email"));
                fornecedor.setEndereco(resultado.getString("Endereco"));
                fornecedor.setNome_fantasia(resultado.getString("Nome_Fantasia"));
                fornecedor.setSite(resultado.getString("Site"));
                fornecedor.setTelefone(resultado.getString("Telefone"));
                fornecedor.setTempo_entrega(resultado.getLong("Tempo_entrega"));
                stmt.execute();
                stmt.close();

            }//fim do while

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao realizar busca\n Erro:" + ex);
        }//catch

    }// fim da busca

    public void AlteraFornc(Fornecedor fornecedor, Long cod) {
        String sql = "UPDATE fornecedor set Nome_fantasia=?, Endereco=?, Email=?, Site=?, Tempo_entrega=?, CNPJ=?, Telefone=? WHERE Cod_Fornc=?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, fornecedor.getNome_fantasia());
            stmt.setString(2, fornecedor.getEndereco());
            stmt.setString(3, fornecedor.getEmail());
            stmt.setString(4, fornecedor.getSite());
            stmt.setLong(5, fornecedor.getTempo_entrega());
            stmt.setString(6, fornecedor.getCNPJ());
            stmt.setString(7, fornecedor.getTelefone());
            stmt.setLong(8, cod);
            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar cadastro!\n Erro:" + ex);
        }
    }//fim alterar

    public List<Fornecedor> ListaForn() throws SQLException {
        List<Fornecedor> listafornc = new ArrayList<>();
        
        PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM fornecedor");
        ResultSet resultado = stmt.executeQuery();

        while (resultado.next()) {
            Fornecedor fornecedor = new Fornecedor();
            
            fornecedor.setCNPJ(resultado.getString("CNPJ"));
            fornecedor.setCod_Fornc(resultado.getLong("Cod_Fornc"));
            fornecedor.setEmail(resultado.getString("Email"));
            fornecedor.setEndereco(resultado.getString("Endereco"));
            fornecedor.setNome_fantasia(resultado.getString("Nome_Fantasia"));
            fornecedor.setSite(resultado.getString("Site"));
            fornecedor.setTelefone(resultado.getString("Telefone"));
            fornecedor.setTempo_entrega(resultado.getLong("Tempo_entrega"));
            stmt.execute();
            listafornc.add(fornecedor);
            
        }
        resultado.close();
        stmt.close();
        return listafornc;
    }// fim lista fornecedor

    public List<Fornecedor> ListaForn2(String nome) throws SQLException {
        List<Fornecedor> listafornc = new ArrayList<>();
        
        PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM fornecedor WHERE Nome_Fantasia LIKE ?");
        stmt.setString(1, "%"+nome+"%");
        ResultSet resultado = stmt.executeQuery();

        while (resultado.next()) {
            Fornecedor fornecedor = new Fornecedor();
            
            fornecedor.setCNPJ(resultado.getString("CNPJ"));
            fornecedor.setCod_Fornc(resultado.getLong("Cod_Fornc"));
            fornecedor.setEmail(resultado.getString("Email"));
            fornecedor.setEndereco(resultado.getString("Endereco"));
            fornecedor.setNome_fantasia(resultado.getString("Nome_Fantasia"));
            fornecedor.setSite(resultado.getString("Site"));
            fornecedor.setTelefone(resultado.getString("Telefone"));
            fornecedor.setTempo_entrega(resultado.getLong("Tempo_entrega"));
            stmt.execute();
            listafornc.add(fornecedor);
            
        }
        resultado.close();
        stmt.close();
        return listafornc;
    }// fim lista fornecedor
}
