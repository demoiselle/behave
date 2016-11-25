Funcionalidade: Acesso ao Projeto Demoiselle Behave

Narrativa:
Para obter informações sobre o projeto Demoiselle Behave
Como um visistante
Desejo ter acesso a documentação, fórum e demais informações sobre o projeto

Cenário: Site do DBehave
Dado que vou para a tela "dbehave"
Então será exibido "projeto mantido pelo"

Cenário: Lendo dúvidas
Dado que vou para a tela "Github"
Então será exibido "Demoiselle Behave"
Então será exibido "http://dbehave.com"

Quando clico em "Dúvidas e Questões"
Então será exibido "New issue"


Cenário: Procurando documentação
Dado que vou para a tela "Documentação"
Quando clico em "Roteiro Rápido"
Então será exibido "projeto com uso do framework Demoiselle Behave"
Quando clico em "Link Principal"
E clico em "Testes de Regressão"
Então será exibido "a funcionalidade que permite a comparação de layout entre navegadores diferentes"