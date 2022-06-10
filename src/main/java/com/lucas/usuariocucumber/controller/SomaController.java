package com.lucas.usuariocucumber.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lucas.usuariocucumber.domain.Soma;
import com.lucas.usuariocucumber.service.SomaService;

@RestController
@RequestMapping("soma")
public class SomaController {

	@Autowired
	private SomaService somaService;
	
	@PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public Soma cadastrar(@RequestBody Soma soma) {
		return somaService.cadastrar(soma);
	}
	
	@GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public Soma somar(@RequestBody Soma soma, @RequestParam(value = "id") Long id) {
		return somaService.somar(soma, id);
	}
}
