/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Factory.ConexaoBanco;
import Modelo.Fabricante;
import ModeloTabela.TabelaFabricante;
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
public class FabricanteDAO {
    
    
    private Connection connection;
    
    
    public FabricanteDAO(){
         try {
            this.connection = new ConexaoBanco().Conecta();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao conectar!");
        }
    }
    public void AddFab(Fabricante fab){
        String sql = "INSERT INTO fabricante(Nome_Fab) VALUES(?)";
        
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, fab.getNome_Fabr());
            stmt.execute();
            stmt.close();
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar fabricante\nErro:" +ex);
        }
    }//fim do addfab
    
    public List<Fabricante> listaFab() throws SQLException{
        List<Fabricante> listafab = new ArrayList<>();
        
        PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM fabricante");
        ResultSet resultado = stmt.executeQuery();
         while (resultado.next()){
             Fabricante fabricante = new Fabricante();
             
             fabricante.setCod_Fabr(resultado.getLong("Cod_Fab"));
             fabricante.setNome_Fabr(resultado.getString("Nome_Fab"));
             stmt.execute();
             listafab.add(fabricante);
         }
        resultado.close();
        stmt.close();
        return listafab;
    }// fim da listafab
    public List<Fabricante> listaFab2(String nome) throws SQLException{
        List<Fabricante> listafab = new ArrayList<>();
        
        PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM fabricante WHERE Nome_Fab LIKE ?");
        stmt.setString(1, "%"+nome+"%");
        ResultSet resultado = stmt.executeQuery();
         while (resultado.next()){
             Fabricante fabricante = new Fabricante();
             
             fabricante.setCod_Fabr(resultado.getLong("Cod_Fab"));
             fabricante.setNome_Fabr(resultado.getString("Nome_Fab"));
             stmt.execute();
             listafab.add(fabricante);
         }
        resultado.close();
        stmt.close();
        return listafab;
    }// fim da listafab2
    
    public void alteraFab(Fabricante fabricante, Long cod){
        String sql = "UPDATE fabricante set Nome_Fab=? WHERE Cod_Fab=?";
        
        
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, fabricante.getNome_Fabr());
            stmt.setLong(2, cod);
            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar cadastro de fabricante\nErro:" +ex);
        }
    }//fim alterafab
}
