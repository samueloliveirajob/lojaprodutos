# Portal Stelo

##Sistema que compreende:
- Posibilitar ao cliente interagir com a Stelo

##Tecnologias utilizadas:
- Spring 4
- Spring-data
- Hibernate
- Jackson 2
- Embedded Jetty 9 (br.com.stelo.portal.boot.Main.java)

### Para os testes Unitarios
- Junit
- Spring-test

### Para os testes Integrados
- Junit
- Spring-test

### Banco de dados
O Banco de dados esta configurado no pacote [br.com.stelo.boot].
Foi utilizado um banco in-memory(hsqldb) para fins de teste e persistencia.


## Serviços
###Serviço para buscar um person
O servico esta documentado atraves do teste integrado em PersonEndPointIT.java


###Passo a passo:


* Compilar o projeto

Entre na pasta ./lojaprodutos 
Execute:
```
mvn package
```

* Execute o projeto:
```
java -jar target\lojaprodutos-0.0.1-SNAPSHOT.jar
```

Nesse momento o portal está funcionando!

Serviços:
```
GET http://localhost:8085/street-api/person/{id}
POST http://localhost:8085/
```


O sistema está disponivel na web através dos caminhos:

```
http://localhost:8085/street-api/

```