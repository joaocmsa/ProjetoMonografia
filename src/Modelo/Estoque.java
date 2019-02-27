/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author DarthVader
 */
public class Estoque {
    private long quantidade, cod_func, produto_Cod_Prod,quantidade_min;
    private String produto_Nome_Prod,Nome_Fab, Nome_Fantasia;

    public long getQuantidade_min() {
        return quantidade_min;
    }

    public void setQuantidade_min(long quantidade_min) {
        this.quantidade_min = quantidade_min;
    }

    public String getProduto_Nome_Prod() {
        return produto_Nome_Prod;
    }

    public void setProduto_Nome_Prod(String produto_Nome_Prod) {
        this.produto_Nome_Prod = produto_Nome_Prod;
    }

    public String getNome_Fab() {
        return Nome_Fab;
    }

    public void setNome_Fab(String Nome_Fab) {
        this.Nome_Fab = Nome_Fab;
    }

    public String getNome_Fantasia() {
        return Nome_Fantasia;
    }

    public void setNome_Fantasia(String Nome_Fantasia) {
        this.Nome_Fantasia = Nome_Fantasia;
    }
    

    public long getCod_func() {
        return cod_func;
    }
    public void setCod_func(long cod_func) {
        this.cod_func = cod_func;
    }

    public long getProduto_Cod_Prod() {
        return produto_Cod_Prod;
    }
    public void setProduto_Cod_Prod(long produto_Cod_Prod) {
        this.produto_Cod_Prod = produto_Cod_Prod;
    }

    public long getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(long quantidade) {
        this.quantidade = quantidade;
    }
    
}
    