# ZupInstagramAPI
API do Instagram criado para o processo seletivo Zup

Este arquivo servirá como diário de bordo/manual de uso para o projeto, portanto, leia com atenção.

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
- Postman

Agora, para que as entidades de dado sejam devidamente criadas, precisamos fazer algumas alterações.
vá até o arquivo "application.properties" na sua IDE, neste arquivo, deveremos executar algumas alterações.
na linha "spring.datasource.username =" o valor contido é "root", caso seu MySQL esteja registrado com outro nome de usuário, informe-o nesta linha.
na linha "spring.datasource.password =" o valor contido é " "(vázio), pois o meu usuário não utiliza uma senha, caso o seu contenha, informe-a nesta linha.

para que o programa funcione, é crucial que o nome do banco de dados seja "register", e para isso, vá até o cmd e digite os seguintes comandos:
"mysql -u (nomeDeUsuario) -p"
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
3.1 "/perfil" cria perfis e lista todos os já existentes.
3.1.1 POST - aqui é possível adicionar um novo usuário em formato de json, com a requisição post, exemplo de json:
{
    "perfilImg": "",
	"nomeCompleto":"Vinícius Maximiliano",
	"userName":"vnN9x",
	"site":"",
	"biografia":"",
	"email":"vinnemaax@gmail.com",
	"telefone":"983241648",
	"genero":"masculino",
    "senha": "12345"
}
os únicos campos obrigatórios são "email", "nomeCompleto", "userName" e "senha", os outros podem ter um valor "em branco" ou null.
as keys "userName" e "email" são campos únicos, o que significa que não é possível criar dois usuários iguais nesse quesito.
3.1.2 GET - aqui é possível listar todos os perfis já criados e suas respectivas informações, os dados serão exibidos em formato JSON

3.2 "/perfil/(id)" o ID refere-se ao id de um perfil já criado. Edita, deleta, adiciona postagens e exibe as informações de um único perfil.
3.2.1 GET - exibi todas as informações do perfil cujo id foi específicado no caminho.
3.2.2 POST - cria uma nova postagem utilizando o perfil cujo id foi específicado no caminho, exemplo de json para nova postagem:
{
    "img": "c://documentos/fotos/praia.jpeg",
    "descricao": "sol!!!"
}
3.2.3 PUT - funciona de forma bem semelhante ao POST citado na sessão 3.1.1, a diferença é que, ao invés de criar um novo usuário, você edita as informações
contidas em um usuário já existente, podendo editar todas, algumas ou nenhuma informação. Lembrando que, os campos obrigatórios ainda são os mesmos.
3.2.4 DELETE - como sugere o nome, esta requisição exclui o perfil selecionado.

3.3 "/perfil/feed/(id)" GET - o ID refere-se ao id de um perfil já criado. Exibe todos as postagens feitas  pelo perfil.

3.4 "/perfil/seguir/(id)" POST - o ID refere-se ao id de um perfil já criado. Acessa o perfil específicado no caminho e segue um perfil especificando o seu ID
 exemplo de JSON:
{
    "seguindoId":1
}

3.5 "/perfil/seguindo/(id)" GET - o ID refere-se ao id de um perfil já criado. Acessa o perfil específicado no caminho e exibe o ID de todos o perfis que ele está seguindo
em forma de json, a chave "requestId" não deve ser interpretada, ela é utilizada apenas para fins de banco de dados.

3.6 "/perfil/seguidores/(id)" GET - o ID refere-se ao id de um perfil já criado. Acessa o perfil específicado no caminho e exibe o ID de todos o perfis que o estão seguindo
em forma de json, a chave "requestId" não deve ser interpretada, ela é utilizada apenas para fins de banco de dados.

4.
Este código está passível a erros lógicos. Quando o desafio foi me apresentado eu sabia pouco; quase nada sobre Spring, mesmo assim aprendi muito
com o framework em pouquissímos dias, isso me deixou animado para aprender mais e trabalhar com essa técnologia, se possível.
Espero que a API esteja dentro das espectativas de vocês, investi muito tempo e esforço neste projeto e fiquei contente com o resultado. Grato pela oportunidade :)



Vinícius Maximiliano - vinnemaax@gmail.com
