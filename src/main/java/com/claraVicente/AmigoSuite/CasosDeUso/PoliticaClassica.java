package com.claraVicente.AmigoSuite.CasosDeUso;

import com.claraVicente.AmigoSuite.Entidades.Cliente;
import com.claraVicente.AmigoSuite.Entidades.Propriedade;

public class PoliticaClassica implements PoliticaPagamento{

    @Override
    public double calculaPagamento(Cliente cliente, Propriedade propriedade){
        double custoBasicoBairro = propriedade.getInstanciaBairro().getCustoBasico();
        double custoPropriedade = propriedade.getCusto();
        double custo = custoBasicoBairro + custoPropriedade;
    
        incrementaNumAluguel(cliente);

        return custo;
    }

    private void incrementaNumAluguel(Cliente cliente){
        cliente.setNumAlugueis(cliente.getNumAlugueis()+1);
    }
}