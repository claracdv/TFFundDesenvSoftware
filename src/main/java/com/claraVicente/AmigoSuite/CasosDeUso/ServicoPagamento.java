package com.claraVicente.AmigoSuite.CasosDeUso;

import com.claraVicente.AmigoSuite.Entidades.Cliente;
import com.claraVicente.AmigoSuite.Entidades.Propriedade;

public class ServicoPagamento {
    private Cliente cliente;
    private Propriedade propriedade;
    private double custoTotal;
    private String data; // Implementar ----> Obter a data atual
    private PoliticaPagamento politicaPagamento;

    public ServicoPagamento(Cliente cliente, Propriedade propriedade, PoliticaPagamento politicaPagamento){
        this.cliente = cliente;
        this.propriedade = propriedade;
        this.politicaPagamento = politicaPagamento;
    }

    public boolean isQuintoAluguel(Cliente cliente){ // 10% desconto
        if (cliente.getNumAlugueis() == 5)
            return true;
        return false;
    }

    public boolean verificaAniversario(Cliente cliente){ // 15% desconto
        String aniversario = cliente.getDataNascimento();
        aniversario = aniversario.substring(0,6);

        if (aniversario == data)
            return true;
        return false;
    }

    public double calculaPagamento(Cliente cliente, Propriedade propriedade){
        return politicaPagamento.calculaPagamento(cliente, propriedade); 
        // Nao deve especificar qual tipo de politica de pagamento deve ser utilizada?
    }
}