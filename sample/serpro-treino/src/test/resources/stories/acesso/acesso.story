Funcionalidade: Acesso ao Sistema

Como um: visitante
Eu quero: acessar o sistema
De modo que: a página inicial apareceça para mim

Cenário: Acesso ao Sistema com usuário "{usuário}" e senha "{senha}"

Dado que vou para a página "Tela de Login"
Quando informo "{usuário}" no campo "Campo Usuário"
E informo "{senha}" no campo "Campo Senha"
Quando clico em "Entrar"
Então será exibido "Seja bem vindo"

Cenário: Sair do "{sistema}"

Dado que vou para a página "Tela Princial"
Quando clico em "Sair" 
Então será exibido "Usuário:"
E será exibido "Senha:"

Cenário: Teste

Acesso ao Sistema com usuário "19296496063" e senha "205253"
Sair do "Sistema"

Cenário: Usuário inválido

Dado que vou para a página "Tela de Login"
Quando informo "1234567890" no campo "Campo Usuário"
E informo "123456" no campo "Campo Senha"
Quando clico em "Entrar"
Então será exibido "Usuario ou senha invalida"