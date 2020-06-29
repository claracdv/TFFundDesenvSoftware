package com.claraVicente.AmigoSuite.Entidades;

import java.util.HashSet;
import java.util.Set;

public class Cidade {
    private Set<Bairro> listaBairros;
    private String nomeCidade;

    public Cidade(String nomeCidade){
        this.nomeCidade = nomeCidade;
        listaBairros = new HashSet<>();
    }

    public String getNomeCidade() {
        return nomeCidade;
    }

    public boolean adicionaBairro(Bairro bairro){
        listaBairros.add(bairro);
        return true;
    }
}