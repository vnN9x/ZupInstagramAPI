# ZupInstagramAPI
API do Instagram criado para o processo seletivo Zup

Este arquivo servirá como diário de bordo/Manual de uso para o projeto, portanto, leia com atenção.

-- INDEX --

  1 - Avisos importantes, ajustes que precisam ser feitos manualmente antes do uso e ferramentas utilizadas. 
  2 - Resumo da utilização dos packages e classes contidas dentro deles. 
  3 - Demonstração do uso das páginas e requisições. 
  4 - Considerações finais.

1.
Antes de rodar o código é preciso que a máquina utilizada tenha alguns programas já instalados, como, por exemplo:
- Uma IDE que suporte Java e frameworks (Para fins de teste foram utilizadas: Spring Tool Suite 4 e Eclipse)
- A versão mais recente do Java instalada na máquina
- Maven
- MySQL instalado e pré-configurado

Agora, para que as entidades de dado sejam devidamente criadas, precisamos fazer algumas alterações.
vá até o arquivo "application.properties" na sua IDE, neste arquivo, deveremos executar algumas alterações.
na linha "spring.datasource.username =" o valor contido é "root", caso seu MySQL esteja registrado com outro nome de usuário, informe-o nesta linha.
na linha "spring.datasource.password =" o valor contido é " "(vázio), pois o meu usuário não contém uma senha, caso o seu contenha, informe-a nesta linha.

para que o programa funcione, é crucial que o nome do banco de dados seja "register", e para isso, vá até o cmd e digite os seguintes comandos:
"mysql -u "nomeDeUsuario" -p"
após deverá aparecer uma linha chamada "password", onde você deve inserir sua senha.
assim que estiver logado, escreva o comando "create database register;" lembrando que o nome da database tem que ser "register", caso contrário, o código não funcionará

pronto, se todas as alterações e procedimentos citados acima foram feitos corretamente, agora tudo o que você precisa fazer para iniciar a aplicação é executar a classe "InstagramApiApplication", localizada dentro do pacote "com".

2.
2.1 o pacote "com":
contém apenas a classe "InstagramApiApplication" que, como já citada anteriormente, é responsável pela execução do programa(onde se situa o main)

2.2 o pacote "com.model":
contém as classes responsáveis por criar as entidades no banco de dados, relacionalas e validar os dados inseridos.
2.2.1 "Img" cria a entidade "img" e a relaciona com a entidade "user"
2.2.2 "Seguidores" cria a entidade "seguidores" e a relaciona com a entidade "user"
2.2.3 "Seguindo" cria a entidade "seguindo" e a relaciona com a entidade "user"
2.2.4 "User" cria a entidade "user" e a relaciona com as entidades "img", "seguidores" e seguindo
2.2.5 "UserDetailRequest" trata dos parametros de validação de "User"

2.3 o pacote "com.repository":
contém as interfaces de repositório para cada uma das entidades do banco de dados.

2.4 o pacote "com.web":
comtém o controller do projeto, que recebe e redireciona as requisições web.
2.4.1 "ProfileController" trata todas as requisições disponíveis no programa e mapeia as urls.

3.
