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

---

## 🧪 Como Testar a API no Postman

Siga este passo a passo para testar todas as funcionalidades:

---

### 🔐 1. Cadastro de Usuário (ADMIN e USER)

- **POST** `/auth/register`

#### Corpo JSON:
```json
{
  "nome": "Admin Master",
  "email": "admin@email.com",
  "username": "admin",
  "password": "123456",
  "role": "ADMIN"
}

{
  "nome": "Usuário Comum",
  "email": "user@email.com",
  "username": "user",
  "password": "123456",
  "role": "USER"
}

🔑 2. Login para obter o token JWT
POST /auth/login

Corpo JSON:{
  "username": "admin",
  "password": "123456"
}

Resultado:Bearer eyJhbGciOiJIUzI1NiJ9...

Copie o token retornado e use em todas as próximas requisições como:
Authorization: Bearer <seu_token>

👤 3. Ver/Editar perfil do usuário logado
Ver perfil:
GET /usuarios/me

Editar perfil:
PUT /usuarios/me
{
  "nome": "Novo Nome",
  "email": "novo@email.com",
  "password": "novaSenha"
}

🛡️ 4. Ações disponíveis apenas para ADMIN
Listar todos os usuários:
GET /usuarios

Visualizar usuário por ID:
GET /usuarios/1

Atualizar usuário por ID:
PUT /usuarios/1
{
  "nome": "Editado Pelo Admin",
  "email": "editado@email.com",
  "username": "editado",
  "password": "123456",
  "role": "USER"
}

Deletar usuário:
DELETE /usuarios/1

📝 5. Endpoints de Tarefas (acesso com qualquer token válido)
POST /tarefas
GET /tarefas
PUT /tarefas/{id}
DELETE /tarefas/{id}
{
  "titulo": "Fazer API",
  "descricao": "Terminar a atividade com JWT",
  "status": "PENDENTE"
}


Autor: Gustavo Ulian Zanardi — Engenharia de Software — Unicesumar
