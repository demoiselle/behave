Funcionalidade: Acesso ao Sistema

Como um: visitante
Eu quero: acessar o sistema
De modo que: a página inicial apareceça para mim

Cenário: Acesso ao Sistema com usuário "{usuário}" e senha "{senha}"

Dado que vou para a página "Tela de Login"
Quando informo "{usuário}" no campo "Campo Usuário"
E informo "{senha}" no campo "Campo Senha"
Quando clico em "Botão Enviar"
Então será exibido "Seja bem vindo"

Cenário: Acesso ao Sistema 

Acesso ao Sistema com usuário "19296496063" e senha "205253"

Cenário: Logout do Sistema

Dado que vou para a página "Tela Princial"
Quando clico em "Sair" 
Então será exibido "Usuário:"
E será exibido "Senha:"


