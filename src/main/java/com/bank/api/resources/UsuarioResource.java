package com.bank.api.resources;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.api.dto.UsuarioDTO;
import com.bank.model.entities.Usuario;
import com.bank.services.LancamentoService;
import com.bank.services.UsuarioService;
import com.bank.services.exceptions.ErroAutenticacao;
import com.bank.services.exceptions.RegraNegocioException;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioResource {

	private UsuarioService usuarioService;
	private LancamentoService lancamentoService;
	
	
	@Autowired
	public UsuarioResource(LancamentoService lancamentoService, UsuarioService usuarioService) {
		this.lancamentoService = lancamentoService;
		this.usuarioService = usuarioService;
	}
	
	
	@PostMapping("/autenticar")
	public ResponseEntity autenticar(@RequestBody UsuarioDTO dto) {
		try {
			Usuario usuarioAutenticado = usuarioService.autenticar(dto.getEmail(), dto.getSenha());
			return ResponseEntity.ok(usuarioAutenticado);
		}catch (ErroAutenticacao e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@PostMapping
	public ResponseEntity  salvar(@RequestBody UsuarioDTO dto) {
		
		Usuario usuario = new Usuario();
		usuario.setNome(dto.getNome());
		usuario.setEmail(dto.getEmail());
		usuario.setSenha(dto.getSenha());
		
		try {
			Usuario usuarioSalvo = usuarioService.salvarUsuario(usuario);
			return new ResponseEntity(usuarioSalvo, HttpStatus.CREATED );
		}catch (RegraNegocioException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		
	}
	
	@GetMapping("{id}/saldo")
	public ResponseEntity obterSaldo(@PathVariable("id") Long id) {
		Optional<Usuario> usuario = usuarioService.obterPorId(id);
		
		if(!usuario.isPresent()) {
			return new ResponseEntity( HttpStatus.NOT_FOUND );
		}
		
		BigDecimal saldo = lancamentoService.obterSaldoPorUsuario(id);
		return ResponseEntity.ok(saldo);
	}
}
