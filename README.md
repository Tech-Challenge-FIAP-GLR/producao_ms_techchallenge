# MICRO SERVIÇO DE PRODUÇÃO
## Sobre o serviço:
Serviço responsável por cuidar da parte de gerenciamento e produção do fast food. O serviço é responsável por registrar usuários, produtos, categorias e atualizar status dos pedidos. 
* As arquiteturas utilziadas foram Clean e Hexagonal.
* O banco de dados é o MongoDB, banco de dados não relacional.

## Pré-Requisitos para chamada local
1. Acessar a pasta do projeto via CMD.
2. Rodar o comando "docker-compose up"
3. Acessar as URLs para chamadas indicadas abaixo.

## Passo a passo para inicializar aplicação
1. Clone este repositório.
2. Dentro do repósitorio food_techchallenge, importe o projeto na sua IDE de preferência.
3. Rode os comandos abaixo:
   

## Swagger
http://localhost:8080/swagger-ui/index.html


# Services
## Salva Usuário
**Endpoint:** */api/food_techchallenge/users*<br />
**Método:** *POST*
<br />
**Description:** Método responsável por salvar usuários. 
<br />
**Request Example:** 
<br />
```json
{
    "nome":"Gabriel Freitas",
    "cpf": "222.233.123-19",
    "email": "gf@gmail.com"
}
```
**Response Example:** 
```json
{
    "id": 9,
    "nome": "Gabriel Freitas",
    "cpf": "222.233.123-19",
    "email": "gf@gmail.com"
}
```
## Busca Usuário (ID)
**Endpoint:** */api/food_techchallenge/users/${id}*<br />
**Método:** *GET*
<br />
**Description:** Método responsável por buscar usuários pelo ID do banco de dados. 
<br />
**Request Example:** 
<br />
```
Path parameter
```
**Response Example:** 
```json
{
    "id": 9,
    "nome": "Gabriel Freitas",
    "cpf": "222.233.123-19",
    "email": "gf@gmail.com"
}
```
## Busca Usuário (por CPF)
**Endpoint:** */api/food_techchallenge/users/cpf/${cpf}*<br />
**Método:** *GET*
<br />
**Description:** Método responsável por buscar usuários pelo CPF. 
<br />
**Request Example:** 
<br />
```
Path parameter
```
**Response Example:** 
```json
{
    "id": 11,
    "nome": "Gabriel Freitas",
    "cpf": "777.233.123-19",
    "email": "gf@gmail.com"
}
```
## Deleta Usuário (ID)
**Endpoint:** */api/food_techchallenge/users/${id}*<br />
**Método:** *DELETE*
<br />
**Description:** Método responsável por deletar usuários pelo ID do banco de dados. 
<br />
**Request Example:** 
<br />
```
Path parameter
```
**Response Example:** 
```
Usuário 6 deletado com sucesso.
```
## Salva Produto
**Endpoint:** */api/food_techchallenge/produtos*<br />
**Método:** *POST*
<br />
**Description:** Método responsável por salvar produtos. 
<br />
**Request Example:** 
<br />
```json
{
    "nome": "X-Salada",
    "descricao": "Hamburguer com alface e tomate",
    "preco": 14.50,
    "categoriaId": 1
}
```
**Response Example:** 
```json
{
    "id": 1,
    "nome": "X-Salada",
    "descricao": "Hamburguer com alface e tomate",
    "preco": 14.5,
    "categoria": {
        "id": 1,
        "descricao": "Lanche"
    }
}
```
## Altera Produto
**Endpoint:** */api/food_techchallenge/produtos/${id}*<br />
**Método:** *PUT*
<br />
**Description:** Método responsável por alterar produtos. 
<br />
**Request Example:** 
<br />
```json
{
    "nome": "Lanche Final Editado",
    "descricao": "Teste de edição final",
    "preco": 14.50,
    "categoriaId": 1
}
```
**Response Example:** 
```json
{
    "id": 1,
    "nome": "Lanche Final Editado",
    "descricao": "Teste de edição final",
    "preco": 14.5,
    "categoria": {
        "id": 1,
        "descricao": "Lanche"
    }
}
```
## Busca Produto (ID)
**Endpoint:** */api/food_techchallenge/produtos/${id}*<br />
**Método:** *GET*
<br />
**Description:** Método responsável por buscar produtos pelo ID do banco de dados. 
<br />
**Request Example:** 
<br />
```
Path parameter
```
**Response Example:** 
```json
{
    "id": 1,
    "nome": "Lanche Final Editado",
    "descricao": "Teste de edição final",
    "preco": 14.5,
    "categoria": {
        "id": 1,
        "descricao": "Lanche"
    }
}
```
## Busca Produto (por categoria)
**Endpoint:** */api/food_techchallenge/produtos/categoria/Lanche*<br />
**Método:** *GET*
<br />
**Description:** Método responsável por buscar produtos pela sua categoria, sendo elas: Lanche; Acompanhamento; Bebida; Sobremesa.
<br />
**Request Example:** 
<br />
```
Path parameter
```
**Response Example:** 
```json
{
    "id": 1,
    "nome": "Lanche Final Editado",
    "descricao": "Teste de edição final",
    "preco": 14.5,
    "categoria": {
        "id": 1,
        "descricao": "Lanche"
    }
}
```
## Deleta Produto (ID)
**Endpoint:** */api/food_techchallenge/produtos/${id}*<br />
**Método:** *DELETE* <br />
**Description:** Método responsável por deletar produto pelo ID do banco de dados. 
<br />
**Request Example:** 
<br />
```
Path parameter
```
**Response Example:** 
```
200 ok
```

## Altera Status Pedido (ID)
**Endpoint:** */api/food_techchallenge/pedidos/${id}*<br />
**Método:** *PUT*<br />
**Description:** Método responsável por avançar o status do pedido desejado. 
<br />
**Request Example:** 
<br />
```json
{
    "orderStatus": "Pronto"
}
```
**Response Example:** 
```
Pedido atualizado.
```

