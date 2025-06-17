![Status](https://img.shields.io/badge/Status-Finalizado-brightgreen)

# 📋 Gerenciador de Tarefas

API REST desenvolvida com Spring Boot para gerenciamento de tarefas. Projeto acadêmico com estrutura em camadas, persistência em banco de dados H2 e autenticação JWT (ponto extra).

---

## 🚀 Tecnologias utilizadas

- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- Spring Security
- JWT (jjwt 0.11.5)
- H2 Database (pode ser trocado por MySQL/PostgreSQL)
- Maven

---

## 📁 Estrutura do Projeto

```text
src/
├── main/
│   ├── java/com/example/gerenciador/
│   │   ├── config/
│   │   ├── controller/
│   │   ├── model/
│   │   ├── repository/
│   │   └── security/
│   └── resources/
│       └── application.properties
└── test/

---

⚙️ Como Rodar o Projeto

Clone o repositório:
   ```bash

git clone https://github.com/GustavoZanardi15/gerenciador.git
   
Abra no IntelliJ IDEA (ou outro IDE).

Acesse a pasta:

cd gerenciador

Rode a classe GerenciadorApplication.java.

🔐 Autenticação com JWT
📥 Cadastro de Usuário
POST /auth/register

Payload JSON:{
  "nome": "Gustavo Zanardi",
  "email": "gustavo@email.com",
  "username": "admin",
  "password": "123456",
  "role": "ADMIN"
}

🔑 Login
POST /auth/login

Payload JSON:{
  "username": "admin",
  "password": "123456"
}

Resposta:Bearer eyJhbGciOiJIUzI1NiJ9...

Utilize este token como header:Authorization: Bearer <token>

👤 Endpoints do Usuário
📄 Perfil do próprio usuário (ROLE: USER ou ADMIN)
| Método | Endpoint       | Descrição                    |
| ------ | -------------- | ---------------------------- |
| GET    | `/usuarios/me` | Ver seu próprio perfil       |
| PUT    | `/usuarios/me` | Atualizar seu próprio perfil |


🛡️ Ações exclusivas para ADMIN
| Método | Endpoint         | Descrição                   |
| ------ | ---------------- | --------------------------- |
| GET    | `/usuarios`      | Listar todos os usuários    |
| GET    | `/usuarios/{id}` | Visualizar qualquer usuário |
| PUT    | `/usuarios/{id}` | Atualizar qualquer usuário  |
| DELETE | `/usuarios/{id}` | Deletar qualquer usuário    |


📌 Exemplo de JSON para edição
{
  "nome": "Novo Nome",
  "email": "novo@email.com",
  "username": "novouser",
  "password": "novasenha",
  "role": "USER"
}


📦 Endpoints de Tarefas (ROLE: USER ou ADMIN)
| Método | Endpoint        | Descrição               |
| ------ | --------------- | ----------------------- |
| POST   | `/tarefas`      | Criar nova tarefa       |
| GET    | `/tarefas`      | Listar todas as tarefas |
| PUT    | `/tarefas/{id}` | Atualizar tarefa        |
| DELETE | `/tarefas/{id}` | Deletar tarefa          |

📜 Observações
Todos os endpoints, exceto /auth/**, são protegidos por token JWT.
Apenas usuários autenticados podem acessar os dados.
Apenas ADMIN tem acesso a gerenciamento de usuários.
Senhas podem ser criptografadas com BCrypt para segurança extra (não obrigatório).

👨‍💻 Autor
Gustavo Ulian Zanardi
Engenharia de Software – Unicesumar
