package com.claraVicente.AmigoSuite.CasosDeUso;

import java.util.Map;

import com.claraVicente.AmigoSuite.Entidades.Cliente;
import com.claraVicente.AmigoSuite.Interfaces.RepositorioClientes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicoConsultaCliente {
    private RepositorioClientes repoClientes;
    //private Propriedade propriedade;

    @Autowired
    public ServicoConsultaCliente(RepositorioClientes repoClientes){
        this.repoClientes = repoClientes;
        //propriedade = null;
    }

    public Cliente getDadosCliente(String cpf){
        Cliente cliente = repoClientes.obtemPorCPF(cpf);
        if (cliente == null){
            throw new IllegalArgumentException("Cliente nao encontrado");
        }else{
            return cliente;
        }
    }

    public Map<String, Cliente> getListaDeClientes(){
        Map<String, Cliente> clientes = repoClientes.getListaDeClientes();
        return clientes;
    }
}