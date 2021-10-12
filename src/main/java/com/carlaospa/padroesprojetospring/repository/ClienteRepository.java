package com.carlaospa.padroesprojetospring.repository;

import com.carlaospa.padroesprojetospring.entity.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {
}
