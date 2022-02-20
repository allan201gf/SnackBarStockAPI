# BlogAPI

Projeto de uma API para gerenciamento de estoque e produtos de uma lanchonete<br/>

Para facilitar os testes da API, ela foi desenvolvida utilizando o banco de dados H2, 
um banco em memória que não há necessidade de executar um banco SQL fora da aplicação. 
Em contrapartida, toda vez que o sistema é reiniciado, todos os dados são perdidos.
<br>
A Qualquer momento o banco pode ser alterado refaturando o arquivo abaixo.
> resources/application.properties

A documentação dos endpoints é feita via Swagger no link abaixo e algumas informações podem ser consultadas neste mesmo arquivo.

Para acessar os endpoints que necessitam de autenticação é necessário incluir o token no swagger.

> http://localhost:8080/swagger-ui.html

## Versão e IDE de desenvolvimento
O projeto foi desenvolvido utilizando a IDE IntelliJ utilizando o Java em sua versão 11.

## Build do Projeto
Para rodar o projeto não é necessário configurações extras, apenas clonar o projeto e fazer o build (requer java +11).<br>

> resources/application.properties

## Features

### Registro e Login de administrador
É necessário estar logado na api para pode cadastrar ingredientes e produtos
#### Cadastro do administrador
Para cadastrar um usuário devemos bater no endpoint:

~~~
POST /api/user/v1
~~~
Dados no body:
~~~
{
    "email": "email@email.com",
    "password": "senhadousuário"
}
~~~

#### Login do administrador
~~~
POST /api/user/v1/login
~~~
Dados no body:
~~~
{
    "email": "email@email.com",
    "password": "senhateste"
}
~~~
Após efetuar o login o sistema retornará o Bearer Token que deve ser enviado no header em todas as requisições que requerem o usuário logado.

### Dados do usuário logado
Este endpoint retorna os dados do usuário que está logado.
> Para utilizar este endpoint o usuário deve estar logado
~~~
GET  /api/user/v1/getloggeduser
~~~

### Deletar usuário logado
Utilize este endpoint para deletar o usuário que está logado.
> Para utilizar este endpoint o usuário deve estar logado
~~~
DELETE  /api/user/v1/delete
~~~

### Ingredientes
#### Criação de ingrediente
> Para utilizar este endpoint o usuário deve estar logado
~~~
POST  /api/ingredient/v1
~~~
Dados no body:
~~~
{
  "name": "Cebola",
  "quantity": 9,
  "unit": "UNI",
  "value": 2
}
~~~
#### Listagem dos ingredientes
~~~
GET  /api/ingredient/v1
~~~

### Produtos para venda

#### Criação de produto

> Para utilizar este endpoint o usuário deve estar logado
~~~
POST  /api/product/v1
~~~
Dados no body:
~~~
{
  "name": "string",
  "quantityIngredients": [
    {
      "ingredient": "string",
      "quantity": 0
    }
  ],
  "value": 0
}
~~~

#### Listagem de produtos
Este endpoint retorna todos os produtos cadastrados na api.<br>
~~~
GET  /api/product/v1/all-products
~~~

#### Listagem de produtos e seus custos de produção
Esse endpoint retorna o nome de cada produto contendo o seu custo de produção<br>
O custo de produção é calculado a partir da somatória das quantidades de ingredientes e seus custos que foram fornecidos ao cadastra-lo.
~~~
GET  /api/product/v1/all-products
~~~

#### Verificação de disponibilidade
Utilize este endpoint para verificar se determinado produto pode ou não ser produzido com base em seu estoque.<br>
Retorno 200 para Ok e 400 caso não seja possível produzi-lo.
~~~
GET  api/product/v1/verify-stock-product?productForVerify=Nome produto
~~~

## 🛠️ Desenvolvido com

* [IntelliJ](http://www.dropwizard.io/1.0.2/docs/) - A IDE do ❤️
* [Maven](https://maven.apache.org/) - Gerenciador de dependências
* [SpringBoot](https://start.spring.io/) - Framework para aplicações web
* [H2 DataBase](https://www.h2database.com/html/main.html) - Banco de dados em memória
* [Lombok](https://projectlombok.org/) - Facilitar a criação de construtores
* [Swagger](https://swagger.io/tools/open-source/open-source-integrations/) - Listagem endpoints da API
* [Spring Security](https://spring.io/projects/spring-security) - Autenticação de usuários
* [Token JWT](https://github.com/jwtk/jjwt) - Criação do token de autenticação de usuários

---
⌨️ com ❤️ por [Allan Garcia Ferreira](https://github.com/allan201gf) 