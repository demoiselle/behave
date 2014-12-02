Cenário: Verificar a utilização do componente Autocomplete 

Dado que vou para a tela "ShowCase Autocomplete Component"
Quando informo "abc" e seleciono "abc5" no campo "Simple"
E informo "def" e seleciono "def6" no campo "DropDown"
Então clico em "Submit"
Então será exibido no "Label Simple" o valor "abc5"
E será exibido no "Label DropDown" o valor "def6"