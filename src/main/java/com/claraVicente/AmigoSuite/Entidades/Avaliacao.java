package com.claraVicente.AmigoSuite.Entidades;

public class Avaliacao {
    private int limpeza;
    private int custoBeneficio;
    private int experienciaGeral;
    private static int media;
    private Propriedade propriedade;

    public Avaliacao(Propriedade propriedade, int limpeza, int custoBeneficio, int experienciaGeral){
        this.propriedade = propriedade;
        this.limpeza = limpeza;
        this.custoBeneficio = custoBeneficio;
        this.experienciaGeral = experienciaGeral;
    }

    public int getLimpeza() {
        return limpeza;
    }

    public int getCustoBeneficio() {
        return custoBeneficio;
    }

    public int getExperienciaGeral() {
        return experienciaGeral;
    }

    public Propriedade getPropriedade() {
        return propriedade;
    }

    public int getMedia() {
        return media;
    }

    public static boolean calculaAvaliacao(Propriedade propriedade, int limpeza, int custoBeneficio, int experienciaGeral){
        media = (int) Math.floor((limpeza + custoBeneficio + experienciaGeral) / 3);
        return true;
    }
}