# HRfullstack-back

## Rest Api endpoints

<table>
<tr><th>Method</th><th>Endpoint</th><th>Returns</th><th>Calls</th><th>Params</th></tr>
<tr>
<td>GET</td><td>/employees</td><td>List&lt;Employee&gt;</td><td>getAllEmployees()</td><td>None</td>
</tr>
<tr>
<td>GET</td><td>/employees/:id</td><td>Employee</td><td>getEmployeeById(id)</td><td>UUID id</td>
</tr>
<tr>
<td>POST</td><td>/employees</td><td>Employee</td><td>createEmployee(employee)</td><td>Employee employee</td>
</tr>
<tr>
<td>DELETE</td><td>/employees</td><td>Employee</td><td>deleteEmployeeById(id)</td><td>UUID id</td>
</tr>
<tr>
<td>PUT</td><td>/employee</td><td>Employee</td><td>updateemployeeById(id,newPlayerData)</td><td>UUID id, Employee newEmployeeData</td>
</tr>
<tr>
<td>GET</td><td>/employee</td><td>List&lt;Employee&gt;</td><td>searchEmployeeBy(name, dni, position, location)</td><td>String name,String dni,String position,String location</td>
</tr>

</table>

## Miembros del equipo

<a href="https://github.com/GustavoArdaya">
  <img src="https://github.com/GustavoArdaya.png?size=50">
</a>

<a href="https://github.com/Daniel-gallegO">
  <img src="https://github.com/Daniel-gallegO.png?size=50">
</a>

<a href="https://github.com/JaumeViBU">
  <img src="https://github.com/JaumeViBU.png?size=50">
</a>

<a href="https://github.com/mihaelagheorghiu10">
  <img src="https://github.com/mihaelagheorghiu10.png?size=50" width="50px">
</a>


## Brifing

Una empresa necesita una aplicación estilo “Dashboard” para gestionar un elemento de su negocio y nos propone crear un MVP (Producto  mínimo viable) del software de gestión con el que se debe poder crear, eliminar, edita, listar y ver un detalle de cada elemento.
Nuestro equipo ha optado por una aplicacion de RRH que puede ser usada por cualquier empresa que tiene mas de 20 empleados..

## Requisitos Funcionales (user stories)

Spring 01

- Escribir las User Stories  necesarias y ordenarlas por prioridad del negocio.
- Refinar las historias en tareas por orden de prioridad y considerando las dependencias.
- Definir los criterios de aceptación (requisitos para considerar una tarea o historia como terminada)

## Requisitos no Funcionales

Spring 01

-  clase básica para gestionar el CRUD
- un identificador y una imagen además de los atributos .
- la aplicación debe ser una SPA con React conectada a una API Rest en Spring boot.
-  usar cualquier librería de componentes de React, plantilla, etc..


### IDEAS Y REFERENCIAS

hemos buscado referencias para implementar el ‘DashBoard’, formularios, etc..

---

## 📓 Competencias técnicas

- Desarrollar una SPA con React
- Desarrollar una API Rest con Spring Boot
- Crear y conectarse a una DB SQL en memoria para pruebas

## 💻 Tecnologías

- Javascript en React
- Java en Spring Boot

## 🛠Herramientas

- Figma (Diseño de Interfases de Usuario de aplicaciones)
- Visual Studio Code (IDE o Editor de Código)
- IntelliJ (IDE para Java)
- Trello o Jira (Gestión de proyecto / Kanban)
- Git / GitHub (sistema de versionado y repositorio remoto)
- Postman

## Metodología y fases del proyecto

Modalidad: DevTeam, Pair Programing Agile,Scrum, Kanban, Principios Solid


## Competencias a adquirir

- Desarrollar una interfaz de usuario web dinámica y adaptable en React.js SPA
- Consumir una Api Rest desde React
- Desarrollar una API Rest con Spring Boot
- Separar la aplicación por capas o roles de clases en el backend
- Diseñar y conectar una Base de Datos SQL relacional simple



