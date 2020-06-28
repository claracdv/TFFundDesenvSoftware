package com.claraVicente.AmigoSuite.Interfaces;

import com.claraVicente.AmigoSuite.Entidades.Cliente;
import com.claraVicente.AmigoSuite.Entidades.Propriedade;
import com.claraVicente.AmigoSuite.CasosDeUso.ServicoPagamento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consulta_aluno")
public class FachadaCliente {
    private ServicoPagamento servicoPagamento;

    @Autowired
	public FachadaCliente(ServicoPagamento servicoPagamento) {
		this.servicoPagamento = servicoPagamento;
	}
    
    @CrossOrigin(origins = "*")//"http://localhost")
    @GetMapping("/dadospropriedade")
    public Propriedade getDadosPropriedade(@RequestParam Cliente cliente, @RequestParam Propriedade propriedade){
        // Se o método lançar exceção o SpringBoot gera resposta automática
        // então getDadosAluno deve lançar exceção, não retornar null
        
        return propriedade;
    }
   
    @CrossOrigin(origins = "*") 
    @GetMapping("/pagamento")
    public double getPagamento(@RequestParam Cliente cliente, @RequestParam Propriedade propriedade){
        double custo = servicoPagamento.calculaPagamento(cliente, propriedade);
        return custo;
    }
}