package com.claraVicente.AmigoSuite.CasosDeUso;

import com.claraVicente.AmigoSuite.Entidades.Cliente;
import com.claraVicente.AmigoSuite.Entidades.Propriedade;

public class PoliticaAniversario implements PoliticaPagamento{
    
    @Override
    public double calculaPagamento(Cliente cliente, Propriedade propriedade){
        double custoBasicoBairro = propriedade.getInstanciaBairro().getCustoBasico();
        double custoPropriedade = propriedade.getCusto();
        double custo = custoBasicoBairro + custoPropriedade;
        
        custo = custo * 0.85;
    
        return custo;
    }
}