package com.lucas.usuariocucumber.controller;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.lucas.usuariocucumber.domain.Soma;
import com.lucas.usuariocucumber.service.SomaService;

import io.cucumber.java.it.Quando;
import io.cucumber.java.pt.Entao;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class SomaControllerTest {

	@Autowired
	private SomaService somaService;
	private static Soma soma;
	
	@Test
	@Order(1)
	@Quando("os {double} e {double} sao inseridos")
	public void osESaoInseridos(Double numero1, Double numero2) {
		soma = new Soma();
	    soma.setNumero1(numero1);
	    soma.setNumero2(numero2);
	}
	
	@Test
	@Order(2)
	@Entao("sao cadastrados")
	public void saoCadastrados() {
	    somaService.cadastrar(soma);
	}

	@Test
	@Order(3)
	@Quando("buscamos dois numeros cadastrados")
	public void buscamosDoisNumerosCadastrados() {
		somaService.somar(soma, soma.getId());
	}
	
	@Test
	@Order(4)
	@Entao("os numeros serao somados")
	public void osNumerosSeraoSomados() {
	   //assertNotNull(soma.getResultado());
	}

}
