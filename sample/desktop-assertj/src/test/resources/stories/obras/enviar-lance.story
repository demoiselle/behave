Funcionalidade: Acesso ao Sistema

Narrativa:
Para obter concorrência no sistema de lançe
Como um usuário
Desejo enviar lançes
		 
Cenário: Enviar Lance Vencedor

Dado que vou para a tela "Lista de Obras"
Quando clico na linha da tabela "Tabela de Obras" referente a "Maracanã"
Quando clico em "Enviar Lance"
Dado que vou para a tela "Enviar Lance"
Dado que obtenho "O melhor Valor" do campo "Novo Valor"
E decremento "10" centavos "O melhor Valor"
Dado que obtenho "O melhor Prazo" do campo "Novo Prazo"
E decremento "1" dia "O melhor Prazo"
Quando informo "O melhor Valor" no campo "Novo Valor"
Quando informo "O melhor Prazo" no campo "Novo Prazo"
Quando clico em "Enviar Lance"
Quando vou para a tela "Enviar Lance - Confirmação"
Então clico em "OK"

Cenário: Enviar Lance Perdedor

Dado que vou para a tela "Lista de Obras"
Quando clico na linha da tabela "Tabela de Obras" referente a "Maracanã"
Quando clico em "Enviar Lance"
Dado que vou para a tela "Enviar Lance"
Dado que obtenho "O melhor Valor" do campo "Novo Valor"
Dado que obtenho "O melhor Prazo" do campo "Novo Prazo"
Quando informo "O melhor Valor" no campo "Novo Valor"
Quando informo "O melhor Prazo" no campo "Novo Prazo"
Quando clico em "Enviar Lance"
Quando vou para a tela "Enviar Lance - Erro"
Então clico em "OK"
Dado que vou para a tela "Enviar Lance"
Então clico em "Cancelar"

Sair do "sistema"