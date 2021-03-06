package com.claraVicente.AmigoSuite.CasosDeUso;

import java.util.Map;

import com.claraVicente.AmigoSuite.Entidades.Propriedade;
import com.claraVicente.AmigoSuite.Interfaces.RepositorioPropriedades;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicoConsultaPropriedade {
    private RepositorioPropriedades repoPropriedades;
    //private Propriedade propriedade;

    @Autowired
    public ServicoConsultaPropriedade(RepositorioPropriedades repoPropriedades){
        this.repoPropriedades = repoPropriedades;
        //propriedade = null;
    }

    public Propriedade getDadosPropriedade(String id){
        Propriedade propriedade = repoPropriedades.obtemPorID(id);
        if (propriedade == null){
            throw new IllegalArgumentException("Propriedade nao encontrada");
        }else{
            return propriedade;
        }
    }

    public Map<String, Propriedade> getListaDePropriedades(){
        Map<String, Propriedade> propriedades = repoPropriedades.getListaDePropriedades();
        return propriedades;
    }
}