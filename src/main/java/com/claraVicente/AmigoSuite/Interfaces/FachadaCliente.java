package com.claraVicente.AmigoSuite.Interfaces;

import java.util.Map;

import com.claraVicente.AmigoSuite.Entidades.Cliente;
import com.claraVicente.AmigoSuite.CasosDeUso.ServicoConsultaCliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consulta_cliente")
public class FachadaCliente {
    private ServicoConsultaCliente sConsultaCliente;


    @Autowired
	public FachadaCliente(ServicoConsultaCliente sConsultaCliente){
		this.sConsultaCliente = sConsultaCliente;
	}
    
    @CrossOrigin(origins = "*")//"http://localhost")
    @GetMapping("/dadoscliente")
    public Cliente getDadosPropriedade(@RequestParam String cpf){
        // Se o método lançar exceção o SpringBoot gera resposta automática
        // então getDadosPropriedade deve lançar exceção, não retornar null
        Cliente cliente = sConsultaCliente.getDadosCliente(cpf);
        return cliente;
    }
   
    @CrossOrigin(origins = "*")//"http://localhost")
    @GetMapping("/todosclientes")
    public Map<String, Cliente> getListaClientes(){
        // Se o método lançar exceção o SpringBoot gera resposta automática
        // então getDadosAluno deve lançar exceção, não retornar null
        Map<String, Cliente> clientes = sConsultaCliente.getListaDeClientes();
        return clientes;
    }  
}