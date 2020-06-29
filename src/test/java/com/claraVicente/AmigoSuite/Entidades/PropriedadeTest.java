package com.claraVicente.AmigoSuite.Entidades;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PropriedadeTest {
    private Propriedade prop;
    private Cidade cidade;
    private Bairro bairro;

    @BeforeEach
    public void setup(){
        cidade = new Cidade("Porto Alegre");
        bairro = new Bairro("Partenon", 50, cidade);
        prop = new Propriedade('4', 90, cidade, bairro, "91536070", "Rua Padre Reus", StatusCliente.SOLO, Orcamento.LUXO);
    }

    @Test
    public void naoSeiOqueFazer(){
        
    }
}