/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Factory.ConexaoBanco;
import Modelo.Estoque;
import Modelo.Produto;
import java.math.BigDecimal;
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
public class ProdutoDAO {

    private Connection connection;
    private String pesquisa;
    private ResultSet resultado;
    private long cods;

    public ProdutoDAO() {
        try {
            this.connection = new ConexaoBanco().Conecta();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar!");
        }
    }

    public void pegacod(String nome) {
        String sql = "Select * From produto where Nome_Prod = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, nome);
            resultado = stmt.executeQuery();
            resultado.first();
            cods = resultado.getLong("Cod_Prod");
            resultado.close();
            stmt.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao pegar código: "
                    + "Erro de banco de dados:\n" + ex);
        }
    }

    public void adicionaProduto(Produto produto) {
        String sql = "INSERT INTO produto(Nome_Prod,Descricao,Valor_Compra,Valor_Venda,quantidade_min,Cod_Fornc,Cod_Prod,Cod_Fab) VALUES(?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, produto.getNome_Prod());
            stmt.setString(2, produto.getDescricao());
            stmt.setBigDecimal(3, produto.getValor_Compra());
            stmt.setBigDecimal(4, produto.getValor_Venda());
            stmt.setLong(5, produto.getQuant_minima());
            stmt.setLong(6, produto.getCod_Forn());
            stmt.setLong(7, produto.getCod_Prod());
            stmt.setLong(8, produto.getCod_Fab());
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Produto " + produto.getNome_Prod() + " cadastrado com sucesso! ");
        } catch (SQLException u) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar!"
                    + "\n Erro de banco de dados:\n" + u);
        }//fim do try
    }//fim do adicionaProduto

    public void alteraProduto(Produto produto) {
        String sql = "UPDATE produto set Nome_Prod=?,Descricao=?,Valor_Compra=?"
                + ",Valor_Venda=?,quantidade_min=?,Cod_Fornc=?, Cod_Fab=? WHERE Cod_Prod=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, produto.getNome_Prod());
            stmt.setString(2, produto.getDescricao());
            stmt.setBigDecimal(3, produto.getValor_Compra());
            stmt.setBigDecimal(4, produto.getValor_Venda());
            stmt.setLong(5, produto.getQuant_minima());
            stmt.setLong(6, produto.getCod_Forn());
            stmt.setLong(7, produto.getCod_Fab());
            stmt.setString(8, pesquisa);
            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar cadastro por codigo!"
                    + "\n Erro de banco de dados:\n" + ex);
        }// fim do try
    }// fim do altera produto

    public void buscaProdutoCod(Produto produto) {
        try {
            String sql = "SELECT * FROM produto where Cod_Prod = ?";
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setLong(1, cods);
            ResultSet resultado = stmt.executeQuery();

            while (resultado.next()) {
                produto.setCod_Fab(resultado.getLong("Cod_Fab"));
                produto.setDescricao(resultado.getString("Descricao"));
                produto.setCod_Forn(resultado.getLong("Cod_Fornc"));
                produto.setNome_Prod(resultado.getString("Nome_Prod"));
                produto.setQuant_minima(resultado.getLong("quantidade_min"));
                produto.setValor_Compra(resultado.getBigDecimal("Valor_Compra"));
                produto.setValor_Venda(resultado.getBigDecimal("Valor_Venda"));
                produto.setCod_Prod(resultado.getLong("Cod_Prod"));
                stmt.execute();
                stmt.close();
            }//fim do while
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao realizar busca por codigo!"
                    + "\n Erro de banco de dados:\n" + ex);
        }//catch
    }// fim da busca por codigo    

    public List<Produto> ListaProd() throws SQLException {
        List<Produto> listaprod = new ArrayList<>();
        String sql = "SELECT * FROM produto";
        PreparedStatement stmt = this.connection.prepareStatement(sql);
        ResultSet resultado = stmt.executeQuery();
        while (resultado.next()) {
            Produto produto = new Produto();
            produto.setCod_Fab(resultado.getLong("Cod_Fab"));
            produto.setDescricao(resultado.getString("Descricao"));
            produto.setCod_Forn(resultado.getLong("Cod_Fornc"));
            produto.setCod_Prod(resultado.getLong("Cod_Prod"));
            produto.setQuant_minima(resultado.getLong("quantidade_min"));
            produto.setValor_Compra(resultado.getBigDecimal("Valor_Compra"));
            produto.setValor_Venda(resultado.getBigDecimal("Valor_Venda"));
            produto.setNome_Prod(resultado.getString("Nome_Prod"));
            stmt.execute();
            listaprod.add(produto);
        }
        resultado.close();
        stmt.close();
        return listaprod;
    } // finaliza a criaçao da lista

    public List<Produto> ListaProdB() throws SQLException {
        List<Produto> listaprod = new ArrayList<>();
        String sql = "select * from produto Where Nome_Prod LIKE ?";
        PreparedStatement stmt = this.connection.prepareStatement(sql);
        stmt.setString(1, "%" + pesquisa + "%");
        ResultSet resultado = stmt.executeQuery();
        while (resultado.next()) {
            Produto produto = new Produto();
            produto.setCod_Fab(resultado.getLong("Cod_Fab"));
            produto.setDescricao(resultado.getString("Descricao"));
            produto.setCod_Forn(resultado.getLong("Cod_Fornc"));
            produto.setCod_Prod(resultado.getLong("Cod_Prod"));
            produto.setQuant_minima(resultado.getLong("quantidade_min"));
            produto.setValor_Compra(resultado.getBigDecimal("Valor_Compra"));
            produto.setValor_Venda(resultado.getBigDecimal("Valor_Venda"));
            produto.setNome_Prod(resultado.getString("Nome_Prod"));
            stmt.execute();
            listaprod.add(produto);
        }
        resultado.close();
        stmt.close();
        return listaprod;
    }

    public long getCods() {
        return cods;
    }

    public void setCods(long cods) {
        this.cods = cods;
    }

    public String getPesquisa() {
        return pesquisa;
    }

    public void setPesquisa(String pesquisa) {
        this.pesquisa = pesquisa;
    }
}
