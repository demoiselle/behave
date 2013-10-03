Funcionalidade: PrimeFaces Tree Checkbox

Narrativa:
Como um visitante
Desejo manipular o componente Tree Checkbox do PrimeFaces

Cenário: Expandido e Colapsando nós pelo Label

Dado que vou para a tela "Primefaces Checkbox Tree"
Então será exibido "Tree - Checkbox Selection"
Então expando o nó com label "Node 0" do componente "árvore"
Então expando o nó com label "Node 0.0" do componente "árvore"
Então colapso o nó com label "Node 0.0" do componente "árvore"
Então colapso o nó com label "Node 0" do componente "árvore"

Cenário: Expandido e Colapsando nós pelo Caminho

Dado que vou para a tela "Primefaces Checkbox Tree"
Então será exibido "Tree - Checkbox Selection"
Então expando o nó com caminho "2" do componente "árvore"
Então expando o nó com caminho "2.1" do componente "árvore"
Então colapso o nó com caminho "2.1" do componente "árvore"
Então colapso o nó com caminho "2" do componente "árvore"

Cenário: Alternando o checkbox dos nós pelo Label

Dado que vou para a tela "Primefaces Checkbox Tree"
Então será exibido "Tree - Checkbox Selection"
Então expando o nó com label "Node 0" do componente "árvore"
Então expando o nó com label "Node 0.0" do componente "árvore"
Então alterno o nó com label "Node 0.0" do componente "árvore"
Então expando o nó com label "Node 1" do componente "árvore"
Então alterno o nó com label "Node 1" do componente "árvore"
Então alterno o nó com label "Node 1.0" do componente "árvore"

Cenário: Alternando o checkbox dos nós pelo Caminho

Dado que vou para a tela "Primefaces Checkbox Tree"
Então será exibido "Tree - Checkbox Selection"
Então expando o nó com caminho "1" do componente "árvore"
Então expando o nó com caminho "1.1" do componente "árvore"
Então alterno o nó com caminho "1.1" do componente "árvore"
Então expando o nó com caminho "2" do componente "árvore"
Então alterno o nó com caminho "2" do componente "árvore"
Então alterno o nó com caminho "2.1" do componente "árvore"



