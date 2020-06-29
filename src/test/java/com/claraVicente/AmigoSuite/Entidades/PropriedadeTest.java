package com.claraVicente.AmigoSuite.Entidades;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PropriedadeTest {
    private Propriedade prop;

    @BeforeEach
    public void setup(){
        prop = new Propriedade(id, custo, cidade, bairro, cep, endereco, classificacao);
    }

}