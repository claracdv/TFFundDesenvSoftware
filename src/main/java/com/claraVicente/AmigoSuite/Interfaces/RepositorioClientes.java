package com.claraVicente.AmigoSuite.Interfaces;

import java.util.Map;
import java.util.HashMap;

import com.claraVicente.AmigoSuite.CasosDeUso.InterfaceRepositorioClientes;
import com.claraVicente.AmigoSuite.Entidades.*;

import org.springframework.stereotype.Repository;

//@Component
@Repository
public class RepositorioClientes implements InterfaceRepositorioClientes{

    @Override
    public Map<String,Cliente> adicionaDados() {
        Map<String,Cliente> listaClientes = new HashMap<>();

        Cidade portoAlegre = new Cidade("Porto Alegre");
        Cidade rioDeJaneiro = new Cidade("Rio de Janeiro");
        Cidade cacavapaDoSul = new Cidade("Cacapava do Sul");
        Cidade restingaSeca = new Cidade("Restinga Seca");
        Cidade curitiba = new Cidade("Curitiba");

        Cliente c1 = new Cliente("1", "02/07/2000",FormaPagamento.DINHEIRO, StatusCliente.FAMILIA, Orcamento.SIMPLES, portoAlegre);
        Cliente c2 = new Cliente("2", "12/11/1967",FormaPagamento.DEBITO, StatusCliente.FAMILIA, Orcamento.LUXO, cacavapaDoSul);
        Cliente c3 = new Cliente("3", "08/03/1993",FormaPagamento.CREDITO, StatusCliente.CASAL, Orcamento.SIMPLES, cacavapaDoSul);
        Cliente c4 = new Cliente("4", "16/09/1945",FormaPagamento.DINHEIRO, StatusCliente.SOLO, Orcamento.LUXO, rioDeJaneiro);
        Cliente c5 = new Cliente("5", "30/01/1958",FormaPagamento.CREDITO, StatusCliente.SOLO, Orcamento.LUXO, restingaSeca);
        Cliente c6 = new Cliente("6", "22/08/2001",FormaPagamento.DEBITO, StatusCliente.CASAL, Orcamento.LUXO, curitiba);
        Cliente c7 = new Cliente("7", "10/04/1973",FormaPagamento.DINHEIRO, StatusCliente.CASAL, Orcamento.SIMPLES, portoAlegre);

        listaClientes.put("1", c1);
        listaClientes.put("2", c2);
        listaClientes.put("3", c3);
        listaClientes.put("4", c4);
        listaClientes.put("5", c5);
        listaClientes.put("6", c6);
        listaClientes.put("7", c7);

        return listaClientes;
    }

    @Override
    public Cliente obtemPorCPF(String cpf) {
        Map<String,Cliente> clientes = adicionaDados();
        Cliente cliente = clientes.get(cpf);
        return cliente;
    }

    @Override
    public Map<String, Cliente> getListaDeClientes() {
        
        return adicionaDados();
    }
    
}