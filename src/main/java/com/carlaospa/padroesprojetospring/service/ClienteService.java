package com.carlaospa.padroesprojetospring.service;

import com.carlaospa.padroesprojetospring.entity.Cliente;

/**
 *  Interface que define o padrão Strategy no domínio de cliente. com
 *  isso, se necessário, podemos ter multiplas implementações dessa mesma
 *  interface.
 */

public interface ClienteService {

    Iterable<Cliente> buscarTodos();
    Cliente buscarPorId(Long id);
    void inserir(Cliente cliente);
    void atualizar(Long id, Cliente cliente);
    void deletar(Long id);
}
