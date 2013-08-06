Cenário: Acesso ao Sistema com usuário "{usuário}" e senha "{senha}"
	
Dado que vou para a tela "Tela de Login"
Então será exibido no "Rótulo Usuário" o valor "Usuário:"
Então será exibido no "Rótulo Senha" o valor "Senha:"
Quando informo "{usuário}" no campo "Campo Usuário"
E informo "{senha}" no campo "Campo Senha"
Quando clico em "Entrar"
Então vou para a tela "Tela Principal"

Cenário: Sair do "{sistema}"

Dado que estou na tela "Tela Principal"
Quando clico em "Menu Principal Sair"
E clico em "Sair"
Então será exibido "Usuário:"
E será exibido "Senha:"

Cenário: Acesso ao Sistema com usuário "{usuário}"

Acesso ao Sistema com usuário "{usuário}" e senha "188542"