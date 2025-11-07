# 🎬 Filmes API

API REST desenvolvida em Java com Spring Boot para gerenciamento de filmes. Permite operações de CRUD e consulta por gênero. Documentada com Swagger para facilitar testes e integração.

## 🚀 Tecnologias

- Java 17  
- Spring Boot 3.2  
- Spring Web  
- Spring Data JPA  
- H2 Database  
- SpringDoc OpenAPI  
- Maven

## 📁 Estrutura do Projeto
src/main/java/com/vagner/filmesapi/ ├── controller/ ├── service/ ├── repository/ ├── model/ ├── dto/ ├── exception/ └── FilmesApiApplication.java

## 📚 Funcionalidades

- ✅ Cadastrar filme  
- ✅ Listar todos os filmes  
- ✅ Buscar filme por ID  
- ✅ Atualizar dados do filme  
- ✅ Excluir filme  
- ✅ Filtrar por gênero

## 🔗 Documentação Swagger

Acesse a interface interativa para testar os endpoints:

http://localhost:8080/swagger-ui.html


## 🛠️ Como executar

```bash
./mvnw spring-boot:run

Ou execute a classe FilmesApiApplication.java diretamente no IntelliJ.
🧪 Testes
Os testes estão localizados em:
src/test/java/com/vagner/filmesapi/


👨‍💻 Autor
Vagner Serafim
GitHub: github.com/VagnerSerafim






