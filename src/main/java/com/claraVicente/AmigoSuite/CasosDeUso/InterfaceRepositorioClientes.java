package com.claraVicente.AmigoSuite.CasosDeUso;

import java.util.Map;

import com.claraVicente.AmigoSuite.Entidades.Cliente;

public interface InterfaceRepositorioClientes {
    
    public Map<String,Cliente> adicionaDados();

    public Cliente obtemPorCPF(String cpf);

    public Map<String, Cliente> getListaDeClientes();
}