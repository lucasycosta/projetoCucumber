#language: pt
Funcionalidade: testando configurações cucumber
	
	@unitario
  Esquema do Cenário: Cadastrar dois numeros
    Quando os <numero1> e <numero2> sao inseridos
    Entao sao cadastrados
  Exemplos:
	 |numero1|numero2|
	 |10	   |20     |
	 |97	   |29     |
	 |70     |15     |
	 |54     |37     |
	
	@unitario
  Cenario: Somando dois numeros
    Quando buscamos dois numeros cadastrados
    Entao os numeros serao somados
    
   @apirest
   Esquema do Cenário: Cadastrar dois numeros
   	Dados inserimos <numero1> e <numero2>
   	Quando chamamos um metodo POST
   	Entao o return e <code>
   	
   Exemplos:
	 |numero1|numero2|code|
	 |10	   |20     |200 |
	 |97	   |29     |200 |
	 |70     |15     |200 |
	 |54     |37     |200 |
