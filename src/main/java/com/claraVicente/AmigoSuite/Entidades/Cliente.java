package com.claraVicente.AmigoSuite.Entidades;

import java.util.HashSet;
import java.util.Set;

public class Cliente {
    private String cpf;
    private String dataNascimento;
    private int numAlugueis;
    private FormaPagamento formaPagamento;
    private StatusCliente statusCliente;
    private Orcamento orcamento;  
    private Cidade cidadeCliente;
    private static Set<Avaliacao> avaliacoesCliente;

    public Cliente(String cpf, String dataNascimento, FormaPagamento formaPagamento, StatusCliente statusCliente, Orcamento orcamento, Cidade cidadeCliente){
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        numAlugueis = 0;
        this.formaPagamento = formaPagamento;
        this.statusCliente = statusCliente;
        this.orcamento = orcamento;
        this.cidadeCliente = cidadeCliente;
        avaliacoesCliente = new HashSet<>();
    }

    public boolean fazerAvaliacao(Propriedade propriedade, int limpeza, int custoBeneficio, int experienciaGeral){
        Avaliacao avaliacao = new Avaliacao(propriedade, limpeza, custoBeneficio, experienciaGeral);
        avaliacoesCliente.add(avaliacao);
        Propriedade.adicionaAvaliacao(avaliacao);
        Propriedade.incrementaNumAvaliacoes();
        Propriedade.calculaAvaliacaoMedia();
        return true;
    }

    /*********************
    ****** Getters ******
    *********************/

    public String getCpf() {
        return cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public int getNumAlugueis() {
        return numAlugueis;
    }

    public String getFormaPagamento() {
        return formaPagamento.toString();
    }

    public String getStatusCliente() {
        return statusCliente.toString();
    }

    public String getOrcamento() {
        return orcamento.toString();
    }

    public String getCidadeCliente() {
        return cidadeCliente.getNomeCidade();
    }

    /*********************
    ****** Setters ******
    *********************/

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public void setNumAlugueis(int numAlugueis) {
        this.numAlugueis = numAlugueis;
    }

    public void setOrcamento(Orcamento orcamento) {
        this.orcamento = orcamento;
    }

    public void setStatusCliente(StatusCliente statusCliente) {
        this.statusCliente = statusCliente;
    }

    public void setCidadeCliente(Cidade cidadeCliente) {
        this.cidadeCliente = cidadeCliente;
    }
}