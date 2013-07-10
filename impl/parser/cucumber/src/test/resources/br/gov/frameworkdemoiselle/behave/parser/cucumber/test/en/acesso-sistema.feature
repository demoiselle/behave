	Scenario: que estou logado como "{usuário}" no sistema 
		Given que o browser foi aberto
		When for preenchido o nome do usuário com "{usuário}"
		And for preencido a senha com "123"
		When for acionado o botão "entrada"
		And for acionado o botão "confirmação de entrada"
		Then será exibida a mensagem "login efetuado com sucesso"
	Scenario: que foi acionada a sequência de entrada
		When for acionado o botão "entrada"
		And for acionado o botão "confirmação de entrada"