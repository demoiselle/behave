Funcionalidade: Acesso ao Sistema

Eu quero: acessar o sistema
De modo que: a página inicial apareceça para mim
 
Cenário: Acesso ao Sistema com usuário "{usuário}" e senha "{senha}"
	
Dado que vou para a página "Tela de Login"
Quando informo "{usuário}" no campo "Campo Usuário"
E informo "{senha}" no campo "Campo Senha"
Quando clico em "Entrar"
Então será exibido "Todas as Obras"

Cenário: Acesso ao Sistema com usuário "{usuário}"

Acesso ao Sistema com usuário "{usuário}" e senha "188542"
	
Cenário: Sair do "{sistema}"

Dado que estou na página "Tela Principal"
Quando clico em "Sair"
Então será exibido "Usuário:"
E será exibido "Senha:"

Cenário: Teste com tabela de exemplos

Acesso ao Sistema com usuário "<usuario>" e senha "<senha>"
Sair do "sistema"

Exemplos:
|usuario|senha|
|06762344887|188542|
|19296496063|205253|

Cenário: Teste com reuso e valor default para senha

Acesso ao Sistema com usuário "06762344887"
Sair do "sistema"