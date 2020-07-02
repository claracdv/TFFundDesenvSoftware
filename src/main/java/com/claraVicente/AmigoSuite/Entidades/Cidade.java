package com.claraVicente.AmigoSuite.Entidades;

public class Cidade {
    
    private String nomeCidade;

    protected Cidade(){

    }

    public Cidade(String nomeCidade){
        this.nomeCidade = nomeCidade;
    }

    public String getNomeCidade() {
        return nomeCidade;
    }

}