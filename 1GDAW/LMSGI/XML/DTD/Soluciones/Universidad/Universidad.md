# Ejercicio 8 - Universidad

Escribe una DTD para modelar un documento XML con las características que se enumeran a continuación. Escribe también un documento XML válido según esa DTD que sirva como ejemplo de su uso.

El documento modelará los datos correspondientes a una universidad. Recogerá información referente a alumnos, profesores y asignaturas.

Alumnos y profesores tendrán una parte de datos personales idéntica. Se recogerá la siguiente información:

- DNI o pasaporte. En caso de especificar el pasaporte, además será necesario incluir el país de procedencia.
- Nombre y apellidos.
- Fecha de nacimiento.
- Opcionalmente se podrá incluir información de contacto como dirección postal, teléfonos y cuentas de correo (puede haber varios).

En el caso de profesores se incluirá su despacho, horarios de tutorías y asignaturas que imparten.

Cada alumno tendrá una lista de las asignaturas en las que está matriculado, junto con la nota para cada una de ellas (que puede ser NP, SS, AP, NT, SB o MH).

En la información de cada asignatura se incluirá el código, número de créditos y carrera. Vamos a pensar que estamos recogiendo unicamente informacion de la carrera de arquitectura.
