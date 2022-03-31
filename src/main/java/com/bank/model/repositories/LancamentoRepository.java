package com.bank.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.model.entities.Lancamento;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long>{

}
