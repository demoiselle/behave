Cenário: Verificar Autocomplete 

Dado que vou para a tela "ShowCase Autocomplete"
Quando informo "abc5" no campo "Simple"
Quando informo "def6" no campo "DropDown"
Então clico em "Submit"
Então será exibido no "Label Simple" o valor "abc5"
Então será exibido no "Label DropDown" o valor "def6"