# Análisis Estático con Jshell

El análisis de código estático se refiere a la comprobación y corrección sintáctica a nivel de código fuente comúnmente sin la necesidad de ejecutar el código. El objetivo del análisis estático está centrado en verificar el cumplimiento de las reglas (número de atributos, comprobación de operaciones, creación de variables o métodos, tipo de datos, valor de las variables) que debe cumplir el código para eso utilizaremos la API de Jshell que nos proporcionará las interfaces para desarrollar nuestras reglas para cada pregunta establecida

## Background

Para lograr comprobar que la respuesta sea la correcta es necesario realizar un análisis estático que será un mecanismo para diseñar “reglas” que nos permita validar que el código sea el correcto.
Para implementar el análisis estático desarrollaremos una aplicación Spring encargado de utilizar los módulos y paquetes de la [Interfaz de Programación de Aplicación (API) de Jshell](https://docs.oracle.com/en/java/javase/17/docs/api/jdk.jshell/jdk/jshell/package-summary.html) que nos permitirá acceder a bajo nivel a las funcionalidades del interprete facilitándonos el desarrollo de nuestras reglas de validación.


## Install

Este proyecto uso [spring boot](https://spring.io/projects/spring-boot)

* Clona este repositorio
* Asegurate de usar JDK 8^ y Maven 3.x
* Ingresa a la carpeta raíz ``cd server-sandbox/``

```sh
$ mvn clean package
```

```sh
$ java -jar target/sandbox-0.0.1-SNAPSHOT.jar
```

Para observar la documentación de la API Rest ingresa al enlace: ``http://localhost:8080/swagger-ui.html``

## Maintainers

[@Alexander96pz](https://github.com/Alexander96pz).


## License

[MIT](LICENSE) © Marlon Pizarro