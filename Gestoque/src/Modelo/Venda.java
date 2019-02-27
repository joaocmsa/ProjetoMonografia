/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.math.BigDecimal;
import java.text.*;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author DarthVader
 */
public class Venda {

    private Long Cod_Venda, Cod_Func, Cod_Pag, Quant_vend, Cod_Prod;
    private double Valor_uni;
    private String Nome_Prod, Fabricante, Situacao, Resposanvel, data;
    private BigDecimal sub_total, Valor_Total, Valor_V, Valor_C;
    private Date Data_Venda;

    public BigDecimal getValor_V() {
        return Valor_V;
    }

    public void setValor_V(BigDecimal Valor_V) {
        this.Valor_V = Valor_V;
    }

    public BigDecimal getValor_C() {
        return Valor_C;
    }

    public void setValor_C(BigDecimal Valor_C) {
        this.Valor_C = Valor_C;
    }
    
    

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    
    
    public String getResposanvel() {
        return Resposanvel;
    }

    public void setResposanvel(String Resposanvel) {
        this.Resposanvel = Resposanvel;
    }
    
    
    
    public String getSituacao() {
        return Situacao;
    }

    public void setSituacao(String Situacao) {
        this.Situacao = Situacao;
    }
    
    
    public BigDecimal getSub_total() {
        return sub_total;
    }

    public void setSub_total(BigDecimal sub_total) {
        this.sub_total = sub_total;
    }

    public String getFabricante() {
        return Fabricante;
    }

    public void setFabricante(String Fabricante) {
        this.Fabricante = Fabricante;
    }

    public Long getCod_Prod() {
        return Cod_Prod;
    }

    public void setCod_Prod(Long Cod_Prod) {
        this.Cod_Prod = Cod_Prod;
    }

    public Long getQuant_vend() {
        return Quant_vend;
    }

    public void setQuant_vend(Long Quant_vend) {
        this.Quant_vend = Quant_vend;
    }

    public double getValor_uni() {
        return Valor_uni;
    }

    public void setValor_uni(double Valor_uni) {
        this.Valor_uni = Valor_uni;
    }

    public String getNome_Prod() {
        return Nome_Prod;
    }

    public void setNome_Prod(String Nome_Prod) {
        this.Nome_Prod = Nome_Prod;
    }

    public Long getCod_Venda() {
        return Cod_Venda;
    }

    public void setCod_Venda(Long Cod_Venda) {
        this.Cod_Venda = Cod_Venda;
    }

    public Long getCod_Func() {
        return Cod_Func;
    }

    public void setCod_Func(Long Cod_Func) {
        this.Cod_Func = Cod_Func;
    }

    public Long getCod_Pag() {
        return Cod_Pag;
    }

    public void setCod_Pag(Long Cod_Pag) {
        this.Cod_Pag = Cod_Pag;
    }

    public BigDecimal getValor_Total() {
        return Valor_Total;
    }

    public void setValor_Total(BigDecimal Valor_Total) {
        this.Valor_Total = Valor_Total;
    }

    public Date getData_Venda() {
        return Data_Venda;
    }

    public void setData_Venda(Date Data_Venda) {
            this.Data_Venda = Data_Venda;
    }

    @Override
    public boolean equals(Object obj) {
        Venda outro = (Venda) obj;
        if(this.Cod_Prod.equals(outro.getCod_Prod())){
            outro.setQuant_vend(this.Quant_vend + outro.getQuant_vend());
        }
        return this.Cod_Prod.equals(outro.getCod_Prod());
    }
    
    
}