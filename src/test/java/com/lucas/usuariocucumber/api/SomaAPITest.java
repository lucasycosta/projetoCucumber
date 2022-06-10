package com.lucas.usuariocucumber.api;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;

import io.cucumber.java.es.Dado;
import io.cucumber.java.it.Quando;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Então;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(OrderAnnotation.class)
public class SomaAPITest {
	
	private final static String BASE_URI = "http://localhost:8080/soma";

	private RequestSpecification httpRequest = RestAssured.given();

	private Response response;

	@BeforeAll
	public static void setup() {
		RestAssured.baseURI = BASE_URI;
	}
	
	@Test
	@Order(10)
	@Dado("inserimos {double} e {double}")
	public void inserimosE(Double numero1, Double numero2) {
		httpRequest.body("{\"numero1\": \"" + numero1 + "\", \"numero2\": \"" + numero2 + "\"}").contentType(ContentType.JSON);
	}
	
	@Test
	@Order(11)
	@Quando("chamamos um metodo POST")
	public void chamamosUmMetodoPOST() {
		response = httpRequest.post("soma");
	}

	@Test
	@Order(12)
	@Então("o return e {int}")
	public void oReturnE(Integer code) {
		response.then().log().all().statusCode(code);
	}

}
