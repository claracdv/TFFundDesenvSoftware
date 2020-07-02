package com.claraVicente.AmigoSuite.CasosDeUso;

import java.util.Map;

import com.claraVicente.AmigoSuite.Entidades.Propriedade;

public interface InterfaceRepositorioMestre {
    
    public Map<String,Propriedade>  adicionaDados();

    public Propriedade obtemPorID(String id);

    public Map<String, Propriedade> getListaDePropriedades();
}