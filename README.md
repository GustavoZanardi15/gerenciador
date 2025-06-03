![Status](https://img.shields.io/badge/Status-Finalizado-brightgreen)

# 📋 Gerenciador de Tarefas

API REST desenvolvida com Spring Boot para gerenciamento de tarefas. Projeto acadêmico com estrutura em camadas, persistência em banco de dados H2 e autenticação JWT (ponto extra).

---

## 🚀 Tecnologias utilizadas

- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- H2 Database
- Maven
- JWT (`jjwt` 0.11.5)

---

## 📁 Estrutura do Projeto

```text
src/
├── main/
│   ├── java/
│   │   └── com/example/gerenciador/
│   │       ├── controller/
│   │       ├── dto/
│   │       ├── model/
│   │       ├── repository/
│   │       ├── security/
│   │       └── service/
│   └── resources/
│       └── application.properties
└── test/

---

## ⚙️ Como rodar o projeto

1. Clone o repositório:
   ```bash
   git clone https://github.com/GustavoZanardi15/gerenciador.git
   
Abra no IntelliJ IDEA (ou outro IDE).

Rode a classe GerenciadorApplication.java.

Acesse o console do banco:

http://localhost:8080/h2-console

🛠️ Endpoints da API
| Método | Endpoint        | Descrição               |
| ------ | --------------- | ----------------------- |
| POST   | `/tarefas`      | Cadastrar nova tarefa   |
| GET    | `/tarefas`      | Listar todas as tarefas |
| PUT    | `/tarefas/{id}` | Atualizar uma tarefa    |
| DELETE | `/tarefas/{id}` | Remover uma tarefa      |


Exemplo de JSON para POST/PUT

{
"titulo": "Estudar Spring Boot",
"descricao": "Fazer os commits diários",
"status": "PENDENTE"
}


✅ Funcionalidades implementadas
Cadastro de tarefas

Listagem de tarefas

Atualização de status e conteúdo

Remoção de tarefas

Banco de dados H2 em memória

Estrutura em camadas (Controller, Service, Repository, Model)

Commits rastreáveis por funcionalidade

🔐 Autenticação JWT (Ponto Extra)
A aplicação também conta com autenticação baseada em JWT.

📥 Registro de usuário
POST /auth/register

Body JSON:
{
  "username": "admin",
  "password": "123456"
}

🔑 Login
POST /auth/login

Body JSON:

json
Copiar
Editar

{
  "username": "admin",
  "password": "123456"
}

Resposta:Bearer eyJhbGciOiJIUzI1NiJ9...

Autor:
Gustavo Ulian Zanardi — Engenharia de Software — Unicesumar
