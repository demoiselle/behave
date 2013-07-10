	Scenario: registrar pedido
		Given que o browser foi aberto
		When for preenchido o nome do usuário com "claudio"
		And for preencido a senha com "123"
		When for acionado o botão "entrada"
		And for acionado o botão "confirmação de entrada"
		Then será exibida a mensagem "login efetuado com sucesso"
		And que entrei na opcao fazer pedido
		When for preenchido um pedido do tipo "venda grande"
		Then será exibida a mensagem "sucesso"