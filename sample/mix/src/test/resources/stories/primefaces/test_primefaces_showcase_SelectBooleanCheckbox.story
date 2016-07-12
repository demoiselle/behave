Funcionalidade: PrimeFaces CheckBox

Cenário: Garantir que o checkbox está marcado

Dado que vou para a tela "Showcase CheckBox"
Então será exibido "SelectBooleanCheckbox"
!-- Ao chegar na tela, o check está por padrão DESmarcado
Quando garanto que o campo "Primefaces Checkbox Basic" está desmarcado
Então o campo "Primefaces Checkbox Basic" está desmarcado

!-- Marco o check e verifico se a instrução desmarca o campo
Quando seleciono a opção "Primefaces Checkbox Basic"
E garanto que o campo "Primefaces Checkbox Basic" está desmarcado
Então o campo "Primefaces Checkbox Basic" está desmarcado

!-- Sabendo que desmarquei, verifico se consigo garantir que o campo ficará marcado
Quando garanto que o campo "Primefaces Checkbox Basic" está marcado
Então o campo "Primefaces Checkbox Basic" está marcado

!-- Desmarco o campo e testo mais uma vez
Quando seleciono a opção "Primefaces Checkbox Basic"
E garanto que o campo "Primefaces Checkbox Basic" está marcado
Então o campo "Primefaces Checkbox Basic" está marcado