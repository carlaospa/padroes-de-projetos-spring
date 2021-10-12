package com.carlaospa.padroesprojetospring.service.impl;

import com.carlaospa.padroesprojetospring.entity.Cliente;
import com.carlaospa.padroesprojetospring.repository.ClienteRepository;
import com.carlaospa.padroesprojetospring.entity.Endereco;
import com.carlaospa.padroesprojetospring.repository.EnderecoRepository;
import com.carlaospa.padroesprojetospring.service.ClienteService;
import com.carlaospa.padroesprojetospring.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    // Singleton -> Injetar os componentes do Spring com @Autowired.
    // Strategy -> Implementar os métodos definidos na interface.
    // Facade - > Abstrair integrações com subsistemas, provendo uma interface simples.

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private ViaCepService viaCepService;

    @Override
    public Iterable<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarPorId(Long id) {

       Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.get();
    }

    private void salvarClienteComCep(Cliente cliente){

        String cep = cliente.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() ->{
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        cliente.setEndereco(endereco);
        clienteRepository.save(cliente);
    }

    @Override
    public void inserir(Cliente cliente) {
        salvarClienteComCep(cliente);
    }

    @Override
    public void atualizar(Long id, Cliente cliente) {

        Optional<Cliente> clienteBd = clienteRepository.findById(id);
        if (clienteBd.isPresent()){
            salvarClienteComCep(cliente);
        }
    }

    @Override
    public void deletar(Long id) {
        clienteRepository.deleteById(id);
    }
}
