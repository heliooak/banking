package com.bank.services.implementacoes;

import org.springframework.stereotype.Service;

import com.bank.model.entities.Usuario;
import com.bank.model.repositories.UsuarioRepository;
import com.bank.services.UsuarioService;
import com.bank.services.exceptions.RegraNegocioException;

@Service
public class UsuarioServiceImplementacoes implements UsuarioService{

	private UsuarioRepository repository;
	
	public UsuarioServiceImplementacoes(UsuarioRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public Usuario autenticar(String email, String senha) {
		
		return null;
	}

	@Override
	public Usuario salvarUsuario(Usuario usuario) {
		
		return null;
	}

	@Override
	public void validarEmail(String email) {
		
		boolean existe = repository.existsByEmail(email);
		
		if(existe) {
			throw new RegraNegocioException("Já existe um usuário cadastrado com este email.");
		}

	}
	
}
