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

Quando informo "100" no campo "Registros por Página"
Então será exibido "Nome da Obra"

Quando clico em "Adicionar Obra"
Então será exibido "Cadastro"
Quando informo os campos: 
|Nome da Obra|Valor|Prazo|
|Nova Obra 2|22222.2|22/02/2013|
Quando clico em "Inserir"
Então será exibido "Nome da Obra"

Quando informo:
|obra|valor|prazo|
|Nova Obra 4|44444.4|24/04/2013|

Quando clico em "Adicionar Obra"
Então será exibido "Cadastro"
Quando informo "obra" no campo "Nome da Obra"
Quando informo "valor" no campo "Valor"
Quando informo "prazo" no campo "Prazo"
Quando clico em "Inserir"
Então será exibido "Nome da Obra"

Quando clico em "Adicionar Obra"
Então será exibido "Cadastro"
Quando informo os campos: stories/obras/nova-obra.table
Quando clico em "Inserir"
Então será exibido "Nome da Obra"

Quando informo:
|obra|valor|prazo|
|Nova Obra 4|55555.5|25/05/2013|

Quando clico em "Adicionar Obra"
Então será exibido "Cadastro"
Quando informo "obra" no campo "Nome da Obra"
Quando informo "valor" no campo "Valor"
Quando informo "prazo" no campo "Prazo"
Quando clico em "Inserir"
Então será exibido "Nome da Obra"

Sair do "Sistema"


Cenário: Excluir Obra

Acesso ao Sistema com usuário "19296496063" e senha "205253"
Dado que estou na tela "Tela Principal"
Então vou para a tela "Lista de Obras"
Quando informo "100" no campo "Registros por Página"
Quando clico em "Excluir" referente a "Nova Obra"
Então será exibido "Remover Obra: Nova Obra ?"
Quando clico em "Sim"
Então será exibido "Nova Obra. Registo removido."

Sair do "Sistema"


Cenário: Excluir Nova Obra 4 valor 55555.5

Acesso ao Sistema com usuário "19296496063" e senha "205253"
Dado que estou na tela "Tela Principal"
Então vou para a tela "Lista de Obras"

Quando informo "100" no campo "Registros por Página"

Quando informo "obra" com valor "Nova Obra 4"
Quando informo "valor" com valor "55555.5"
Quando clico em "Excluir Nova Obra" referente a "obra, valor"

Então será exibido "Remover Obra: Nova Obra 4 ?"
Quando clico em "Sim"
Então será exibido "Nova Obra 4. Registo removido."

Sair do "Sistema"