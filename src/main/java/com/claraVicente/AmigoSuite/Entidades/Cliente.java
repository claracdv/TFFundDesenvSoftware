package com.claraVicente.AmigoSuite.Entidades;

import com.claraVicente.AmigoSuite.CasosDeUso.*;

import java.util.HashSet;
import java.util.Set;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Cliente {
    private String cpf;
    private String dataNascimento;
    private int numAlugueis;
    private FormaPagamento formaPagamento;
    private StatusCliente statusCliente;
    private Orcamento orcamento;  
    private Cidade cidadeCliente;
    private String dataHoje; 
    private double desconto;
    private double custoTotal;
    private static Set<Avaliacao> avaliacoesCliente;

    public Cliente(String cpf, String dataNascimento, FormaPagamento formaPagamento, StatusCliente statusCliente, Orcamento orcamento, Cidade cidadeCliente){
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        numAlugueis = 0;
        desconto = 0;
        custoTotal = 0;
        this.formaPagamento = formaPagamento;
        this.statusCliente = statusCliente;
        this.orcamento = orcamento;
        this.cidadeCliente = cidadeCliente;
        avaliacoesCliente = new HashSet<>();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM");
        Date date = new Date();
        this.dataHoje = formatter.format(date);
    
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

    private boolean isQuintoAluguel(Cliente cliente){ // 10% desconto
        if (cliente.getNumAlugueis() == 5)
            return true;
        return false;
    }

    private boolean verificaAniversario(Cliente cliente){ // 15% desconto
        String aniversario = cliente.getDataNascimento();
        aniversario = aniversario.substring(0,5);

        if (aniversario == dataHoje)
            return true;
        return false;
    }

    public double getDesconto(Cliente cliente, Propriedade propriedade){
        desconto = (propriedade.getCusto() + propriedade.getCustoBairro()) -  calculaPagamento(cliente, propriedade);

        return desconto;
    }

    public double getCustoTotal(Cliente cliente, Propriedade propriedade){
        return calculaPagamento(cliente, propriedade);
    }

    private double calculaPagamento(Cliente cliente, Propriedade propriedade){
        if (verificaAniversario(cliente)){
            PoliticaAniversario p = new PoliticaAniversario();
            custoTotal = p.calculaPagamento(cliente, propriedade);
            
            return custoTotal;
        }
        else if(isQuintoAluguel(cliente)){
            PoliticaCincoAlugueis p = new PoliticaCincoAlugueis();
            custoTotal = p.calculaPagamento(cliente, propriedade);

            return custoTotal;
        }
        else if(verificaAniversario(cliente) && isQuintoAluguel(cliente)){
            PoliticaAniversarioCincoAlugueis p = new PoliticaAniversarioCincoAlugueis();
            custoTotal = p.calculaPagamento(cliente, propriedade);

            return custoTotal;
        }
        else{
            PoliticaClassica p = new PoliticaClassica();
            custoTotal = p.calculaPagamento(cliente, propriedade);

            return custoTotal; 
        }
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