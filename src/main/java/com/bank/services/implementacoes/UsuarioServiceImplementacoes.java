package com.bank.services.implementacoes;

import com.bank.model.entities.Usuario;
import com.bank.model.repositories.UsuarioRepository;
import com.bank.services.UsuarioService;

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
		
		
	}
	
}
