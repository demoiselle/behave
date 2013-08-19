Funcionalidade: Operar a Calculadora

Narrativa:
Para obter as operações básicas da calculadora
Como um usuário qualquer
Desejo resolver problemas matemáticos de forma mais rápida

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
Quando multiploco "2"
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
Quando multiploco "5"
Quando subtraio "1"
Então seu valor será "24"

Cenário: Soma com massa

Quando inicio a Calculadora
Então realizo várias somas da <lista>

Exemplos:
|lista|
|valor01 => "4.0", valor02 => "6.0", resultado => "10.0"|
|valor01 => "5.0", valor02 => "9.0", resultado => "14.0"|
|valor01 => "6.0", valor02 => "10.0", resultado => "16.0"|
|valor01 => "7.0", valor02 => "11.0", resultado => "18.0"|
|valor01 => "8.0", valor02 => "12.0", resultado => "20.0"|

