Funcionalidade: Acesso ao Sistema

Narrativa:
Para obter a tela inicial apareceça para mim
Como um visitante
Desejo acessar o sistema
	
Cenário: Adicionar Obras

Acesso ao Sistema com usuário "19296496063" e senha "205253"
Dado que estou na tela "Tela Principal"
Então vou para a tela "Lista de Obras"
Quando clico em "Adicionar Obra"
Então será exibido "Cadastro"
Quando informo "Nova Obra" no campo "Nome da Obra"
Quando informo "99999999.9" no campo "Valor"
Quando informo "28/05/2013" no campo "Prazo"
Quando clico em "Inserir"

Então vou para a tela "Lista de Obras"
Quando clico em "Última tela"
Então será exibido "Nome da Obra"

Sair do "Sistema"

Cenário: Excluir Obra

Acesso ao Sistema com usuário "19296496063" e senha "205253"
Dado que estou na tela "Tela Principal"
Então vou para a tela "Lista de Obras"
Quando clico em "Última tela"
E clico em "Botão de Excluir"
Então será exibido "Remover Obra: Nova Obra ?"
Quando clico em "Sim"
Então será exibido "Nova Obra. Registo removido."

Sair do "Sistema"

!-- Obra 1
Cenário: Adicionar Obra 1

Acesso ao Sistema com usuário "19296496063" e senha "205253"

Dado que estou na tela "Tela Principal"
Então vou para a tela "Lista de Obras"
Quando clico em "Adicionar Obra"
Então será exibido "Cadastro"
Quando informo "Nova Obra 1" no campo "Nome da Obra"
Quando informo "99999999.9" no campo "Valor"
Quando informo "28/05/2013" no campo "Prazo"
Quando clico em "Inserir"

Então vou para a tela "Lista de Obras"
Quando clico em "Última tela"
Então será exibido "Nome da Obra"

Cenário: Excluir Obra 1

Dado que vou para a tela "Lista de Obras"
Quando clico em "Última tela"
Quando clico em "Excluir Obra" referente a "Nova Obra 1"
Então será exibido "Remover Obra: Nova Obra 1 ?"
Quando clico em "Sim"
Então será exibido "Nova Obra 1. Registo removido."

Sair do "sistema"
