	Cenário: que estou logado como "{usuário}" no sistema
		Dado que o browser foi aberto
		Quando for preenchido o nome do usuário com "{usuário}"
		E for preencido a senha com "123"
		Quando for acionado o botão "entrada"
		E for acionado o botão "confirmação de entrada"
		Então será exibida a mensagem "login efetuado com sucesso"
	Cenário: que foi acionada a sequência de entrada
		Quando for acionado o botão "entrada"
		E for acionado o botão "confirmação de entrada"