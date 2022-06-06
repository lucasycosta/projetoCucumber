package com.lucas.usuariocucumber.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lucas.usuariocucumber.domain.Usuario;
import com.lucas.usuariocucumber.repository.UsuarioRepository;
import com.lucas.usuariocucumber.util.DataUtil;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Transactional
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
		
	public Usuario cadastrar(Usuario usuario) {
		log.info("SERVICE USUARIO - CADASTRO");
		usuario.setDataCadastro(DataUtil.getData(new Date()));
		return usuarioRepository.save(usuario);
	}
	
	public List<Usuario> buscarTodos(){
		return (List<Usuario>) usuarioRepository.findAll();
	}
	
	public List<Usuario> buscar(Long id){
		log.info("SERVICE USUARIO - BUSCA POR ID");
		return usuarioRepository.buscar(id);
	}
	
	public void excluir(Long id) {
		log.info("SERVICE USUARIO - EXCLUIR");
		usuarioRepository.deleteById(id);
	}

}

