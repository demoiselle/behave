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
Então vou para a tela "Edição de Obra"
Então será exibido no "Rótulo Nome da Obra" o valor "Nome da Obra:"
Então será exibido no "Rótulo Valor" o valor "Valor:"
Então será exibido no "Rótulo Prazo" o valor "Prazo:"
Quando informo "Nova Obra" no campo "Nome da Obra"
Quando informo "28/05/2013" no campo "Prazo"
Quando informo "99999999.9" no campo "Valor"
Quando clico em "Inserir"
Então vou para a tela "Edição de Obra - Informação"
Quando clico em "OK"

Cenário: Excluir Obra

Dado que vou para a tela "Lista de Obras"
Quando clico na linha da tabela "Tabela de Obras" referente a "Nova Obra"
Quando clico em "Excluir Obra"
Então vou para a tela "Lista de Obras - Confirmação"
Quando clico em "Sim"
Então vou para a tela "Lista de Obras - Confirmação"
Quando clico em "OK"