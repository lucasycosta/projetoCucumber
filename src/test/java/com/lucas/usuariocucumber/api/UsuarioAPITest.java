package com.lucas.usuariocucumber.api;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import io.cucumber.spring.CucumberContextConfiguration;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(OrderAnnotation.class)
@CucumberContextConfiguration
public class UsuarioAPITest {

	private final static String BASE_URI = "http://localhost:8080/usuario";

	private RequestSpecification httpRequest = RestAssured.given();

	private Response response;

	@BeforeAll
	public static void setup() {
		RestAssured.baseURI = BASE_URI;
	}
	
	/*
	 * @Test
	 * 
	 * @Order(1)
	 * 
	 * @Given("que acesso o sistema") public void que_acesso_o_sistema() {
	 * log.debug("SERVIÇO NO AR"); }
	 */

	@Test
	@Order(10)
	@Dado("a entrada dos dados do usuario {string}, {string}, {string}, {string}")
	public void aEntradaDosDadosDoUsuario(String nome, String email, String cpf, String dataNascimento) {
		log.debug("** REST API UsuarioAPITest - aEntradaDosDadosDoUsuario");
		httpRequest.body("{\"cpf\": \"" + cpf + "\", \"dataNascimento\": \"" + dataNascimento + "\", \"email\": \"" + email
				+ "\", \"nome\": \""+ nome + "\"}").contentType(ContentType.JSON);
	}

	@Test
	@Order(20)
	@Quando("chamar o método POST")
	public void chamarOMétodoPOST() {
		log.debug("** REST API UsuarioAPITest - chamarOMétodoPOST");
		response = httpRequest.post("usuario");
	}

	@Test
	@Order(30)
	@Então("o return sera {int}")
	public void oReturnSera(Integer code) {
		log.debug("** REST API UsuarioAPITest - oReturnSera");
		response.then().log().all().statusCode(code);
	}

}
