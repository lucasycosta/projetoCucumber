package com.lucas.usuariocucumber.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lucas.usuariocucumber.domain.Usuario;
import com.lucas.usuariocucumber.service.UsuarioService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("usuario")
public class UsuarioController{
	
	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public Usuario cadastrar(@RequestBody Usuario usuario) {
		log.info("CONTROLLER USUARIO - CADASTRO");
		return usuarioService.cadastrar(usuario);
	}
	
	@GetMapping(value = "/todos", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Usuario> buscarTodos(){
		log.info("CONTROLLER USUARIO - BUSCAR TODOS");
		return usuarioService.buscarTodos();
	}
	
	@GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Usuario> buscar(@RequestParam(value = "id") Long idUsuario) {
		log.info("CONTROLLER USUARIO - BUSCAR POR ID");
		return usuarioService.buscar(idUsuario);
	}
	
	@DeleteMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public void excluir(@RequestParam(value = "id") Long idUsuario) {
		log.info("CONTROLLER USUARIO - EXCLUIR");
		usuarioService.excluir(idUsuario);
	}

}
