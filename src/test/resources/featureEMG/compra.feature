#language: pt

Funcionalidade: Comprar Acesso
	
	@unitario
	Esquema do Cenario: Comprar assinatura do sistema
		Dado que o usuario acessa o site
		Quando selecionar <tipo_acesso>, <tipo_cotrato> e <numero_usuarios>
		Entao abrira <opcao_cadastro>
	
	Exemplos:
	|tipo_acesso    |tipo_contrato|numero_usuarios|opcao_cadastro |
	|'EMPRESA'      |'FREE'       | 50            |'ACESSO.PJ'    |
	|'GRADUCAO'     |'BASICO'     | 100           |'ACESSO.PJ'    |
	|'PESSOA_FISICA'|'FULL'				| 1             |'ACESSO.PF'    |
		
	@unitario
	Esquema do Cenario: Cadastrar pessoa juridica ou graducao
		Dado a insercao dos dados de PJ <nome_empresa>, <endereco>, <cnpj>, <nome_responsavel>, <email_responsavel>, <cpf>, <telefone_responsavel>, <senha>, <numero_cartao>, <validade> e <cvv> 
		Quando o metodo GRAVAR PJ
		Entao PJ sera cadastrado
		
		Exemplos:
	| nome_empresa        | endereco          | cnpj   | nome_responsavel   | email_responsavel   |cpf      | telefone_responsavel | senha   | numero_cartao | validade | cvv  | 
	| 'EmpresaUnitario1'  | 'Rio de Janeiro'  | '12987'| 'Ricardo Resp'     | 'ricardo@mail.com'  | '123654'| '(61) 99999-9999'    | '123456'| '369852'      | '06/30'  | '123'| 
	| 'EmpresaUnitario2'  | 'Goiania'         | '12987'| 'Paula Resp'       | 'paula@mail.com'    | '123654'| '(61) 99999-9999'    | '123457'| '369852'      | '06/30'  | '123'| 
	
	@unitario
	Esquema do Cenario: Cadastrar pessoa fisica
		Dado a insercao dos dados de PF <nome_responsavel>, <email_responsavel>, <cpf>, <telefone_responsavel>, <senha>, <numero_cartao>, <validade> e <cvv> 
	  Quando chamar o metodo GRAVAR PF
	  Entao PF sera cadastrada
	  
	  Exemplos:
	| nome_responsavel   | email_responsavel   |cpf      | telefone_responsavel | senha   | numero_cartao | validade | cvv  | 
	| 'Ricardo Resp'     | 'ricardo@mail.com'  | '123654'| '(61) 99999-9999'    | '123456'| '369852'      | '06/30'  | '123'| 
	| 'Paula Resp'       | 'paula@mail.com'    | '123654'| '(61) 99999-9999'    | '123457'| '369852'      | '06/30'  | '123'| 
	  
	@apirest
	Esquema do Cenario: Cadastrar PJ ou graducao
		Dado a insercao dos dados de PJ <nome_empresa>, <endereco>, <cnpj>, <nome_responsavel>, <email_responsavel>, <cpf>, <telefone_responsavel>, <senha>, <numero_cartao>, <validade> e <cvv> 
		Quando chamar o metodo POST de PJ
		Entao o <status> PJ sera
	
	Exemplos:
	| nome_empresa   | endereco    | cnpj   | nome_responsavel | email_responsavel |cpf      | telefone_responsavel | senha   | numero_cartao | validade | cvv  | status |
	| 'EmpresaAPI1'  | 'Brasilia'  | '12987'| 'Paulo Resp'     | 'paulo@mail.com'  | '123654'| '(61) 99999-9999'    | '123456'| '369852'      | '06/30'  | '123'| 200    |
	| 'EmpresaAPI2'  | 'Sao Paulo' | '12987'| 'Ana Resp'       | 'ana@mail.com'    | '123654'| '(61) 99999-9999'    | '123457'| '369852'      | '06/30'  | '123'| 200    |
	
	
	@apirest
	Esquema do Cenario: Cadastrar PF
		Dado a insercao dos dados de PF <nome_responsavel>, <email_responsavel>, <cpf>, <telefone_responsavel>, <senha>, <numero_cartao>, <validade> e <cvv> 
		Quando chamar o metodo POST de PJ
		Entao o <status> PF sera
	
	Exemplos:
	| nome_responsavel | email_responsavel |cpf      | telefone_responsavel | senha   | numero_cartao | validade | cvv  | status |
	| 'Paulo Resp'     | 'paulo@mail.com'  | '123654'| '(61) 99999-9999'    | '123456'| '369852'      | '06/30'  | '123'| 200    |
	| 'Ana Resp'       | 'ana@mail.com'    | '123654'| '(61) 99999-9999'    | '123457'| '369852'      | '06/30'  | '123'| 200    |
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	