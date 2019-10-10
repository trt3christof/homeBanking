package com.homeBanking.repository;

import com.homeBanking.entity.Banco;
import org.springframework.data.repository.CrudRepository;


public interface BancoRepository extends CrudRepository<Banco, Long> {

}