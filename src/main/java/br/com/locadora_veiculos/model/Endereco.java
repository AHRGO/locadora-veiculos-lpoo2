package br.com.locadora_veiculos.model;
/**
 * Classe depreciada por que era muito trabalhoso para pouco tempo de desenvolvimento
* */
@Deprecated
public class Endereco {
    private String nomeRua;
    private int numeroRua;
    private String cep; //como é isso em pt-br?
    private String nomeCidade;
    private String nomeEstado;
    //TODO: FAZER ENUM DAS SIGLAS DOS ESTADOS; NA VDD ENUM DE TODOS OS ESTADOS DE UMA VEZ

    public Endereco() {}

    public Endereco(String nomeRua, int numeroRua, String cep, String nomeCidade, String nomeEstado) {
                this.nomeRua =  nomeRua;
                this.numeroRua =  numeroRua;
                this.cep =  cep;
                this.nomeCidade =  nomeCidade;
                this.nomeEstado =  nomeEstado;
    }



    public String getNomeRua() {
        return this.nomeRua;
    }
    public void setNomeRua(String nomeRua) {
        this.nomeRua = nomeRua;
    }

    public int getNumeroRua() {
        return this.numeroRua;
    }
    public void setNumeroRua(int numeroRua) {
        this.numeroRua = numeroRua;
    }

    public String getCep() {
        return this.cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNomeCidade() {
        return this.nomeCidade;
    }
    public void setNomeCidade(String nomeCidade) {
        this.nomeCidade = nomeCidade;
    }

    public String getNomeEstado() {
        return this.nomeEstado;
    }
    public void setNomeEstado(String nomeEstado) {
        this.nomeEstado = nomeEstado;
    }
}
