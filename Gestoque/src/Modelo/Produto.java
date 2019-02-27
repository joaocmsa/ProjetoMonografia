/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.math.BigDecimal;

/**
 *
 * @author DarthVader
 */
public class Produto {
    private String Nome_Prod, Descricao;
    private BigDecimal Valor_Compra, Valor_Venda;
    private long Quant_minima,Cod_Prod = 0, Cod_Forn, Cod_Fab;

    public long getCod_Fab() {
        return Cod_Fab;
    }

    public void setCod_Fab(long Cod_Fab) {
        this.Cod_Fab = Cod_Fab;
    }

    
    public String getNome_Prod() {
        return Nome_Prod;
    }

    public void setNome_Prod(String Nome_Prod) {
        this.Nome_Prod = Nome_Prod;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public long getCod_Forn() {
        return Cod_Forn;
    }

    public void setCod_Forn(long Cod_Forn) {
        this.Cod_Forn = Cod_Forn;
    }

    public BigDecimal getValor_Compra() {
        return Valor_Compra;
    }

    public void setValor_Compra(BigDecimal Valor_Compra) {
        this.Valor_Compra = Valor_Compra;
    }

    public BigDecimal getValor_Venda() {
        return Valor_Venda;
    }

    public void setValor_Venda(BigDecimal Valor_Venda) {
        this.Valor_Venda = Valor_Venda;
    }

    public long getQuant_minima() {
        return Quant_minima;
    }

    public void setQuant_minima(long Quant_minima) {
        this.Quant_minima = Quant_minima;
    }

    public long getCod_Prod() {
        return Cod_Prod;
    }

    public void setCod_Prod(long Cod_Prod) {
        this.Cod_Prod = Cod_Prod;
    }
    
    
}
