Funcionalidade: Acesso ao Sistema

Como um: visitante
Eu quero: acessar o sistema
De modo que: a página inicial apareceça para mim

Cenário: Acesso ao Sistema 1

Dado que vou para a página "Tela de Login"
Quando informo "19296496063" no campo "Campo Usuário"
E informo "205253" no campo "Campo Senha"
Quando clico em "Botão Enviar"
Então será exibido "Seja bem vindo"


Cenário: Logout do Sistema 1

Dado que vou para a página "Tela Princial"
Quando clico em "Sair" 
Então será exibido "Usuário:"
E será exibido "Senha:"
