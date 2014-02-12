Funcionalidade: Usar Componente FileUpload

!--Como um: visitante
Eu quero: usar o componente FileUpload
De modo que: o arquivo seja adicionado e enviado para o servidor

Cenário: Adicionar arquivo
Dado que vou para a tela "Showcase FileUpload"
Quando informo no "FileUpload" o arquivo "/tmp/logo1.png"
Quando informo no "FileUpload" o arquivo "/tmp/IMG_0417.JPG"
Quando aciono "Upload" no campo "FileUpload"
Então no "FileUpload" o estado do arquivo "logo1.png" será "Done"
Então no "FileUpload" o estado do arquivo "IMG_0417.JPG" será "File size is exceeded"  
Quando aciono "Clear All" no campo "FileUpload"
