Funcionalidade: Acesso ao Sistema

Narrativa:
Para obter a tela inicial apareceça para mim
Como um usuário
Desejo acessar o sistema

Cenário: Acesso ao Sistema Com Usuário Inválido
	
Dado que vou para a tela "Tela de Login"
Então será exibido no "Rótulo Usuário" o valor "Usuário:"
Então será exibido no "Rótulo Senha" o valor "Senha:"
Quando informo "demoiselleX" no campo "Campo Usuário"
E informo "behave" no campo "Campo Senha"
Quando clico em "Entrar"
Então vou para a tela "Mensagem de Erro"
Então será exibido "Usuário ou senha Inválida"
Então clico em "OK"

Cenário: Acesso ao Sistema Com Senha Inválida
	
Dado que vou para a tela "Tela de Login"
Então será exibido no "Rótulo Usuário" o valor "Usuário:"
Então será exibido no "Rótulo Senha" o valor "Senha:"
Quando informo "demoiselle" no campo "Campo Usuário"
E informo "behaveX" no campo "Campo Senha"
Quando clico em "Entrar"
Então vou para a tela "Mensagem de Erro"
Então será exibido "Usuário ou senha Inválida"
Então clico em "OK"


Cenário: Acesso ao Sistema Usuário e Senha Válida
	
Dado que vou para a tela "Tela de Login"
Então será exibido no "Rótulo Usuário" o valor "Usuário:"
Então será exibido no "Rótulo Senha" o valor "Senha:"
Quando informo "demoiselle" no campo "Campo Usuário"
E informo "behave" no campo "Campo Senha"
Quando clico em "Entrar"
Então vou para a tela "Seja Bem Vindo"
Então será exibido "Teste do Demoiselle Behave Ok!"
Então clico em "OK"

