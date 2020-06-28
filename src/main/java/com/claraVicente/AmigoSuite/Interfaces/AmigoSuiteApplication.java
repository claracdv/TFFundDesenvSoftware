package com.claraVicente.AmigoSuite.Interfaces;

import com.claraVicente.AmigoSuite.Entidades.Bairro;
import com.claraVicente.AmigoSuite.Entidades.Cidade;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.claraVicente"})
@EnableJpaRepositories(basePackages = {"com.claraVicente"}) // Onde procurar as interfaces dos repositórios do JPA
@EntityScan(basePackages = {"com.claraVicente"}) // Onde procurar as entidades

public class AmigoSuiteApplication{
    public static void main( String[] args ){
        Cidade portoAlegre = new Cidade("Porto Alegre");
        Bairro partenon = new Bairro("Partenon", 100, portoAlegre);
        Bairro rioBranco = new Bairro("RioBranco", 250, portoAlegre);
        portoAlegre.adicionaBairro(partenon);
        portoAlegre.adicionaBairro(rioBranco);
        SpringApplication.run(AmigoSuiteApplication.class, args);
    }
}
