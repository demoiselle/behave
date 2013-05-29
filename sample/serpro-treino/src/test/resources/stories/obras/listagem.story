Funcionalidade: Acesso ao Sistema

	Como um: visitante
	Eu quero: acessar o sistema
	De modo que: a página inicial apareceça para mim
	
	Cenário: Listar Obras
	
		Acesso ao Sistema com usuário "19296496063" e senha "205253"
		
		Dado que estou na página "Tela Principal"
		Então vou para a página "Tela de Obras"
		Então será exibido "Arena da Baixada"
		E será exibido "Castelão"
		
		Sair do "Sistema"