package com.lucas.usuariocucumber.controller;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.lucas.usuariocucumber.domain.Usuario;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import io.cucumber.spring.CucumberContextConfiguration;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
@CucumberContextConfiguration
public class UsuarioControllerTest {

	@Autowired
	private UsuarioController usuarioController;
	private static Usuario usuario;

	@Test
	@Order(1)
	@Given("que acesso o sistema")
	public void que_acesso_o_sistema() {
		log.debug("SERVIÇO NO AR");
	}

	@Test
	@Order(10)
	@When("crio um usuario no sistema")
	public void crio_um_usuario() {
		usuario = new Usuario();
		usuario.setNome("Teste Unitario");
		usuario.setEmail("unitario@mail.com");
		usuario.setCpf("123456");
		usuario.setDataNascimento("01/01/2000");
	}

	@Test
	@Order(11)
	@Then("o usuario e cadastrado no sistema cucumber")
	public void o_usuario_e_cadastrado_no_sistema_cucumber() {
		usuarioController.cadastrar(usuario);
	}

	@Test
	@Order(20)
	@Then("todos os usuario sao apresentados")
	public List<Usuario> todos_os_usuario_sao_apresentados() {
		return usuarioController.buscarTodos();
	}

	@Test
	@Order(30)
	@When("buscar o usuario pelo id")
	public void buscar_o_usuario_pelo_id() {
		usuarioController.buscar((long) 2);
	}

	@Test
	@Order(31)
	@Then("suas informacoes serao apresentadas")
	public void suas_informacoes_serao_apresentadas() {
		assertNotNull(usuario);
	}

	@Test
	@Order(40)
	@Then("o cadastro sera excluido")
	public void o_cadastro_sera_excluido() {
		usuarioController.excluir(usuario.getId());
	}

	Integer contador = 0;

	@Test
	@Order(51)
	@Dado("que o valor do contador é {int}")
	public void queOValorDoContadorÉ(Integer entrada1) {
		contador = entrada1;
	}

	@Test
	@Order(52)
	@Quando("eu incrementar {int}")
	public void euIncrementar(Integer entrada2) {
		contador = contador + entrada2;
	}

	@Test
	@Order(53)
	@Então("o valor do contador será {int}")
	public void oValorDoContadorSerá(Integer resultado) {
		Assert.assertEquals("O valor está errado", contador, resultado);
	}

}
