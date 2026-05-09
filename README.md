# Checkpoint 2 - Sistema de Brinquedos

Projeto desenvolvido para a disciplina de Programação Spring Boot com Persistência.

## Integrantes

- Nome: Gustavo Ribeiro - RM564995
- Nome: Enzo Xavier Coelho - RM563379
- Nome: Matheus Gianolli - RM565258
- Nome: Larissa Juvenal de Magalhães - RM566457
- Nome: Júlia Menezes - RM565568

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
```text
checkpoint2adja-brinquedos-main
├── .gitattributes
├── .gitignore
├── README.md
├── mvnw
├── mvnw.cmd
├── pom.xml
├── .mvn
│   └── wrapper
│       └── maven-wrapper.properties
├── src
│   ├── main
│   │   ├── java
│   │   │   └── br
│   │   │       └── com
│   │   │           └── fiap
│   │   │               └── checkpoint2
│   │   │                   ├── Checkpoint2Application.java
│   │   │                   ├── connection
│   │   │                   │   └── TestController.java
│   │   │                   ├── controller
│   │   │                   │   └── BrinquedoController.java
│   │   │                   ├── model
│   │   │                   │   └── Brinquedo.java
│   │   │                   ├── repository
│   │   │                   │   └── BrinquedoRepository.java
│   │   │                   └── service
│   │   │                       └── BrinquedoService.java
│   │   └── resources
│   │       └── application.properties
│   └── test
│       └── java
│           └── br
│               └── com
│                   └── fiap
│                       └── checkpoint2
│                           └── Checkpoint2ApplicationTests.java
```

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

<img width="640" height="269" alt="image" src="https://github.com/user-attachments/assets/e1e2fa36-8041-4053-9fd0-98f9465ea307" />


## Etapa 4 - Controller e Endpoints

Nesta etapa foi criada a camada Controller da aplicação, responsável por receber as requisições HTTP e direcioná-las para a camada Service.

Foi criado o pacote controller contendo a classe BrinquedoController.

A classe utiliza a anotação @RestController e possui os endpoints CRUD da aplicação.

### Endpoints Criados

| Método | Endpoint | Descrição |
|--------|----------|------------|
| GET | /brinquedos | Lista todos os brinquedos |
| GET | /brinquedos/{id} | Busca brinquedo por ID |
| POST | /brinquedos | Cadastra um novo brinquedo |
| PUT | /brinquedos/{id} | Atualiza um brinquedo |
| DELETE | /brinquedos/{id} | Remove um brinquedo |

Os endpoints foram desenvolvidos utilizando Spring Boot e integrados com a camada Service.






<img width="640" height="269" alt="image" src="https://github.com/user-attachments/assets/b7a6a2a8-7b5a-40cf-b7f8-8a9e536722ac" />







## Etapa 5 - Testes dos Endpoints no Insomnia

Nesta etapa foram realizados testes completos dos endpoints CRUD da aplicação utilizando o Insomnia, validando a integração entre Controller, Service, Repository e Banco de Dados Oracle.

## Inicialização da API

A aplicação foi iniciada com sucesso utilizando Spring Boot na porta `8080`.

<img width="1365" height="30" alt="api-rodandp" src="https://github.com/user-attachments/assets/98f88b06-9b15-4aaf-a3f7-e77a14bbff0a" />

---

### Teste GET - Listagem Inicial

Endpoint responsável por listar todos os brinquedos cadastrados.

```http
GET /brinquedos
```
Resultado inicial da aplicação sem registros cadastrados:

<img width="1110" height="320" alt="Captura de tela 2026-05-09 161833" src="https://github.com/user-attachments/assets/4870b89a-48ee-405d-8402-d92d75b2022f" />

---

### Teste POST - Cadastro de brinquedo

Endpoint responsável por cadastrar um novo brinquedo no banco de dados Oracle.

```http
POST /brinquedos
```

JSON enviado:

```http
{
  "nome": "Hot Wheels",
  "tipo": "Carrinho",
  "classificacao": "5+",
  "tamanho": "Pequeno",
  "preco": 29.90
}
```

Resultado do cadastro realizado com sucesso:

<img width="1120" height="422" alt="Captura de tela 2026-05-09 162002" src="https://github.com/user-attachments/assets/24af1f84-3419-4bff-ae67-f3f1d2be50e2" />

---

### Teste GET - Listagem Após Cadastro

Validação da listagem após inserção do brinquedo.

<img width="1118" height="392" alt="Captura de tela 2026-05-09 162229" src="https://github.com/user-attachments/assets/490f9289-dc4b-4a1a-85bb-858e8bab022f" />

---

### Teste GET por ID

Busca de brinquedo utilizando identificador único.

```http
GET /brinquedos/1
```

<img width="1118" height="382" alt="Captura de tela 2026-05-09 162244" src="https://github.com/user-attachments/assets/34aacae9-7775-4c63-82a1-3138fa714623" />

---

### Teste PUT - Atualização de Brinquedo

```http
PUT /brinquedos/1
```

JSON enviado:

```http
{
  "nome": "Hot Wheels Premium",
  "tipo": "Carrinho",
  "classificacao": "6+",
  "tamanho": "Médio",
  "preco": 49.90
}
```
Resultado da atualização:

<img width="1117" height="389" alt="Captura de tela 2026-05-09 162320" src="https://github.com/user-attachments/assets/27162adb-5f83-4d22-a914-8981a4a6a114" />

---

### Teste GET - Validação da Atualização

Confirmação da atualização realizada no banco de dados.

<img width="1122" height="415" alt="Captura de tela 2026-05-09 162346" src="https://github.com/user-attachments/assets/7f7fa605-62cf-4bc0-a597-e48e04569918" />

---

### Teste DELETE - Remoção de Brinquedo

Remoção do brinquedo utilizando o endpoint DELETE.

```http
DELETE /brinquedos/1
```

<img width="1122" height="357" alt="Captura de tela 2026-05-09 162406" src="https://github.com/user-attachments/assets/382457b0-dfce-4bbf-826c-798ef67f366f" />

---

### Teste Final - Lista Vazía

Validação final demonstrando que o registro foi removido corretamente.

<img width="1115" height="333" alt="Captura de tela 2026-05-09 162418" src="https://github.com/user-attachments/assets/3ad69879-fe03-4dc4-ac86-0fec7b66a237" />

---

## Conclusão

O projeto foi desenvolvido utilizando arquitetura em camadas com Spring Boot, Oracle Database e Spring Data JPA, implementando com sucesso todas as operações CRUD da aplicação.

Os testes realizados no Insomnia validaram o correto funcionamento dos endpoints e da persistência dos dados no banco Oracle.



