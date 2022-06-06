# language: pt

Funcionalidade: Gerenciar Usuario
  
  a) Como administrador do sistema, eu quero poder cadastrar outros usuarios por uma interface, para manter os registros </br>
  b) Como administrador do sistema, eu quero poder alterar os cadastros por uma interface, para mante-los sempre atualizados </br>
  c) Como administrador do sistema, eu quero poder buscar cada cadastro por uma interface, para obter informações </br>
  d) Como administrador do sistema, eu quero poder excluir os cadastros por uma interface, para quando o registro não for mais util </br>

  Fundo:
    Dado que acesso o sistema

	@unitario
  Cenário: Criar um usuario
    Quando crio um usuario no sistema
    Então o usuario e cadastrado no sistema cucumber

	@unitario
  Cenário: Buscar todos
    Então todos os usuario sao apresentados

	@unitario
  Cenário: Buscar usuario pelo ID
    Quando buscar o usuario pelo id
    Então suas informacoes serao apresentadas

	@unitario
  Cenário: Excluir usuario pelo ID
    Quando buscar o usuario pelo id
    Então o cadastro sera excluido
    
	@unitario
	Esquema do Cenário: Deve incrementar contador
		Dado que o valor do contador é <entrada1>
		Quando eu incrementar <entrada2>
		Então o valor do contador será <resultado>

	Exemplos: 
		| entrada1 | entrada2 | resultado |
		| 15       | 3        | 18        |
		| 20       | 30       | 50        |
		| 150      | 10       | 160       |
		| 20       | 21       | 41        |
    
  @apirest  
	Esquema do Cenário: Cadastrar usuario
		Dado a entrada dos dados do usuario <nome>, <email>, <cpf>, <dataNascimento>
		Quando chamar o método POST
		Então o return sera <status>
	
	Exemplos:
		| nome   | email           | cpf              | dataNascimento | status |
		| 'API1' | 'api1@mail.com' | '003.002.001-00' | '01/01/2022'   | 200    |
		| 'API2' | 'api2@mail.com' | '003.002.001-00' | '01/01/2022'   | 200    |
		| 'API3' | 'api3@mail.com' | '003.002.001-00' | '01/01/2022'   | 200    |
		
		
		
	@mobile @web
  Esquema do Cenário: Fazer login
  	Dado que a tela login esteja aberta
    Quando inserir o <email> e a <senha>
    E clicar no botao cadastrar
    Então irá mostrar o resutado <login.sucesso>

  Exemplos: 
		| email           | senha    | login.senha    |
		| 'api1@mail.com' | '123456' | 'login.sucesso'|
		| 'api2@mail.com' | '123456' | 'login.sucesso'|
		| 'api3@mail.com' | '123456' | 'login.sucesso'|
		| 'api1@mail.com' | 'abcdef' | 'login.falha'  |