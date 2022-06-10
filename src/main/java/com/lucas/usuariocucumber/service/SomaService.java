package com.lucas.usuariocucumber.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lucas.usuariocucumber.domain.Soma;
import com.lucas.usuariocucumber.repository.SomaRepository;

@Service
@Transactional
public class SomaService {
	
	@Autowired
	private SomaRepository somaRepository;
	
	public Soma cadastrar(Soma soma) {
		return somaRepository.save(soma);
	}
	
	public Soma somar(Soma soma, Long id) {
		soma = somaRepository.buscar(id);
		if(soma.getResultado() == null) {
			soma.setResultado(soma.getNumero1() + soma.getNumero2());
		}
		return somaRepository.save(soma);
	}
}
