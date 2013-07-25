Cenário: Acesso ao Sistema com usuário "{usuário}" e senha "{senha}"
	
Dado que vou para a página "Tela de Login"
Quando informo "{usuário}" no campo "Campo Usuário"
E informo "{senha}" no campo "Campo Senha"
Quando clico em "Entrar"
Então será exibido "Todas as Obras"

Cenário: Sair do "{sistema}"

Dado que estou na página "Tela Principal"
Quando clico em "Sair"
Então será exibido "Usuário:"
E será exibido "Senha:"

Cenário: Acesso ao Sistema com usuário "{usuário}"

Acesso ao Sistema com usuário "{usuário}" e senha "188542"