Funcionalidade: Mascara

Narrativa:
Para obter o funcionalidade de mascaramento
Como um visitante
Desejo informar todos os campos do formulario com mascara

Cenário: Informar dados com máscara

Dado que vou para a tela "Formulário com Máscaras do Primefaces"
Então será exibido "PrimeFaces"

Quando informo "23/02/2015" no campo "Data"
Quando informo "(012) 345-6789" no campo "Telefone"
Quando informo "(012) 345-6789 x87654" no campo "Fax"
Quando informo "12-3456789" no campo "Id"
Quando informo "123-45-6789" no campo "SSN"
Quando informo "ab-123-c456" no campo "Chave"

E clico em "Submit"

Então será exibido "Values"
Então será exibido "23/02/2015"
Então será exibido "(012) 345-6789"
Então será exibido "(012) 345-6789 x87654"
Então será exibido "12-3456789"
Então será exibido "123-45-6789"
E será exibido "ab-123-c456"