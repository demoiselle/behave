Funcionalidade: Testes

	Como um: analista de resquisitos
	Eu quero: aprender a usar os componentes de tela
	De modo que: eu possa gerar novas histórias

	Cenário: Teste de Componentes

		Acesso ao Sistema com usuário "06762344887" e senha "188542"
	
		Dado que estou na página "Tela Principal"
		Quando vou para a página "Tela de Componentes"
	
		Seleção de Valores de Componentes com "Opção 1" e "Opção 1"
		Seleção de Valores de Componentes com "Opção 1" e "Opção 3"
		
		Quando seleciono a opção "Opção 1"
		Então será exibido na "Opção Selecionada no Radio" o valor "[1]"
		
		Quando seleciono a opção "Opção 2"
		Então será exibido na "Opção Selecionada no Radio" o valor "[2]"
		
		Quando seleciono a opção "Opção 3"
		Então será exibido na "Opção Selecionada no Radio" o valor "[3]"
		
		Quando seleciono a opção "Valor 1"
		Então será exibido "Macardo [1]"
		E seleciono a opção "Valor 1"
		
		Quando seleciono a opção "Valor 2"
		Então será exibido "Macardo [2]"
		E seleciono a opção "Valor 2"
		
		Sair do "{sistema}"

	Cenário: Seleção de Valores de Componentes com "{valor1}" e "{valor2}"

		Quando informo "{valor1}" no campo "Seleção de Opção 1"
		E informo "{valor2}" no campo "Seleção de Opção 2"
		Quando clico em "Botão Exibir"
		Então será exibido na "Opção Selecionada" o valor "{valor2}"
		E clico em "Botão Fechar"