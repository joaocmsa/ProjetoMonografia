package DAO;

import Factory.ConexaoBanco;
import Modelo.Estoque;
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
 * @author DarthVader dica: //criar uma funçao para gerar uma lista de produtos
 * que estao abaixo do estoque.
 */
public class EstoqueDAO {

    private Connection connection;
    private Long pesquisa;
    private String pesquisar;
    private ResultSet resultado;
    private int venda;

    public EstoqueDAO() {
        try {
            this.connection = new ConexaoBanco().Conecta();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar!");
        }
    }//fim do estoquedao()

    // REALIZA A INSERÇÃO DOS NOVOS PRODUTOS CADASTRADO NO ESTOQUE.
    public void AdicionaEstoque(Estoque estoque) {
        String sql = "INSERT INTO estoque(Cod_Func, Cod_Prod, quantidade) VALUES(?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, estoque.getCod_func());
            stmt.setLong(2, estoque.getProduto_Cod_Prod());
            stmt.setLong(3, estoque.getQuantidade());
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Produto " + estoque.getProduto_Nome_Prod()+
                    " inserido com sucesso! ");
        } catch (SQLException u) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir produto no estoque!\n"
                    + "Erro de banco de dados:\n" + u);
        }//fim do try
    }// fim do adicionaestoque

    public void EntradaProduto(Estoque estoque) {
        //busca para pegar a quantidade antiga
        String sqle = "SELECT * FROM estoque WHERE Cod_Prod=?";
        String sql = "UPDATE estoque SET quantidade=? WHERE Cod_Prod=?";

        try {
            //busca pela quantidade antiga
            PreparedStatement stmte = connection.prepareStatement(sqle);
            stmte.setLong(1, pesquisa);
            stmte.executeQuery();
            resultado = stmte.executeQuery();
            resultado.first();
            long qatual = resultado.getLong("quantidade");
            long qadd = estoque.getQuantidade();
            long qatualiza = qadd + qatual;
            //insere a quantidade atual
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, qatualiza);
            stmt.setLong(2, pesquisa);
            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao realizar entrada!\n"
                    + "Erro de banco de dados:\n" + ex);
        }//fim do try
    }// fim da entrada de produtos

    public void SaidaProduto(Estoque estoque) {
        String sqle = "SELECT * FROM estoque WHERE Cod_Prod=?";//busca para pegar a quantidade antiga
        String sqlq = "SELECT * FROM produto WHERE Cod_Prod=?";//compara a quantidade minima
        String sql = "UPDATE estoque set quantidade=? WHERE Cod_Prod=?";
        try {
            //pega a quantidade antiga
            PreparedStatement stmte = connection.prepareStatement(sqle);
            stmte.setLong(1, pesquisa);
            stmte.executeQuery();
            resultado = stmte.executeQuery();
            resultado.first();
            long qatual = resultado.getLong("quantidade");
            stmte.close();
            resultado.close();

            long qret = estoque.getQuantidade();
            long qatualiza = qatual - qret;
            long qmin;
            String produto;
            PreparedStatement stmtq = connection.prepareStatement(sqlq);
            stmtq.setLong(1, pesquisa);
            stmtq.executeQuery();
            resultado = stmtq.executeQuery();
            resultado.first();
            qmin = resultado.getLong("quantidade_min");
            produto = resultado.getString("Nome_Prod");
            resultado.close();
            stmtq.close();
            if (qatual <= 0) {//verifica se o estoque esta zerado
                JOptionPane.showMessageDialog(null, "O produto " + produto
                        + " esta com o estoque zerado!\n Impossivel realizar ação!");
                venda = 1;
            } else if (qatual < qret) {
                JOptionPane.showMessageDialog(null, "O produto " + produto
                        + " não possui: " + qret + " unidades em estoque!\n"
                        + "           Impossivel realizar ação!");
                venda = 1;
            } else {//realiza a saida do produto
                venda = 2;
                PreparedStatement stmt = connection.prepareStatement(sql);
                stmt.setLong(1, qatualiza);
                stmt.setLong(2, pesquisa);
                stmt.execute();
                stmt.close();
                if (qatualiza <= qmin) {//verifica se esta abaixo do estoque
                    JOptionPane.showMessageDialog(null, "O produto: " + produto
                            + " esta abaixo da quantidade minima");
                }//fim do if
            }//fim do else
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao realizar saída!\n"
                    + "Erro de banco de dados:\n" + ex);
        }//fim do try        
    }// fim da saida de produtos

    public void BuscaEstoque(Estoque estoque) {
        String sql = "SELECT * FROM estoque WHERE Cod_Prod=?";
        try {
            PreparedStatement stmte = connection.prepareStatement(sql);
            stmte.setLong(1, pesquisa);
            stmte.executeQuery();
            resultado = stmte.executeQuery();
            resultado.first();
            estoque.setProduto_Cod_Prod(resultado.getLong("Cod_Prod"));
            estoque.setQuantidade(resultado.getLong("quantidade"));
            stmte.close();
            resultado.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao realizar busca!\n"
                    + "Erro de banco de dados:\n" + ex);
        }

    }//fim da busca no estoque

    public List<Estoque> ListaEstoque() throws SQLException {
        List<Estoque> listaestoque = new ArrayList<>();
        String sql = "SELECT * FROM estoque inner join produto on estoque.Cod_Prod = produto.Cod_Prod\n"
                + "inner join fornecedor on produto.Cod_Fornc = fornecedor.Cod_Fornc\n"
                + "inner join fabricante on produto.Cod_Fab = fabricante.Cod_Fab";
        PreparedStatement stmt = this.connection.prepareStatement(sql);
        ResultSet resultado = stmt.executeQuery();
        while (resultado.next()) {
            Estoque estoque = new Estoque();
            estoque.setNome_Fab(resultado.getString("Nome_Fab"));
            estoque.setProduto_Cod_Prod(resultado.getLong("Cod_Prod"));
            estoque.setNome_Fantasia(resultado.getString("Nome_Fantasia"));
            estoque.setProduto_Nome_Prod(resultado.getString("Nome_Prod"));
            estoque.setQuantidade(resultado.getLong("quantidade"));
            estoque.setQuantidade_min(resultado.getLong("quantidade_min"));
            listaestoque.add(estoque);
        }
        resultado.close();
        stmt.close();
        return listaestoque;
    } // finaliza a criaçao da lista

    public List<Estoque> ListaEstoqueRelelatorio() throws SQLException {
        List<Estoque> listaestoque = new ArrayList<>();
        String sql = "select * from estoque inner join produto on estoque.Cod_Prod = produto.Cod_Prod\n"
                + "inner join fornecedor on produto.Cod_Fornc = fornecedor.Cod_Fornc\n"
                + "inner join fabricante on produto.Cod_Fab = fabricante.Cod_Fab";
        PreparedStatement stmt = this.connection.prepareStatement(sql);
        ResultSet resultado = stmt.executeQuery();
        while (resultado.next()) {
            long min = resultado.getLong("quantidade_min"), est = resultado.getLong("quantidade");
            if (est <= min) {
                Estoque estoque = new Estoque();
                estoque.setNome_Fab(resultado.getString("Nome_Fab"));
                estoque.setProduto_Cod_Prod(resultado.getLong("Cod_Prod"));
                estoque.setNome_Fantasia(resultado.getString("Nome_Fantasia"));
                estoque.setProduto_Nome_Prod(resultado.getString("Nome_Prod"));
                estoque.setQuantidade(resultado.getLong("quantidade"));
                estoque.setQuantidade_min(resultado.getLong("quantidade_min"));
                listaestoque.add(estoque);
            }
        }
        resultado.close();
        stmt.close();
        return listaestoque;
    } // finaliza a criaçao da lista

    public List<Estoque> ListaEstoqueSelecionado() throws SQLException {
        List<Estoque> listaestoque = new ArrayList<>();
        String sql = "select * from estoque inner join produto on estoque.Cod_Prod = produto.Cod_Prod\n"
                + "inner join fornecedor on produto.Cod_Fornc = fornecedor.Cod_Fornc\n"
                + "inner join fabricante on produto.Cod_Fab = fabricante.Cod_Fab Where Nome_Prod Like ?";
        PreparedStatement stmt = this.connection.prepareStatement(sql);
        stmt.setString(1, "%" + pesquisar + "%");
        ResultSet resultado = stmt.executeQuery();
        while (resultado.next()) {
            Estoque estoque = new Estoque();
            estoque.setNome_Fab(resultado.getString("Nome_Fab"));
            estoque.setProduto_Cod_Prod(resultado.getLong("Cod_Prod"));
            estoque.setNome_Fantasia(resultado.getString("Nome_Fantasia"));
            estoque.setProduto_Nome_Prod(resultado.getString("Nome_Prod"));
            estoque.setQuantidade(resultado.getLong("quantidade"));
            estoque.setQuantidade_min(resultado.getLong("quantidade_min"));
            listaestoque.add(estoque);
        }
        resultado.close();
        stmt.close();
        return listaestoque;
    } // finaliza a criaçao da lista

    public int getVenda() {
        return venda;
    }

    public void setVenda(int venda) {
        this.venda = venda;
    }

    public String getPesquisar() {
        return pesquisar;
    }

    public void setPesquisar(String pesquisar) {
        this.pesquisar = pesquisar;
    }

    public Long getPesquisa() {
        return pesquisa;
    }

    public void setPesquisa(Long pesquisa) {
        this.pesquisa = pesquisa;
    }
}
