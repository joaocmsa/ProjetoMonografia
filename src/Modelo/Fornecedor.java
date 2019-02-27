package Modelo;

/**
 *
 * @author DarthVader
 */
public class Fornecedor {
    private long Cod_Fornc, Cod_Func, Tempo_entrega;
    private String Nome_fantasia, Endereco, CNPJ, Telefone, Email, Site;

    public long getCod_Fornc() {
        return Cod_Fornc;
    }

    public void setCod_Fornc(long Cod_Fornc) {
        this.Cod_Fornc = Cod_Fornc;
    }

    public long getCod_Func() {
        return Cod_Func;
    }

    public void setCod_Func(long Cod_Func) {
        this.Cod_Func = Cod_Func;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String Telefone) {
        this.Telefone = Telefone;
    }

    public String getNome_fantasia() {
        return Nome_fantasia;
    }

    public void setNome_fantasia(String Nome_fantasia) {
        this.Nome_fantasia = Nome_fantasia;
    }

    public String getEndereco() {
        return Endereco;
    }

    public void setEndereco(String Endereco) {
        this.Endereco = Endereco;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getSite() {
        return Site;
    }

    public void setSite(String Site) {
        this.Site = Site;
    }

    public long getTempo_entrega() {
        return Tempo_entrega;
    }

    public void setTempo_entrega(long Tempo_entrega) {
        this.Tempo_entrega = Tempo_entrega;
    }
    
}
