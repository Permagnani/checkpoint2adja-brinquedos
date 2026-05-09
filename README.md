# Checkpoint 2 - Sistema de Brinquedos

Projeto desenvolvido para a disciplina de Programação Spring Boot com Persistência.

## Integrantes

- Nome: Gustavo Ribeiro - RM 564995
- Nome: Enzo Xavier Coelho - RM563379
- Nome: Matheus Gianolli - RM565258
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

Foi criado uma tabela no banco de dados Oracle que suporta a classe model de Brinquedos, ela foi criada com hibernate, utilizando o método update no application.properties.

Além disso, também foi criado uma nova classe para teste de conexão no path connection. Sem uso, por enquanto pelo menos

<img width="489" height="214" alt="image" src="https://github.com/user-attachments/assets/c8fdb0ed-a32b-4bd5-9819-50a61b44abe4" />




## Etapa 3 - Repository e Service

Nesta etapa, foram implementadas as camadas de acesso a dados (Persistência) e de regras de negócio (Service) da aplicação. A arquitetura foi construída visando a separação de responsabilidades (Separation of Concerns).

### 1. Camada de Persistência (Repository)
Foi criado o pacote `repository` contendo a interface `BrinquedoRepository`.
- **Tecnologia:** Spring Data JPA.
- **Detalhes:** A interface estende `JpaRepository<Brinquedo, Long>`, o que provê automaticamente todos os métodos essenciais de CRUD (Create, Read, Update, Delete) sem a necessidade de escrever comandos SQL manualmente no código. Ela atua como a ponte direta com o banco de dados Oracle configurado na Etapa 2.

### 2. Camada de Regras de Negócio (Service)
Foi criado o pacote `service` contendo a classe `BrinquedoService` (anotada com `@Service`).
- **Responsabilidade:** Centralizar a lógica de negócio do sistema. O Service é o intermediário seguro entre os Endpoints (que serão criados no Controller) e o Banco de Dados (Repository).
- **Injeção de Dependência:** Utiliza a anotação `@Autowired` para instanciar o `BrinquedoRepository`.
- **Métodos Implementados:**
  - `listarTodos()`: Retorna uma lista completa com todos os brinquedos cadastrados no banco de dados.
  - `buscarPorId(Long id)`: Retorna um brinquedo específico baseado no seu identificador único.
  - `salvar(Brinquedo brinquedo)`: Recebe um novo objeto do tipo Brinquedo e realiza a persistência no banco.
  - `atualizar(Long id, Brinquedo brinquedoDetalhes)`: Busca um brinquedo existente pelo seu ID, atualiza de forma segura todos os seus atributos (Nome, Tipo, Classificação, Tamanho e Preço) e salva as alterações. Caso o ID não seja encontrado, dispara uma exceção em tempo de execução (`RuntimeException`).
  - `deletar(Long id)`: Remove permanentemente o registro de um brinquedo do banco de dados com base no ID fornecido.

### Estrutura de Pastas (Pós-Etapa 3):

src/main/java/br/com/fiap/checkpoint2
├── model
│   └── Brinquedo.java
├── repository
│   └── BrinquedoRepository.java
└── service
    └── BrinquedoService.java

<img width="730" height="269" alt="image" src="https://github.com/user-attachments/assets/e1e2fa36-8041-4053-9fd0-98f9465ea307" />

   


## Etapa 4 - Controller e Endpoints

A preencher pelo responsável pelos endpoints CRUD.

## Etapa 5 - Testes no Postman/Insomnia

A preencher pelo responsável pelos testes e prints.
