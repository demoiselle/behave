Cenário: Acesso ao Sistema com usuário "{usuário}" e senha "{senha}"
	
Dado que vou para a tela "Tela de Login"
Então será exibido no "Rótulo Usuário" o valor "Usuário:"
Então será exibido no "Rótulo Senha" o valor "Senha:"
Quando informo "{usuário}" no campo "Campo Usuário"
E informo "{senha}" no campo "Campo Senha"
Quando clico em "Entrar"
Então vou para a tela "Painel Principal"

Cenário: Sair do "{sistema}"

Dado que vou para a tela "Painel Principal"
Quando clico em "Menu Principal Sair"
!-- Então clico em "Sair"