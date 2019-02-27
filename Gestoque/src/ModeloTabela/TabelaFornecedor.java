/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloTabela;

import Modelo.Fornecedor;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author DarthVader
 */
public class TabelaFornecedor extends AbstractTableModel{
    private List<Fornecedor> linhas = new ArrayList<>(); //responsavel por armazenar a quantidade de dados que vier do banco de dados
    private String[] colunas = {"Código","Nome","CNPJ","Site"}; //responsavel por armazenar os nomes das colunas
    
    
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
                return linhas.get(linha).getCod_Fornc();
            case 1:
                return linhas.get(linha).getNome_fantasia();
            case 2:
                return linhas.get(linha).getCNPJ();
            case 3:
                return linhas.get(linha).getSite();
            
        }
        return null;
    }
    
    public void addRow(Fornecedor fornecedor){
        this.linhas.add(fornecedor);
        this.fireTableDataChanged();
    }
    
    public void atualiza(){
        this.linhas.clear();
    }
}