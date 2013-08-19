Funcionalidade: Operar Calculadora

Eu quero: utilizar as funcionalidasde básicas da calculadora
De modo que: a calculadora execute as operações básicas

Cenário: Limpar Calculadora no Início

Quando inicio a Calculadora
Então seu valor será "0"


Cenário: Limpar Calculadora depois de uma operação

Quando inicio a Calculadora
E adiciono "5"
Então seu valor será "5"
Quando limpo
Então seu valor será "0"


Cenário: Somar

Quando inicio a Calculadora
Quando adiciono "5"
Quando adiciono "7"
Então seu valor será "12"

Cenário: Subtracao

Quando inicio a Calculadora
Quando adiciono "10"
Quando subtraio "2"
Então seu valor será "8"

Cenário: Multiplicação

Quando inicio a Calculadora
Quando adiciono "10"
Quando multiplico "2"
Então seu valor será "20"

Cenário: Divisão

Quando inicio a Calculadora
Quando adiciono "10"
Quando divido "2"
Então seu valor será "5"

Cenário: Quatro operações

Quando inicio a Calculadora
Quando adiciono "10"
Quando divido "2"
Quando multiplico "5"
Quando subtraio "1"
Então seu valor será "24"

