package com.claraVicente.AmigoSuite.Entidades;

import java.util.ArrayList;
import java.util.List;

public class Propriedade {
    private String id;
    private boolean ocupada;
    private Cidade cidade;
    private Bairro bairro;
    private String cep;
    private String endereco;
    private double custo;
    private Orcamento classificacao;
    private static int numAvaliacoes;
    private static int avaliacaoMedia;
    private static List<Avaliacao> avaliacoesPropriedade;

    public Propriedade(String id, int custo, Cidade cidade, Bairro bairro, String cep, String endereco, Orcamento classificacao) {
        this.id = id;
        this.custo = custo;
        ocupada = false;
        this.cidade = cidade;
        this.bairro = bairro;
        this.cep = cep;
        this.endereco = endereco;
        this.classificacao = classificacao;
        numAvaliacoes = 0;
        avaliacaoMedia = 0;
        avaliacoesPropriedade = new ArrayList<>();
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

    public boolean getOcupada(){
        return ocupada;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public Bairro getBairro() {
        return bairro;
    }

    public String getCep() {
        return cep;
    }

    public String getEndereco() {
        return endereco;
    }

    public Orcamento getClassificacao() {
        return classificacao;
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

    /*********************
    ****** Setters ******
    *********************/

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }

    public void setClassificacao(Orcamento classificacao) {
        this.classificacao = classificacao;
    }

    public void setCusto(double custo) {
        this.custo = custo;
    }
}