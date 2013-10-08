Funcionalidade: Caixa de Diálogo

Narrativa:
Para obter acesso a funcionalidade das caixas de diálogo
Como um usuário
Desejo manipular as caixas de diálogo

Cenário: Alerta

Dado que vou para a tela "Alertas"
Então será exibido "Demoiselle Behave - Exemplo com Alertas"
Quando clico em "Alerta"
E cancelo a caixa de diálogo
Então será exibido "Demoiselle Behave - Exemplo com Alertas"

Cenário: Prompt

Dado que vou para a tela "Alertas"
Então será exibido "Demoiselle Behave - Exemplo com Alertas"
Quando clico em "Prompt"
Então informo na caixa de diálogo "Demoiselle Behave"
E confirmo a caixa de diálogo
Então será exibido na caixa de diálogo "Seu nome é Demoiselle Behave"
E confirmo a caixa de diálogo
Então será exibido "Demoiselle Behave - Exemplo com Alertas"

Cenário: Confirm

Dado que vou para a tela "Alertas"
Então será exibido "Demoiselle Behave - Exemplo com Alertas"
!-- confirmação
Então clico em "Confirm"
E confirmo a caixa de diálogo
Então será exibido na caixa de diálogo "Você clicou no botão OK,
porque foi retornado o valor: true"
E confirmo a caixa de diálogo
!-- cancelamento
Quando clico em "Confirm"
E cancelo a caixa de diálogo
Então será exibido na caixa de diálogo "Você clicou no botão CANCELAR,
porque foi retornado o valor: false"
E confirmo a caixa de diálogo
Então será exibido "Demoiselle Behave - Exemplo com Alertas"