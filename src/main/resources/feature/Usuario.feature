Feature: Gerenciar Usuario
  
  a) Como administrador do sistema, eu quero poder cadastrar outros usuarios por uma interface, para manter os registros
  b) Como administrador do sistema, eu quero poder alterar os cadastros por uma interface, para mante-los sempre atualizados
  c) Como administrador do sistema, eu quero poder buscar cada cadastro por uma interface, para obter informações
  d) Como administrador do sistema, eu quero poder excluir os cadastros por uma interface, para quando o registro não for mais util

  Background: 
    Given que acesso o sistema

  Scenario: Criar um usuario
    When crio um usuario no sistema
    Then o usuario e cadastrado no sistema cucumber

  Scenario: Buscar todos
    Then todos os usuario sao apresentados

  Scenario: Buscar usuario pelo ID
    When buscar o usuario pelo id
    Then suas informacoes serao apresentadas

  Scenario: Excluir usuario pelo ID
    When buscar o usuario pelo id
    Then o cadastro sera excluido
