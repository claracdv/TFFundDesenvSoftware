package com.claraVicente.AmigoSuite.Interfaces;

import java.util.Map;

import com.claraVicente.AmigoSuite.Entidades.Propriedade;
import com.claraVicente.AmigoSuite.CasosDeUso.ServicoConsultaPropriedade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consulta_propriedade")
public class FachadaCliente {
    private ServicoConsultaPropriedade sConsultaPropriedade;


    @Autowired
	public FachadaCliente(ServicoConsultaPropriedade sConsultaPropriedade){
		this.sConsultaPropriedade = sConsultaPropriedade;
	}
    
    @CrossOrigin(origins = "*")//"http://localhost")
    @GetMapping("/dados_propriedade")
    public Propriedade getDadosPropriedade(@RequestParam String id){
        // Se o método lançar exceção o SpringBoot gera resposta automática
        // então getDadosPropriedade deve lançar exceção, não retornar null
        Propriedade propriedade = sConsultaPropriedade.getDadosPropriedade(id);
        return propriedade;
    }
   
    @CrossOrigin(origins = "*")//"http://localhost")
    @GetMapping("/todas_propriedades")
    public Map<String, Propriedade> getListaPropriedades(){
        // Se o método lançar exceção o SpringBoot gera resposta automática
        // então getDadosAluno deve lançar exceção, não retornar null
        Map<String, Propriedade> propriedades = sConsultaPropriedade.getListaDePropriedades();
        return propriedades;
    }  
}