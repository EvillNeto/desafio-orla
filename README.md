<h1 align="center">Desafio Orla</h1>

Projeto tem a gestão de funcionarios e projetos em mente

### :zap: Atalhos de uso:

- [Swagger Ui](http://localhost:8080/swagger-ui/index.html)


### :rocket: Setup
- Para rodar o projeto é preciso ter o maven instalado
- A api vem com todas as configurações prontas para a porta 8080
- a aplicação ira rodar os containers do docker automaticamente
- Rodar o projeto pode ser feito pela sua IDE de preferencia ou atraves do terminal caso sua maquina tenha maven instalado lançando o comando a seguir no root do projeto

~~~
mvn spring-boot:run
~~~

- Após o uso do projeto é necessario desligar os containers com o comando:

~~~
docker-compose down
~~~

### Bibliotecas e conceitos aplicados no projeto:

1. **Spring Data JPA**
2. **Spring Boot Web**
3. **Swagger UI - (Para documentar e testes de integração)**
4. **PostgreSQL**
5. **Clean Code** 
6. **Docker Compose**
7. **Lombok**
8. **Spring Validation**


### Para testes foi utilizado as seguintes dependencias
 
1. **JUnit**
2. **Mockito**
3. **Banco H2**
4. **Assertj**