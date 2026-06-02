# Feirinha

Projeto full stack para cadastro e listagem de feiras e tipos de feira.

O sistema possui:

- Backend em Java com Spring Boot.
- Frontend em Angular.
- Banco de dados H2 em memoria.

## Requisitos

Antes de executar o projeto, instale:

- Java 21 ou superior.
- Node.js compativel com Angular 21.
- npm.

## Executando o backend

Acesse a pasta do backend:

```bash
cd Backend/feiraApi
```

Execute a API:

```bash
./mvnw spring-boot:run
```

No Windows, use:

```bash
mvnw.cmd spring-boot:run
```

A API ficara disponivel em:

```text
http://localhost:8080
```

O banco H2 e criado em memoria com o nome `feirasdb`.

Console do H2:

```text
http://localhost:8080/h2-console
```

## Executando o frontend

Acesse a pasta do frontend:

```bash
cd Frontend/feiras-web
```

Instale as dependencias:

```bash
npm install
```

Execute a aplicacao:

```bash
npm start
```

O frontend ficara disponivel em:

```text
http://localhost:4200
```

O frontend consome a API em:

```text
http://localhost:8080
```

## Outros comandos uteis

Backend:

```bash
./mvnw test
```

No Windows:

```bash
mvnw.cmd test
```

Frontend:

```bash
npm run build
npm test
```

## Principais endpoints

Base URL:

```text
http://localhost:8080
```

### Feiras

| Metodo | Endpoint | Descricao |
| GET | `/feiras` | Lista todas as feiras cadastradas. |
| POST | `/feiras` | Cria uma nova feira. |
| DELETE | `/feiras/{id}` | Remove uma feira pelo ID. |

### Tipos de feira

| Metodo | Endpoint | Descricao |
| GET | `/tipo-feira` | Lista todos os tipos de feira cadastrados. |
| POST | `/tipo-feira` | Cria um novo tipo de feira. |
