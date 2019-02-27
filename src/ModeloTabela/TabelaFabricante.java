/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloTabela;

import Modelo.Fabricante;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author DarthVader
 */
public class TabelaFabricante extends AbstractTableModel{
    private List<Fabricante> linhas = new ArrayList<>(); //responsavel por armazenar a quantidade de dados que vier do banco de dados
    private String[] colunas = {"Código","Nome"}; //responsavel por armazenar os nomes das colunas
    
    
    public int getColumnCount(){
    //responsavel pela quantidade de colunas da tabela
    return colunas.length;
    }
    public int getRowCount(){
    //responsavel pela quantidade de linhas da tabela
        return linhas.size();   
    }
    public String getColumnName(int  Col){
        //responsavel por pegar o nome da coluna
        return colunas[Col];
    }
    public Object getValueAt(int linha, int coluna){
        //responsavel por pegar os valores da tabela
        switch(coluna){
            case 0:
                return linhas.get(linha).getCod_Fabr();
            case 1:
                return linhas.get(linha).getNome_Fabr();
            
        }
        return null;
    }
    
    public void addRow(Fabricante fab){
        this.linhas.add(fab);
        this.fireTableDataChanged();
    }
    
    public void atualiza(){
        this.linhas.clear();
    }
}