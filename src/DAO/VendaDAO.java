/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Factory.ConexaoBanco;
import Modelo.Venda;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author DarthVader
 */
public class VendaDAO {

    private Connection connection;
    private ResultSet resultado;
    private long pesquisa, pesquisa2, codFunc;

    public long getCodFunc() {
        return codFunc;
    }

    public void setCodFunc(long codFunc) {
        this.codFunc = codFunc;
    }
    private java.util.Date data_certa, dataI, dataF;

    public java.util.Date getData_certa() {
        return data_certa;
    }

    public void setData_certa(java.util.Date data_certa) {
        this.data_certa = data_certa;
    }

    public long getPesquisa2() {
        return pesquisa2;
    }

    public void setPesquisa2(long pesquisa2) {
        this.pesquisa2 = pesquisa2;
    }

    public long getPesquisa() {
        return pesquisa;
    }

    public void setPesquisa(long pesquisa) {
        this.pesquisa = pesquisa;
    }

    public VendaDAO() {
        try {
            this.connection = new ConexaoBanco().Conecta();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar com o banco:" + ex);
        }
    }

    public void CriaVenda() {
        String sql = "INSERT INTO vendas(Cod_Func, Cod_pag, Valor_Total) VALUES(?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, 9);
            stmt.setInt(2, 1);
            stmt.setLong(3, 0);
            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao adicionar uma venda:" + ex);
        }
    }//fim do cria venda

    public void PegaVenda(Venda venda) {
        String sql = "SELECT * FROM vendas";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            resultado = stmt.executeQuery();
            resultado.last();
            venda.setCod_Venda(resultado.getLong("Cod_Venda"));
            venda.setValor_Total(resultado.getBigDecimal("Valor_Total"));
            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao pegar o codigo da venda:" + ex);
        }
    }// fim pegavenda

    public void AdicionaProduto(Venda venda) {
        String sql = "INSERT INTO itens_venda(Cod_Func,Cod_Venda, Cod_Prod, quantidade,sub_total) VALUES(?,?,?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, 9);
            stmt.setLong(2, venda.getCod_Venda());
            stmt.setLong(3, venda.getCod_Prod());
            stmt.setLong(4, venda.getQuant_vend());
            stmt.setBigDecimal(5, venda.getSub_total());
            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "                          "
                    + "Erro ao adicionar produto!\nErro: " + ex);
        }
    }//fim adicionaproduto

    public List<Venda> ListaProduto() throws SQLException {
        List<Venda> listaprod = new ArrayList<>();
        String sql = "select * from itens_venda inner join produto on "
                + "itens_venda.Cod_Prod = produto.Cod_Prod\n" +
        "inner join fabricante on produto.Cod_Fab = fabricante.Cod_Fab WHERE Cod_Venda = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setLong(1, pesquisa);
        resultado = stmt.executeQuery();
        while (resultado.next()) {
            Venda venda = new Venda();
            venda.setFabricante(resultado.getString("Nome_Fab"));
            venda.setNome_Prod(resultado.getString("Nome_Prod"));
            venda.setQuant_vend(resultado.getLong("quantidade"));
            venda.setValor_uni(resultado.getDouble("Valor_Venda"));
            venda.setSub_total(resultado.getBigDecimal("sub_total"));
            stmt.execute();
            listaprod.add(venda);
        }
        resultado.close();
        stmt.close();
        return listaprod;
    }//fim da listaProd

    public void ExcluirProduto() {
        String sql = "delete from itens_venda WHERE Cod_venda=? AND Cod_Prod=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, pesquisa);
            stmt.setLong(2, pesquisa2);
            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "                                 "
                    + "Erro ao remover item da lista!\n Erro: " + ex);
        }
    }//fim do excluirproduto

    public void pegacodigo(String nome) {
        String sql = "select * from produto where Nome_Prod = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, nome);
            resultado = stmt.executeQuery();
            resultado.first();
            pesquisa2 = resultado.getLong("Cod_Prod");
            stmt.execute();
            resultado.close();
            stmt.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "                               "
                    + "Erro ao pegar codigo!\n Erro: " + ex);
        }
    }//fim pegacodigo

    public void ExcluirVenda() {
        String sql = "delete from vendas WHERE Cod_venda=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, pesquisa);
            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "                                 "
                    + "Erro ao remover item da lista!\n Erro: " + ex);
        }
    }//fim do excluirvenda

    public void AtualizaVenda(Venda venda) {
        String sql = "UPDATE vendas SET Valor_Total = ? ,Data_Venda = ? where cod_venda = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setBigDecimal(1, venda.getValor_Total());
            stmt.setDate(2, new java.sql.Date(venda.getData_Venda().getTime()));
            stmt.setLong(3, pesquisa);
            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao finalizar a venda:" + ex);
        }
    }//fim do atualizavenda

    public void mudaData(String Data_Venda) {
        try {
            DateFormat formatBR = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date data = formatBR.parse(Data_Venda);//transforma string em date BR
            String dataUS = new SimpleDateFormat("yyyy/MM/dd").format(data);
            DateFormat formatoB = new SimpleDateFormat("yyyy/MM/dd");
            java.util.Date date = formatoB.parse(dataUS);//transforma string em date US

            data_certa = date;
        } catch (ParseException ex) {
            Logger.getLogger(Venda.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void AtualizaPagamento(String nome) {

        String sql = "UPDATE vendas SET Cod_pag = ?, Situacao = ? where cod_venda = ?";
        String sqlp = "Select * FROM pagamento where Nome_pagamento =?";
        String situacao = "ativo";
        try {
            PreparedStatement stmte = connection.prepareStatement(sqlp);
            stmte.setString(1, nome);
            ResultSet resultados = stmte.executeQuery();
            resultados.first();
            long codpag = resultados.getLong("Cod_Pag");
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, codpag);
            stmt.setString(2, situacao);
            stmt.setLong(3, pesquisa);
            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao concluir a venda:" + ex);
        }
    }//fim do atualizavenda

    public void inativa(Long cod) {
        String sql = "UPDATE vendas SET Situacao = ? where cod_venda = ?";
        String situacao = "Cancelada";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, situacao);
            stmt.setLong(2, cod);
            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cancelar a venda:" + ex);
        }
    }//fim do atualizavenda

    public void buscaVenda(Venda venda, Long cod) {
        String sql = "SELECT * FROM vendas WHERE Cod_Venda = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, cod);
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                venda.setCod_Pag(resultado.getLong("Cod_Pag"));
                venda.setValor_Total(resultado.getBigDecimal("Valor_Total"));
                venda.setData_Venda(resultado.getDate("Data_Venda"));
            }
            resultado.close();
            stmt.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao realizar busca\n Erro:" + ex);
        }
    }

    public List<Venda> RelatorioVenda(String DataI, String DataF) throws SQLException {
        List<Venda> listavenda = new ArrayList<>();
        String sql = "SELECT * FROM vendas inner join funcionario on"
                + " vendas.Cod_Func = funcionario.Cod_Func WHERE Data_Venda BETWEEN ? AND ?"
                + " order by vendas.Cod_Venda";
        mudaData(DataI);
        dataI = data_certa;
        mudaData(DataF);
        dataF = data_certa;
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setDate(1, new java.sql.Date(dataI.getTime()));
        stmt.setDate(2, new java.sql.Date(dataF.getTime()));
        resultado = stmt.executeQuery();
        while (resultado.next()) {
            Venda venda = new Venda();
            venda.setCod_Venda(resultado.getLong("Cod_Venda"));
            venda.setData_Venda(resultado.getDate("Data_Venda"));
            String data = new SimpleDateFormat("dd/MM/yyyy").format(venda.getData_Venda());
            venda.setData(data);
            venda.setValor_Total(resultado.getBigDecimal("Valor_Total"));
            venda.setSituacao(resultado.getString("Situacao"));
            venda.setResposanvel(resultado.getString("Nome"));
            stmt.execute();
            listavenda.add(venda);
        }
        resultado.close();
        stmt.close();
        return listavenda;
    }//fim da Relatorio venda

    public List<Venda> RelatorioProdutoVenda(String DataI, String DataF) throws SQLException {
        List<Venda> listaprod = new ArrayList<>();
        String sql = "Select * From vendas inner join itens_venda on vendas.Cod_Venda = itens_venda.Cod_Venda \n" +
        "inner join produto on itens_venda.Cod_Prod = produto.Cod_Prod \n" +
        "inner join fabricante on produto.Cod_Fab = fabricante.Cod_Fab WHERE Data_Venda BETWEEN ? AND ?";
        mudaData(DataI);
        dataI = data_certa;
        mudaData(DataF);
        dataF = data_certa;
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setDate(1, new java.sql.Date(dataI.getTime()));
        stmt.setDate(2, new java.sql.Date(dataF.getTime()));
        resultado = stmt.executeQuery();
        String sit = "ativo";
        while (resultado.next()) {
            if (resultado.getString("Situacao").equals(sit)) {
                Venda venda = new Venda();
                venda.setCod_Prod(resultado.getLong("Cod_Prod"));
                venda.setNome_Prod(resultado.getString("Nome_Prod"));
                venda.setValor_C(resultado.getBigDecimal("Valor_Compra"));
                venda.setValor_V(resultado.getBigDecimal("Valor_Venda"));
                venda.setQuant_vend(resultado.getLong("quantidade"));
                venda.setFabricante(resultado.getString("Nome_Fab"));
                stmt.execute();
                if (listaprod.contains(venda)) {
                } else {
                    listaprod.add(venda);
                    }
            }
        }
        resultado.close();
        stmt.close();
        return listaprod;
    }//fim da Relatorio venda
}
