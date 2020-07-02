package com.claraVicente.AmigoSuite.Entidades;

import java.util.ArrayList;
import java.util.List;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Propriedade {
    
    private String id;
    private boolean ocupada;
    private Bairro bairro;
    private String cep;
    private String endereco;
    private double custo;
    private StatusCliente indicadaPara;
    private Orcamento orcamentoIndicado;
    private static int numAvaliacoes;
    private static int avaliacaoMedia;
    private static List<Avaliacao> avaliacoesPropriedade;
    private String dataHoje; 

    public Propriedade(String id, double custo, Bairro bairro, String cep, String endereco, StatusCliente indicadaPara, Orcamento orcamentoIndicado) {
        this.id = id;
        this.custo = custo;
        ocupada = false;
        this.bairro = bairro;
        this.cep = cep;
        this.endereco = endereco;
        this.indicadaPara = indicadaPara;
        this.orcamentoIndicado = orcamentoIndicado;
        numAvaliacoes = 0;
        avaliacaoMedia = 0;
        avaliacoesPropriedade = new ArrayList<>();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM");
        Date date = new Date();
        this.dataHoje = formatter.format(date);
    }

    public static boolean adicionaAvaliacao(Avaliacao avaliacao) {
        avaliacoesPropriedade.add(avaliacao);
        return true;
    }

    public static boolean incrementaNumAvaliacoes(){
        numAvaliacoes++;
        return true;
    }

    public static boolean calculaAvaliacaoMedia(){
        int resultado = 0;
        
        for (Avaliacao a : avaliacoesPropriedade){
            resultado += a.getMedia();
        }

        avaliacaoMedia = resultado / numAvaliacoes;
        return true;
    }

   /*********************
    ****** Getters ******
    *********************/

    public String getId() {
        return id;
    }

    public String getOcupada(){
        if (ocupada == true)
            return "Ocupado";
        return "Disponivel";
    }

    public String getCidade() {
        return bairro.getInstanciaCidade().getNomeCidade();
    }

    public String getBairro() {
        return bairro.getNomeBairro();
    }

    public Bairro getInstanciaBairro(){
        return bairro;
    }

    public String getCep() {
        return cep;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getOrcamentoIndicado() {
        return orcamentoIndicado.toString();
    }

    public String getIndicadaPara() {
        return indicadaPara.toString();
    }

    public int getAvaliacaoMedia() {
        return avaliacaoMedia;
    }

    public int getNumAvaliacoes() {
        return numAvaliacoes;
    }

    public double getCusto() {
        return custo;
    }

    public double getCustoBairro(){
        return bairro.getCustoBasico();
    }

    
    /*********************
    ****** Setters ******
    *********************/

    //public void setOcupada(boolean ocupada) {
    //    this.ocupada = ocupada;
    //}

    public void setOrcamentoIndicado(Orcamento orcamentoIndicado) {
        this.orcamentoIndicado = orcamentoIndicado;
    }

    public void setCusto(double custo) {
        this.custo = custo;
    }

    @Override
    public String toString() {
        return ("ID: " + this.id + ", Cidade: " + this.getCidade() + ", Custo " + this.custo);
    }
}