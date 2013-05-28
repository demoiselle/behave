Funcionalidade: Testes

Cenário: Teste de Componentes

Acesso ao Sistema com usuário "06762344887" e senha "188542"

Dado que estou na página "Tela Principal"
Quando vou para a página "Tela de Componentes"

Seleção de Valores de Componentes com "Opção 1" e "Opção 1"
Seleção de Valores de Componentes com "Opção 1" e "Opção 2"
Seleção de Valores de Componentes com "Opção 1" e "Opção 3"

Seleção de Valores de Componentes com "Opção 3" e "Opção 1"
Seleção de Valores de Componentes com "Opção 3" e "Opção 2"
Seleção de Valores de Componentes com "Opção 3" e "Opção 3"

Logout do Sistema "reuso"

Cenário: Seleção de Valores de Componentes com "{valor1}" e "{valor2}"

Quando informo "{valor1}" no campo "Seleção de Opção 1"
E informo "{valor2}" no campo "Seleção de Opção 2"
Quando clico em "Botão Exibir"
Então será exibido na "Opção Selecionada" o valor "{valor2}"
E clico em "Botão Fechar"