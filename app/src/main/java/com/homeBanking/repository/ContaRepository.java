package com.homeBanking.repository;

import com.homeBanking.entity.Conta;
import org.springframework.data.repository.CrudRepository;


public interface ContaRepository extends CrudRepository<Conta, Long> {

}