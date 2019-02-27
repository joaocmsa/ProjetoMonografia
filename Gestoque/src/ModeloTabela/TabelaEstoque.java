/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloTabela;

import Modelo.Estoque;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author DarthVader
 */
public class TabelaEstoque extends AbstractTableModel{

    private List<Estoque> linhas = new ArrayList<>();
    private String[] colunas = null;

    public String[] getColunas() {
        return colunas;
    }

    public void setColunas(String[] colunas) {
        this.colunas = colunas;
    }
    
   
    
    public int getRowCount() {
        return linhas.size();
    }

    public int getColumnCount() {
        return colunas.length;
    }

    public Object getValueAt(int linha, int coluna) {
        
        switch(coluna){
            case 0:
                return linhas.get(linha).getProduto_Cod_Prod();
            case 1:
                return linhas.get(linha).getProduto_Nome_Prod();
            case 2:
                return linhas.get(linha).getQuantidade();
            case 3:
                return linhas.get(linha).getNome_Fab();
            case 4:
                return linhas.get(linha).getNome_Fantasia();
        }
        
        return null;
    }

    public String getColumnName(int column) {
        return colunas[column];
    }
    
    public void addRow(Estoque estoque){
        this.linhas.add(estoque);
        this.fireTableDataChanged();
    }
    public void atualiza(){
        this.linhas.clear();
    }
    
    
}
