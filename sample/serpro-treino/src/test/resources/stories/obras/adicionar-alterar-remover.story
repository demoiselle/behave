Funcionalidade: Acesso ao Sistema

Como um: visitante
Eu quero: acessar o sistema
De modo que: a página inicial apareceça para mim

Cenário: Listar Obras

Acesso ao Sistema com usuário "19296496063" e senha "205253"

Dado que estou na página "Tela Principal"
Então vou para a página "Tela de Obras"
Quando clico em "Adicionar Obra"
Então será exibido "Cadastro"
Quando informo "Nova Obra" no campo "Nome da Obra"
Quando informo "99.999.999,01" no campo "Valor"
Quando informo "28/05/2013" no campo "Prazo"
Quando clico em "Inserir"

Então vou para a página "Tela de Obras"
Quando clico em "Última Página"
Então será exibido "Nome da Obra"

Sair do "Sistema"

Cenário: Excluir Obra

Acesso ao Sistema com usuário "19296496063" e senha "205253"

Dado que estou na página "Tela Principal"
Então vou para a página "Tela de Obras"
Quando clico em "Última Página"
E clico em "Botão de Excluir"
Então será exibido "Remover Obra: Nova Obra ?"
Quando clico em "Sim"
Então será exibido "Nova Obra. Registo removido."

Sair do "Sistema"