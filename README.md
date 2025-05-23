# 📋 Gerenciador de Tarefas

API REST desenvolvida com Spring Boot para gerenciamento de tarefas. Projeto prático da faculdade com estrutura em camadas, persistência em banco de dados H2 e operações CRUD completas.

---

## 🚀 Tecnologias utilizadas

- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- H2 Database
- Maven

---

## 🗂️ Estrutura do Projeto

src/
├── main/
│ ├── java/
│ │ └── com/example/gerenciador/
│ │ ├── controller/
│ │ ├── service/
│ │ ├── repository/
│ │ └── model/
│ └── resources/
│ └── application.properties


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
Método	Endpoint	    Descrição
POST	/tarefas	    Cadastrar nova tarefa
GET	    /tarefas	    Listar todas as tarefas
PUT	    /tarefas/{id}	Atualizar uma tarefa
DELETE	/tarefas/{id}	Remover uma tarefa

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

Documentação no README

Autor:
Gustavo Ulian Zanardi — Engenharia de Software — Unicesumar
