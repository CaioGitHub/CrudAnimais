# CRUD de Animais

Este é um projeto de **CRUD de Animais** desenvolvido em **Java com Spring Boot**, com um front-end simples em HTML/CSS/JS para testar os endpoints da API.

---

## Tecnologias Utilizadas

- **Backend**:
  - Java 17+
  - Spring Boot
  - Spring Data JPA
  - Spring-boot-starter-validation
  - H2 Database (ou outro banco de sua escolha)
- **Frontend**:
  - HTML
  - CSS
  - JavaScript (fetch API)
- **Build**:
  - Maven ou Gradle (dependendo da sua configuração)

---

## Estrutura do Projeto

```
animais/
│
├── src/
│ ├── main/
│ │ ├── java/com/exemplo/animais/
│ │ │ ├── config/       # Configurações da aplicação (ex: CORS, segurança, etc.)
│ │ │ ├── controller/   # Controllers da API (recebem requisições HTTP)
│ │ │ ├── dtos/         # Data Transfer Objects (entrada/saída de dados na API)
│ │ │ ├── model/        # Classes de entidade (representam tabelas do banco)
│ │ │ ├── repository/   # Interfaces JPA Repository (acesso a dados)
│ │ │ └── service/      # Serviços (lógica de negócio)
│ │ └── resources/
│ │ │ ├── application.properties   # Configurações do Spring Boot
│ │ │ └── static/
│ │ │ │ ├── index.html             # Front-end da aplicação (HTML)
│ │ │ │ ├── css/                   # Arquivos CSS (estilização)
│ │ │ │ └── js/                    # Arquivos JavaScript (interação com API)
├── pom.xml (ou build.gradle)      # Gerenciador de dependências e build
└── README.md                      # Documentação do projeto

```

## Abrir o Front-end:

- **Acesse o navegador em:**
  
```bash
http://localhost:8080/index.html
```

- **A partir daí você pode testar a criação, listagem, atualização e exclusão de animais.**

## Endpoints da API

| Método | Rota                   | Descrição                    |
| ------ | ---------------------- | ---------------------------- |
| GET    | `/animals`             | Lista todos os animais       |
| GET    | `/animals/{id}`        | Busca um animal pelo ID      |
| GET    | `/animals/nome/{nome}` | Busca animais pelo nome      |
| POST   | `/animals`             | Cria um novo animal          |
| PUT    | `/animals/{id}`        | Atualiza um animal existente |
| DELETE | `/animals/{id}`        | Remove um animal pelo ID     |

## Observações

- **O front-end utiliza fetch API para interagir com os endpoints.**

- **O banco de dados H2 é em memória, então todos os dados serão perdidos ao reiniciar a aplicação, a menos que você configure um banco persistente.**

- **O projeto é modular e pode ser expandido facilmente com novos recursos, como filtros e paginação.**

