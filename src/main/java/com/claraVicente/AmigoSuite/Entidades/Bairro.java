package com.claraVicente.AmigoSuite.Entidades;

public class Bairro {
    private String nomeBairro;
    private double custoBasico;
    private Cidade cidade;

    public Bairro(String nomeBairro, double custoBasico, Cidade cidade){
        this.nomeBairro = nomeBairro;
        this.custoBasico = custoBasico;
        this.cidade = cidade;
    }

   /*********************
    ****** Getters ******
    *********************/

    public String getCidade() {
        return cidade.getNomeCidade();
    }

    public String getNomeBairro() {
        return nomeBairro;
    }

    public double getCustoBasico() {
        return custoBasico;
    }

   /*********************
    ****** Setters ******
    *********************/

    public void setCustoBasico(double custoBasico) {
        this.custoBasico = custoBasico;
    }
}