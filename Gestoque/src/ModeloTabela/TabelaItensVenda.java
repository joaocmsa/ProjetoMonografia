/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloTabela;

import Modelo.Venda;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author DarthVader
 */
public class TabelaItensVenda extends AbstractTableModel{

    private List<Venda> linhas = new ArrayList<>();
    private String[] colunas = {"Nome","Fabricante","Valor unitário","Quantidade","Sub-Total"};
   
    
    public int getRowCount() {
        return linhas.size();
    }

    public int getColumnCount() {
        return colunas.length;
    }

    public Object getValueAt(int linha, int coluna) {
        
        switch(coluna){
            case 0:
                return linhas.get(linha).getNome_Prod();
            case 1:
                return linhas.get(linha).getFabricante();
            case 2:
                return linhas.get(linha).getValor_uni();
            case 3:
                return linhas.get(linha).getQuant_vend();
            case 4:
                return linhas.get(linha).getSub_total();
        }
        
        return null;
    }

    public String getColumnName(int column) {
        return colunas[column];
    }
    
    public void addRow(Venda venda){
        this.linhas.add(venda);
        this.fireTableDataChanged();
    }
    
     public void atualiza(){
        this.linhas.clear();
    }
}

