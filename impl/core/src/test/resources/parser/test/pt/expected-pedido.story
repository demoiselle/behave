Funcionalidade: pedido

	Como um: usuário
	Eu quero: alguma coisa
	De modo que: algo funcione
	
	Cenário: registrar pedido
		Dado que o browser foi aberto
		Quando for preenchido o nome do usuário com "claudio"
		E for preencido a senha com "123"
		Quando for acionado o botão "entrada"
		E for acionado o botão "confirmação de entrada"
		Então será exibida a mensagem "login efetuado com sucesso"
		E que entrei na opcao fazer pedido
		Quando for preenchido um pedido do tipo "venda grande"
		Então será exibida a mensagem "sucesso"