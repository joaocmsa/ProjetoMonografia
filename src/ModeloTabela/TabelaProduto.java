/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloTabela;

import Modelo.Produto;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author DarthVader
 */
public class TabelaProduto extends AbstractTableModel{

    private List<Produto> linhas = new ArrayList<>();
    private String[] colunas = {"Codigo","Nome","Venda","Compra","Minimo"};
   
    
    public int getRowCount() {
        return linhas.size();
    }

    public int getColumnCount() {
        return colunas.length;
    }

    public Object getValueAt(int linha, int coluna) {
        
        switch(coluna){
            case 0:
                return linhas.get(linha).getCod_Prod();
            case 1:
                return linhas.get(linha).getNome_Prod();
            case 2:
                return linhas.get(linha).getValor_Venda();
            case 3:
                return linhas.get(linha).getValor_Compra();
            case 4:
                return linhas.get(linha).getQuant_minima();
        }
        
        return null;
    }

    public String getColumnName(int column) {
        return colunas[column];
    }
    
    public void addRow(Produto produto){
        this.linhas.add(produto);
        this.fireTableDataChanged();
    }
    
     public void atualiza(){
        this.linhas.clear();
    }
}
