package com.claraVicente.AmigoSuite.CasosDeUso;
import com.claraVicente.AmigoSuite.Entidades.Cliente;
import com.claraVicente.AmigoSuite.Entidades.Propriedade;

import java.util.Calendar;

public class Pagamento {

    Cliente cliente;
    Propriedade propriedade;
    double custoTotal;
    String data; // Implementar ----> Obter a data atual


    public Pagamento(Cliente cliente, Propriedade propriedade){
        this.cliente = cliente;
        this.propriedade = propriedade;
    }

    public double calculaPagamento(Cliente cliente, Propriedade propriedade){
        boolean quintoAluguel = isQuintoAluguel(cliente);
        boolean isAniversario = verificaAniversario(cliente);
        double custoBasicoBairro = propriedade.getBairro().getCustoBasico();
        double custoPropriedade = propriedade.getCusto();
        double custo = custoBasicoBairro + custoPropriedade;

        if (quintoAluguel && isAniversario){
            custo = custo * 0.75;
            return custo;
        }  
        else if (quintoAluguel){
            custo = custo * 0.9;
            return custo;
        }
        else if (isAniversario){
            custo = custo * 0.85;
            return custo;
        }

        return custo;
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
}