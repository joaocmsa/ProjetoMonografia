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
public class TabelaRelVenda extends AbstractTableModel{

    private List<Venda> linhas = new ArrayList<>();
    private String[] colunas = {"Código","Responsável","Data da venda", "Valor Total","Situação"};
   
    
    public int getRowCount() {
        return linhas.size();
    }

    public int getColumnCount() {
        return colunas.length;
    }

    public Object getValueAt(int linha, int coluna) {
        
        switch(coluna){
            case 0:
                return linhas.get(linha).getCod_Venda();
            case 1:
                return linhas.get(linha).getResposanvel();
            case 2:
                return linhas.get(linha).getData();
            case 3:
                return linhas.get(linha).getValor_Total();
            case 4:
                return linhas.get(linha).getSituacao();
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

