Funcionalidade: Acesso ao Sistema

Narrativa:
Para obter a tela inicial apareceça para mim
Como um visitante
Desejo acessar o sistema
	
Cenário: Adicionar Obras

Acesso ao Sistema com usuário "19296496063" e senha "205253"

Quando clico em "Menu Principal Obras"
E clico em "Obras"

Dado que vou para a tela "Lista de Obras"

Então clico em "Adicionar Obra"

Então será exibido "Cadastro"
Quando informo "Nova Obra" no campo "Nome da Obra"
Quando informo "99999999.9" no campo "Valor"
Quando informo "28/05/2013" no campo "Prazo"
Quando clico em "Inserir"
Quando informo "100" no campo "Registros por Página"
Então será exibido "Nome da Obra"

Sair do "Sistema"

Cenário: Excluir Obra

Acesso ao Sistema com usuário "19296496063" e senha "205253"
Dado que vou para a tela "Tela Principal"
Então vou para a tela "Lista de Obras"
Quando informo "100" no campo "Registros por Página"
Quando clico em "Excluir" referente a "Nova Obra"
Então será exibido "Remover Obra: Nova Obra ?"
Quando clico em "Sim"
Então será exibido "Nova Obra. Registo removido."

Sair do "Sistema"