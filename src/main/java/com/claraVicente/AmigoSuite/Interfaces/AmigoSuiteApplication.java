package com.claraVicente.AmigoSuite.Interfaces;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.claraVicente"})
//@EntityScan(basePackages = {"com.claraVicente"}) // Onde procurar as entidades
public class AmigoSuiteApplication{
    public static void main( String[] args ){
        SpringApplication.run(AmigoSuiteApplication.class, args);
    }
}
