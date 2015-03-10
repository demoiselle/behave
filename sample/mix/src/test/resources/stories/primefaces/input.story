Funcionalidade: PrimeFaces Inputs

Cenário: Preenchendo o select one menu

Dado que vou para a tela "Primefaces Select One Menu"
Então será exibido "SelectOneMenu"
Então informo "PS4" no campo "Select"
Quando clico em "Submit"
Então será exibido na "Valor Basic" o valor "PS4"


Cenário: Preenchendo o select checkbox menu

Dado que vou para a tela "Primefaces Select Checkbox Menu"
Quando seleciono a opção de valor "Paris,London" no campo "Select"
E clico em "Fechar"
Quando seleciono a opção de valor "Berlin," no campo "Select"
E clico em "Fechar"
Quando clico em "Submit"
Então será exibido na "Lista de Países" o valor "Paris"