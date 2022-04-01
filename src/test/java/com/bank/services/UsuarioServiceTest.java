package com.bank.services;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.bank.model.repositories.UsuarioRepository;
import com.bank.services.exceptions.RegraNegocioException;
import com.bank.services.implementacoes.UsuarioServiceImplementacoes;


@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
public class UsuarioServiceTest {

	UsuarioService service;
	UsuarioRepository repository;
	
	
	public void setUp() {
		
		repository = Mockito.mock(UsuarioRepository.class);
		service = new UsuarioServiceImplementacoes(repository);
	}
	
	@Test(expected = Test.None.class)
	public void deveValidarEmail() {
		
		//cenário
		Mockito.when(repository.existsByEmail(Mockito.anyString())).thenReturn(false);
		
		//ação
		service.validarEmail("email@email.com");
	}
	
	@Test(expected = RegraNegocioException.class)
	public void deveLancarErroAoValidarmailQuandoExistirEmailCadastrado() {
		
		//cenário
		Mockito.when(repository.existsByEmail(Mockito.anyString())).thenReturn(true);
		
		//ação
		service.validarEmail("email@email.com");
	}
}
