Feature: Gerenciar API Usuario
	
	Scenario Outline:
	When criar o usuario com <nome>, <email>, <cpf>, <dataNascimento>
	And chamar o método POST
	Then o return sera status 200 e o <id> sera criado
	
	Examples:
	|nome |email        |cpf  |datNascimento|
	|API1 |api1@mail.com|1234 |01/01/200    |
	|API2 |api2@mail.com|1234 |01/01/200    |
	|API3 |api3@mail.com|1234 |01/01/200    |