package com.claraVicente.AmigoSuite.Interfaces;

import java.util.Map;
import java.util.HashMap;

import com.claraVicente.AmigoSuite.CasosDeUso.InterfaceRepositorioMestre;
import com.claraVicente.AmigoSuite.Entidades.*;

import org.springframework.stereotype.Repository;

//@Component
@Repository
public class RepositorioMestre implements InterfaceRepositorioMestre{

    @Override
    public Map<String,Propriedade> adicionaDados() {
        Map<String,Propriedade> listaPropriedades = new HashMap<>();

        Cidade portoAlegre = new Cidade("Porto Alegre");
        Cidade rioDeJaneiro = new Cidade("Rio de Janeiro");
        Cidade cacavapaDoSul = new Cidade("Cacapava do Sul");
        Cidade restingaSeca = new Cidade("Restinga Seca");
        Cidade curitiba = new Cidade("Curitiba");

        Bairro partenon = new Bairro("Partenon", 50, portoAlegre);
        Bairro rioBranco = new Bairro("Rio Branco", 100, portoAlegre);
        Bairro moinhosDeVento = new Bairro("Moinhos de Vento", 150, portoAlegre);
        Bairro floresta = new Bairro("Floresta", 30, cacavapaDoSul);
        Bairro ibereCamargo = new Bairro("Ibere Camargo", 45, restingaSeca);
        Bairro santaFelicidade = new Bairro("Santa Felicidade", 80, curitiba);
        Bairro leblon = new Bairro("Leblon", 90, rioDeJaneiro);

        Propriedade p1 = new Propriedade("1", 50, partenon, "91530765", "Rua Germano", StatusCliente.SOLO, Orcamento.SIMPLES);
        Propriedade p2 = new Propriedade("2", 70, rioBranco, "89012133", "Avenida Nilo", StatusCliente.FAMILIA, Orcamento.SIMPLES);        
        Propriedade p3 = new Propriedade("3", 137, floresta, "91531765", "Rua Forte", StatusCliente.CASAL, Orcamento.LUXO);        
        Propriedade p4 = new Propriedade("4", 26, ibereCamargo, "91550765", "Rua Jose Euclides", StatusCliente.SOLO, Orcamento.SIMPLES);        
        Propriedade p5 = new Propriedade("5", 500, moinhosDeVento, "10530765", "Avenida Beira-Rio", StatusCliente.SOLO, Orcamento.LUXO);                
        Propriedade p6 = new Propriedade("6", 430, partenon, "91230765", "Rua Taquara", StatusCliente.FAMILIA, Orcamento.LUXO);        
        Propriedade p7 = new Propriedade("7", 199, ibereCamargo, "72530765", "Avenida Imano", StatusCliente.FAMILIA, Orcamento.LUXO);        
        Propriedade p8 = new Propriedade("8", 456, floresta, "31530765", "Rua Farol", StatusCliente.CASAL, Orcamento.LUXO);
        Propriedade p9 = new Propriedade("9", 350, santaFelicidade, "46730765", "Rua das Flores", StatusCliente.FAMILIA, Orcamento.LUXO);
        Propriedade p10 = new Propriedade("10", 510, leblon, "87310765", "Rua da Praia", StatusCliente.CASAL, Orcamento.SIMPLES);

        listaPropriedades.put("1", p1);
        listaPropriedades.put("2", p2);
        listaPropriedades.put("3", p3);
        listaPropriedades.put("4", p4);
        listaPropriedades.put("5", p5);
        listaPropriedades.put("6", p6);
        listaPropriedades.put("7", p7);
        listaPropriedades.put("8", p8);
        listaPropriedades.put("9", p9);
        listaPropriedades.put("10", p10);

        return listaPropriedades;
    }

    @Override
    public Propriedade obtemPorID(String id) {
        Map<String,Propriedade> propriedades = adicionaDados();
        Propriedade propriedade = propriedades.get(id);
        return propriedade;
    }

    @Override
    public Map<String, Propriedade> getListaDePropriedades() {
        
        return adicionaDados();
    }
    
}