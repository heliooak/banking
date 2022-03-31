package com.bank.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.model.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	boolean existsByEmail(String email);
	
}
