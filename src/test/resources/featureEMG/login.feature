#language: pt

Funcionalidade: Login

	@unitario
	Esquema do Cenário: Fazer login
  		Dado que a tela login esteja aberta
    	Quando inserir o <email> e a <senha>
    	Então o login sera feito <login.sucesso>

  	Exemplos: 
		| email           | senha    | login.senha    |
		| 'api1@mail.com' | '123456' | 'login.sucesso'|
		| 'api2@mail.com' | '123456' | 'login.sucesso'|
		| 'api3@mail.com' | '123456' | 'login.sucesso'|
		| 'api1@mail.com' | 'abcdef' | 'login.falha'  |
	
	@unitario
	Esquema do Cenário: Esqueci minha senha
		Dado que a tela login esteja aberta
		Quando esquecer minha senha
		Entao uma <mensagem> de erro sera apresentada
		E um email e enviado com uma <senhaProvisoria>
		
	Exemplos: 
		| senhaProvisora  | mensagem     |
		| '12345f6'       | 'login.falha'|
		| '123s456'       | 'login.falha'|
		| '1234r56'       | 'login.falha'|
		| 'abcdef'        | 'login.falha'|
	
	@unitario
	Esquema do Cenário: Trocar senha
		Quando inserir <email> e <senhaProvisoria>
		Entao a tela de troca de senha e aberta
		E insiro uma <novaSenha>
		Entao o metodo de TrocarSenha e chamado
		
	Exemplos: 
		| email           | senhaProvisoria     | novaSenha    |
		| 'api1@mail.com' | '12345f6'           | '123456'     |
		| 'api2@mail.com' | '123s456'           | '123456'     |
		| 'api3@mail.com' | '1234r56'           | '123456'     |
		| 'api1@mail.com' | 'abcdef'            | '123456'     |
		
	@apirest
	Esquema do Cenário: Login no sistema
    	Dado que <email> e a <senha> sao inseridos
    	Quando chamar um metodo GET
    	Então o return sera <status>

  	Exemplos: 
		| email           | senha    | status |
		| 'api1@mail.com' | '123456' | 200    |
		| 'api2@mail.com' | '123456' | 200    |
		| 'api3@mail.com' | '123456' | 200    |
	
	
	@apirest
	Esquema do Cenário: Esqueci senha
		Dado que uma <senha> incorreta e inserida
		Quando chamar o metodo GET de login
		Entao uma <mensagem> de erro e apresentada
		Quando clicar no botao 'Esqueci a senha'
		Quando chamar o metodo GET de envio
		Entao uma <senhaProvisoria> e enviado para o email
		E retornara <status>
		
	Exemplos: 
		| senha     | mensagem     | senhaProvisoria | status | 
		| '12345f6' | 'login.falha'|  'abcd'         | 200    |
		| '123s456' | 'login.falha'|  'abcd'         | 200    |
		| '1234r56' | 'login.falha'|  'abcd'         | 200    |
		| 'abcdef'  | 'login.falha'|  'abcd'         | 200    |
		
		
	@apirest
	Esquema do Cenário: Trocar senha pelo sistema
		Quando <email> e <senhaProvisoria> forem inseridos
		E chamar um metodo GET
		Entao a tela de troca de senha e aberta
		E insiro uma <novaSenha>
		E confirmo a <confirmaSenha>
		Entao o metodo de TrocarSenha sera chamado
		E retornara <status>
		
	Exemplos: 
		| email           | senhaProvisoria | novaSenha    | confirmaSenha | status |
		| 'api1@mail.com' | 'abc'           | '123456'     | '123456'      | 200    |
		| 'api2@mail.com' | 'abc'           | '123456'     | '123456'      | 200    |
		| 'api3@mail.com' | 'abc'           | '123456'     | '123456'      | 200    |
		| 'api1@mail.com' | 'abc'           | '123456'     | '123456'      | 200    |
		
		
		