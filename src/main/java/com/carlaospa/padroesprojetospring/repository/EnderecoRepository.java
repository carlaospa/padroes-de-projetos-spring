package com.carlaospa.padroesprojetospring.repository;

import com.carlaospa.padroesprojetospring.entity.Endereco;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends CrudRepository<Endereco, String> {
}
