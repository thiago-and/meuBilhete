# 🎲 MeuBilhete

> Organize e confira o resultado de seus bilhetes de loteria!

## 📋 Sobre o Projeto

MeuBilhete é uma API REST desenvolvida em Java com Spring Boot para gerenciar bilhetes de loteria. O sistema permite cadastrar, consultar, atualizar e excluir bilhetes com validações de dados e tratamento de erros.

## 🛠 Tecnologias Utilizadas

- **Java 21**
- **Spring Boot 3.5.5**
- **Spring Data JPA**
- **Spring Boot Validation**
- **H2 Database** (banco em memória)
- **Lombok**
- **Maven**

## 🚀 Funcionalidades

- ✅ Cadastro de bilhetes com número do concurso e dezenas
- ✅ Listagem de todos os bilhetes
- ✅ Consulta de bilhete por ID
- ✅ Atualização de bilhetes existentes
- ✅ Exclusão de bilhetes
- ✅ Validação de dados (6 a 15 dezenas obrigatórias)
- ✅ Tratamento de exceções

## 📊 Modelo de Dados

### Bilhete
```java
{
    "id": Long,
    "concurso": Integer,
    "dezenas": List<Integer>
}
```

### Validações
- **Concurso**: Obrigatório
- **Dezenas**: Obrigatórias, mínimo 6 e máximo 15 números

## 🔗 Endpoints da API

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| POST | `/bilhete` | Cadastra um novo bilhete |
| GET | `/bilhete` | Lista todos os bilhetes |
| GET | `/bilhete/{id}` | Busca bilhete por ID |
| PATCH | `/bilhete/{id}` | Atualiza um bilhete |
| DELETE | `/bilhete/{id}` | Exclui um bilhete |

### Exemplos de Uso

#### Cadastrar Bilhete
```http
POST /bilhete
Content-Type: application/json

{
    "concurso": 2650,
    "dezenas": [1, 5, 12, 23, 35, 42]
}
```

#### Resposta de Sucesso
```http
HTTP/1.1 201 Created
Content-Type: application/json

{
    "id": 1,
    "concurso": 2650,
    "dezenas": [1, 5, 12, 23, 35, 42]
}
```

#### Listar Bilhetes
```http
GET /bilhete
```

#### Atualizar Bilhete
```http
PATCH /bilhete/1
Content-Type: application/json

{
    "concurso": 2651,
    "dezenas": [2, 8, 15, 27, 33, 45]
}
```

## ⚙️ Configuração e Execução

### Pré-requisitos
- Java 21 ou superior
- Maven 3.6 ou superior

### Como executar

1. **Clone o repositório**
```bash
git clone <url-do-repositorio>
cd MeuBilhete
```

2. **Execute o projeto**
```bash
./mvnw spring-boot:run
```

Ou no Windows:
```cmd
mvnw.cmd spring-boot:run
```

3. **Acesse a aplicação**
- API: `http://localhost:8080`
- Console H2: `http://localhost:8080/h2-console`
  - JDBC URL: `jdbc:h2:mem:meubilhete`
  - Username: `sa`
  - Password: (vazio)

## 🗄️ Banco de Dados

O projeto utiliza o **H2 Database** em memória para desenvolvimento. Os dados são perdidos quando a aplicação é reiniciada.

### Configurações do Banco
```properties
spring.datasource.url=jdbc:h2:mem:meubilhete
spring.datasource.username=sa
spring.datasource.password=
spring.h2.console.enabled=true
```

## 📝 Validações

O sistema implementa validações usando **Jakarta Validation**:

- **Número do concurso**: Obrigatório
- **Dezenas**: Lista obrigatória com 6 a 15 números

### Exemplo de erro de validação
```json
{
    "error": "Validation failed",
    "message": "A quantidade de dezenas deve ser entre 6 e 15."
}
```

## 🔧 Estrutura do Projeto

```
src/
├── main/
│   ├── java/com/meubilhete/MeuBilhete/
│   │   ├── Bilhete.java                 # Entidade JPA
│   │   ├── BilheteController.java       # Controller REST
│   │   ├── BilheteExceptionHandler.java # Tratamento de exceções
│   │   ├── BilheteRepository.java       # Repository JPA
│   │   ├── BilheteRequest.java          # DTO de requisição
│   │   ├── BilheteService.java          # Lógica de negócio
│   │   └── MeuBilheteApplication.java   # Classe principal
│   └── resources/
│       └── application.properties       # Configurações
└── 
```

---

*Desenvolvido com ❤️ e Java*
