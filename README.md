# Checkpoint 2 - Sistema de Brinquedos

Projeto desenvolvido para a disciplina de Programação Spring Boot com Persistência.

## Integrantes

- Nome: Gustavo Ribeiro - RM 564995
- Nome: Enzo Xavier Coelho - RM
- Nome: Matheus Gianolli - RM
- Nome: Larissa Magalhães - RM
- Nome: Julia - RM

## Descrição do Projeto

Sistema CRUD para gerenciamento de brinquedos de crianças até 14 anos.

O projeto utiliza Spring Boot com Maven em Java e banco de dados Oracle. Os endpoints serão testados via Postman ou Insomnia utilizando o endereço `localhost` na porta `8080`.

## Tecnologias Utilizadas

- Java 17
- Spring Boot
- Maven
- Spring Web
- Spring Data JPA
- Oracle Driver
- Lombok
- Validation
- Oracle SQL Developer
- Postman ou Insomnia

## Estrutura do Projeto

```text
src/main/java/br/com/fiap/checkpoint2
├── Checkpoint2Application.java
└── model
    └── Brinquedo.java
```

## Etapa 1 - Projeto Base e Classe Brinquedo

Nesta etapa foi criada a estrutura inicial do projeto Spring Boot e a classe `Brinquedo`.

A classe `Brinquedo` representa a tabela `TDS_TB_BRINQUEDOS` no banco de dados Oracle.

## Atributos da classe Brinquedo

| Atributo | Tipo | Descrição |
|---|---|---|
| id | Long | Identificador do brinquedo |
| nome | String | Nome do brinquedo |
| tipo | String | Tipo do brinquedo |
| classificacao | String | Classificação indicativa do brinquedo |
| tamanho | String | Tamanho do brinquedo |
| preco | BigDecimal | Preço do brinquedo |

## Etapa 2 - Banco de Dados Oracle

A preencher pelo responsável pela configuração do banco.

## Etapa 3 - Repository e Service

A preencher pelo responsável pela camada de persistência e regra de negócio.

## Etapa 4 - Controller e Endpoints

A preencher pelo responsável pelos endpoints CRUD.

## Etapa 5 - Testes no Postman/Insomnia

A preencher pelo responsável pelos testes e prints.