Funcionalidade: Usar Componente FileUpload

!-- Como um: visitante
Eu quero: usar o componente FileUpload
De modo que: o arquivo seja adicionado e enviado para o servidor

Cenário: Adicionar arquivo richfaces4
Dado que vou para a tela "Showcase FileUpload"
Quando informo no "FileUpload" o arquivo "/images-upload/testes-1.jpg"
Quando informo no "FileUpload" o arquivo "/images-upload/testes-2.jpg"
Quando aciono "Upload" no campo "FileUpload"
Então no "FileUpload" o estado do arquivo "testes-1.jpg" será "Done"
Então no "FileUpload" o estado do arquivo "testes-2.jpg" será "File size is exceeded"
Quando aciono "Clear All" no campo "FileUpload"