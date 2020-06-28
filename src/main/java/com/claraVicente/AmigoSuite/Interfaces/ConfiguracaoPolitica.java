package com.claraVicente.AmigoSuite.Interfaces;

import com.claraVicente.AmigoSuite.CasosDeUso.PoliticaPagamento;
import com.claraVicente.AmigoSuite.CasosDeUso.PoliticaClassica;
import com.claraVicente.AmigoSuite.CasosDeUso.PoliticaAniversario;
import com.claraVicente.AmigoSuite.CasosDeUso.PoliticaCincoAlugueis;
import com.claraVicente.AmigoSuite.CasosDeUso.PoliticaAniversarioCincoAlugueis;


import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfiguracaoPolitica {
    @Bean
    @ConditionalOnProperty(name = "politica.pagamento", havingValue = "classica", matchIfMissing = true)
    public PoliticaPagamento opcaoPoliticaClassica() {
        return new PoliticaClassica();
    }
 
    @Bean
    @ConditionalOnProperty(name = "politica.pagamento", havingValue = "aniversario")
    public PoliticaPagamento opcaoPoliticaAniversario() {
        return new PoliticaAniversario();
    }

    @Bean
    @ConditionalOnProperty(name = "politica.pagamento", havingValue = "cincoAlugueis")
    public PoliticaPagamento opcaoPoliticaCincoAlugueis() {
        return new PoliticaCincoAlugueis();
    }

    @Bean
    @ConditionalOnProperty(name = "politica.pagamento", havingValue = "aniversarioCincoAlugueis")
    public PoliticaPagamento opcaoPoliticaAniversarioCincoAlugueis() {
        return new PoliticaAniversarioCincoAlugueis();
    }
}