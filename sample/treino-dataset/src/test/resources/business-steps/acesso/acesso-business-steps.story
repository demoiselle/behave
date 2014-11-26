Cenário: Acesso o sistema com usuário "{usuário}"
	
Dado que vou para a tela "Tela de Login"
E selecionei "{usuário}" do conjunto de dados "usuários"
Quando informo o valor do campo "Usuário"
E informo o valor do campo "Senha"
Então será exibido na "Senha" o valor "Senha"
Quando clico em "Entrar"
Então será exibido "Obras"


Cenário: Saí do "{sistema}"

Dado que estou na tela "Tela Principal"
E "Caixa de Mensagens" não está visível
Quando clico em "Sair"
Então será exibido "Usuário:"
E será exibido "Senha:"