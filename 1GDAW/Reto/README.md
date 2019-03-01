###### Enunciado del reto [link](/Reto/Enunciado%20reto.pdf)

<h1 align="center">
  <img src="/Reto/Documentacion/Media/Icono.png" height="150" width="128" alt="Logo"/>
  <br/>
  UDA App
</h1>
<h5 align="center">Aplicación para la gestion de ligas de e-sports</h5>

[![Releases](https://img.shields.io/github/release/UDA-Corporation/UDA_app.svg)](https://github.com/UDA-Corporation/UDA_app/releases)
[![License](https://img.shields.io/badge/license-MIT-lightgrey.svg?longCache=true&style=flat)](https://github.com/UDA-Corporation/UDA_app/blob/master/LICENSE)

## Para qué sirve
La aplicación esta preparada para crear ligas, equipos y jornadas, aparte de jugadores, dueños de los distintos equipos, usuarios que consultarán la clasificación y el estado de las jornadas y los administradores, que podrán crear todo lo anterior, modificarlo y eliminarlo en caso de ser necesario.

## Instalación
Disponemos de un tutorial para usuarios (**[vídeo](/Reto/Documentacion/Manual%20de%20usuario.mp4?raw=true)**) que muestra como instalar y usar la aplicación desde una cuenta existente o nueva de usuario. Se puede descargar el ejecutable .jar comprimido desde **[aquí.](/Reto/App/UDA_App.zip?raw=true)**

## Cómo desplegar la aplicación para su desarrollo
La aplicación está codificada en Java. El proyecto ha sido creado y editado con Netbeans. El proyecto se encuentra en [App>>UDA_App](/Reto/App/UDA_app).  
<br/>
**Lo primero:** necesitaremos crear la base de datos con las tablas necesarias. El script de SQL para la creación de la BDD está en App>>Script_BDD, lo ejecutamos y comprobamos que todo ha sido creado. Opcionalmente, podemos tambien añadir unos primeros datos iniciales con el fichero "Carga de datos iniciales" que se encuentra en la misma carpeta del script de creación.  
<br/>
**Lo segundo:** Una vez creada la base de datos necesitamos configurar el JPA usado en el proyecto para conectarnos al servidor. Para ello editaremos el "persistence.xml" que se encuentra en App>>UDA_App>>>>src>>META-INF.  
Se tiene que editar los campos que en la imagen aparecen como "NombreDelHost", "SID", "USUARIO" y "CONTRASEÑA", introduciendo las credenciales del servidor que se desea utilizar.  

![Persistence.xml](/Reto/Documentacion/Media/Persistence.PNG)

Una vez hechos estos pasos podremos desplegar la aplicación en nuestro IDE para su desarrollo. Tener en cuenta que este trabajo se ha creado bajo una licencia MIT.  

## Capturas de pantalla  
![VPrincipal](/Reto/Documentacion/Media/VPrincipal.png)
<h6 align="center">Pantalla principal (vista de usuario)</h6>

![VClasificacion](/Reto/Documentacion/Media/VClasificacion.PNG)
<h6 align="center">Pantalla de consulta de clasificación (vista de usuario)</h6>

![VJornadas](/Reto/Documentacion/Media/VJornadas.PNG)
<h6 align="center">Pantalla de consulta de jornadas (vista de usuario)</h6>

## Documentación
**Documentación del proyecto [link](/Documentacion)**  

| Links específicos |
| ------------- |
| Planificación detallada [link](/Reto/Documentacion/Planificación.xlsx?raw=true) |
| Documento de implementación del blog (anexo de realización de copias de seguridad incluido) [link](/Reto/Documentacion/Documentación%20de%20la%20implementación%20del%20blog.pdf) |
| Manual del administrador [link](/Reto/Documentacion/Manual%20del%20administrador.pdf) |
| Estructura del fichero log [link](/Reto/Script%20de%20red) |
| Documentación Javadoc [link](/Reto/App/Javadoc.zip?raw=true) |
| MER [link](/Reto/Documentacion/MER%20y%20Relacional/MER.pdf) |
| Modelo relacional [link](/Reto/Documentacion/MER%20y%20Relacional/Modelo_relacional.pdf) |
| Diagramas UML [link](/Reto/Documentacion/Diagramas%20UML) |
| Dirección del blog (solo accesible desde la red de egibide): [10.1.2.1](https://10.1.2.1) |

###### Realizado por UDA Corp. bajo licencia [MIT](https://github.com/Barraguesh/UDA_app/blob/master/LICENSE). 2018.
