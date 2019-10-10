package com.homeBanking.repository;

import com.homeBanking.entity.Cliente;
import org.springframework.data.repository.CrudRepository;


public interface ClienteRepository extends CrudRepository<Cliente, Long> {

}