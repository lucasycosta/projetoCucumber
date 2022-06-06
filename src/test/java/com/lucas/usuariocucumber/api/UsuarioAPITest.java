package com.lucas.usuariocucumber.api;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.boot.test.context.SpringBootTest;

import com.lucas.usuariocucumber.domain.Usuario;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

//@CucumberContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(OrderAnnotation.class)
public class UsuarioAPITest {

	private final static String BASE_URI = "http://localhost:8080/usuario";
	
	private static Usuario usuario; 
	
	/*
	 * @Test
	 * 
	 * @Order(10)
	 * 
	 * @Given("acesso a requisição {string}") public void acesso_a_requisição(String
	 * endpoint) { RestAssured.given() .contentType(ContentType.JSON) .when()
	 * .get(endpoint) .then() .log().all() .statusCode(200); }
	 */

	/*
	 * @When("criar o usuario com {string}, {string}, {string}, {string}") public
	 * void criar_o_usuario_com_api1_api1_mail_com_data_nascimento(String nome,
	 * String email, String cpf, String dataNascimento) {
	 * validatableResponse.assertThat().statusCode(200).
	 * body(body(containsString(nome))) .contentType(ContentType.JSON) .when()
	 * .post("noticia") .then() .log().all() .statusCode(200); }
	 */

	@When("chamar o método POST")
	public void chamar_o_método_post() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("o return sera status {int} e o <id> sera criado")
	public void o_return_sera_status_e_o_id_sera_criado(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
}
