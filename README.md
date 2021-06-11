## Para este proyecto que ido haciendo de manera autodidacta para aprender estas tecnologías:
	-MySql y JPA
	-Spring Boot
	-ReactJs
	-Maven

Algunas de las referencias en las cual me base y de las que considero mas facil de entender spring boot fue:

- Hands-On Full Stack Development with Spring Boot 2.0 and React
Build modern and scalable full stack applications using the Java-based Spring Framework 5.0 and React
Juha Hinkula

- Spring, Hibernate, Data Modeling, REST and TDD:Agile Java Design and Development Paperback

Aun que la referencia que mas me ayudo fue la primera por que tiene un ejemplo muy claro de como iniciar el entorno de desarrollo, desde el uso de Spring Initializr, configuracion de la base de datos, tanto h2 para pruebas y mysql hasta armar el controlador y su endpoints para realiar las peraciones CRUD, tambien tiene el ejemplo de como integrar json web token el que ya no implemente en este ejemplo.



Vista previa

![alt text](https://github.com/Eduardishion/todoAppEnSpringReactJsMySqlJpaMaven/blob/master/preview.png)


1.-Recordar se debe tener instalado MySql previamente, verificar y modificar las credenciales de la base datos para que coincidan con tu configuracion en el archivo del proyecto, la tabla es creada en JPA se crearan automaticamente y modificar el archivo.

	application.properties

2.-Para ejecutar el backend, entrar a carpeta ./target y desde cmd: 

	java -jar projectv1-0.0.1-SNAPSHOT.jar

Puerto de acceso al back-end es:

	http://localhost:9090/

Puerto de acceso a la api: 

	http://localhost:9090/api/tareas/

3.-Para instalar las librerias necesarias del fron-end: 

	node install

4.-Para ejecutar el front-end:

	npm start

Puerto de acceso al Front-end es:

	http://localhost:3000/


5.-Si todo sale bien, podemos ver la siguiente pagina, donde podemos hacer las opraciones basicas DRUD:
	
	-insertar
	-eliminar
	-actuliar 
	-mostrar

