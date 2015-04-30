Cenário: Acesso ao Sistema com usuário "{usuário}" e senha "{senha}"
	
Dado que vou para a tela "Tela de Login"
Então não será exibido "Login"
Então será exibido "Autenticação"
Quando informo "{usuário}" no campo "Campo Usuário"
E informo "{senha}" no campo "Campo Senha"
Então será exibido na "Campo Senha" o valor "{senha}"
Quando não informo valor para o campo "Campo Usuário"
Então não será exibido no "Campo Usuário" o valor "{usuário}"
Quando não informo valor para o campo "Campo Senha"
Então não será exibido na "Campo Senha" o valor "{senha}"
Então será exibido na "Campo Senha" o valor ""
Quando informo "{usuário}" no campo "Campo Usuário"
E informo "{senha}" no campo "Campo Senha"
Então será exibido na "Campo Senha" o valor "{senha}"
Quando clico em "Entrar"
Então será exibido "Obras"

Cenário: Sair do "{sistema}"

Dado que estou na tela "Tela Principal"
E "Caixa de Mensagens" não está visível
Quando clico em "Sair"
Então será exibido "Usuário:"
E será exibido "Senha:"

Cenário: Acesso ao Sistema com usuário "{usuário}"

Acesso ao Sistema com usuário "{usuário}" e senha "188542"