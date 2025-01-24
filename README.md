[JAVA_BADGE]:https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white
[SPRING_BADGE]: https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white
[MYSQL_BADGE]:https://img.shields.io/badge/MySQL-005C84?style=for-the-badge&logo=mysql&logoColor=white
[DOCKER_BADGE]: https://img.shields.io/badge/Docker-2CA5E0?style=for-the-badge&logo=docker&logoColor=white
[INSOMNIA_BADGE]: https://img.shields.io/badge/Insomnia-5849be?style=for-the-badge&logo=Insomnia&logoColor=white


<h1 style="font-weight: bold;">Desafio Back-end  Magalu 🛍️</h1>


![spring][SPRING_BADGE]
![java][JAVA_BADGE]
![mysql][MYSQL_BADGE]
![docker][DOCKER_BADGE]
![insomnia][INSOMNIA_BADGE]

<p>
 <a href="#started">Inicializando Projeto</a> • 
  <a href="#started">Variáveis de Ambiente</a> • 
  <a href="#routes">Endpoints</a> 
</p>

<p>
  <b>O projeto visa solucionar um desafio backend proposto pela Magula. Nesse desafio precisamos construir um plataforma de comunicação que possa agendar um envio de notificação, consultar a situaão desse agendamento e também cancelar esse agendamento. Nele foram usadas as tecnologias propostas no desafio: Java, MySQL, Spring Boot e Spring Schedule. O projeto não implementa o envio das notificações em si, somente fornece a infraestrutura necessária para que elas sejam agendadas e persistidas no banco de dados.</b>
</p>

<h2 id="started">Instruções de Instalação</h2>

<h3>Pré-requisitos:</h3>

- Ter o Docker instalado.
- Um software de capaz de fazer as requisições http.
- Uma IDE habilitada para compilar Java.

<h3>Inicializando Projeto:</h3>

No terminal digite:

```bash
git clone https://github.com/BrendaBraganca/desafio-magalu
```

<h3>Variaveis de Ambiente</h3>
1. Configurações do MySQL no aplication.properties:

```yaml
spring.jpa.hibernate.ddl-auto=update
spring.datasource.url=jdbc:mysql://localhost:3306/magaludb
spring.datasource.username=seu-username
spring.datasource.password=sua-senha
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.show-sql= true

```
2. Configurações do docker-compose.yml
```yaml
services:
  mysql:
    container_name: 'guide-mysql'
    image: 'mysql:latest'
    environment:
      - 'MYSQL_DATABASE=magaludb'
      - 'MYSQL_PASSWORD=sua-senha'
      - 'MYSQL_ROOT_PASSWORD=sua-senha'
      - 'MYSQL_USER=seu-user'
    ports:
      - '3306:3306'

```
2. Rodando docker no terminal
```yaml
cd docker
docker compose up

```

(O software que usei para visualizar o banco de dados foi o Beekeeper)

<h2 id="routes">Endpoints</h2>

- GET: permite que você busque uma notificação agendada e suas informações passando o seu id na url
- POST: permite que você adicione um agendamento de notificação  ã tabela.
- DELETE: permite que atualize o status de uma notificação para cancelada passando seu id na url.


<h2 id="related">Licença</h2>

Este projeto está licenciado sob a licença MIT.
