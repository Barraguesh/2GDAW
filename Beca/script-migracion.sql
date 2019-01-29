/* Buscar correos de egibide duplicados */
SELECT * FROM alumno WHERE usuario IN (select usuario from alumno GROUP by usuario HAVING COUNT(usuario) > 1) AND migrar = 1


/* ------------------------------------------- Script migración ------------------------------------------- */

/* ------------------------------------------- SANEAMIENTO ------------------------------------------- */
/* Añade columna migrar */
ALTER TABLE alumno
ADD migrar varchar(255);

/* Creamos tabla temporal */
CREATE TABLE temporal (SELECT * FROM alumno);

/* Emails egibide duplicados, cambiamos migrar a 1 en los mas recientes y que no tienen errores en el correo */
UPDATE alumno
SET migrar = 1
WHERE correo IN (SELECT correo 
                  FROM temporal t1
                  WHERE fec_acceso = (SELECT max(t2.fec_acceso) 
                                      FROM temporal t2
                                      WHERE t1.usuario = t2.usuario)
                  AND correo LIKE '%gmail%' 
                  OR correo LIKE '%hotmail%' 
                  OR correo LIKE '%yahoo%'
                  GROUP by usuario 
                  HAVING COUNT(usuario) > 1);

/* Hacer que fec_acceso pueda ser null */
ALTER TABLE temporal MODIFY fec_acceso VARCHAR(10) NULL;

/* Ponemos fec_acceso a las que no tienen */
UPDATE alumno
SET fec_acceso = fec_alta
WHERE fec_acceso = null
AND correo IN (select correo from temporal WHERE fec_acceso = null GROUP by correo HAVING COUNT(correo) > 1);

/* Correos duplicados, cambiamos migrar a 1 */
UPDATE alumno
SET migrar = 1
WHERE usuario IN (SELECT usuario 
                  FROM temporal t1
                  WHERE fec_acceso = (SELECT max(t2.fec_acceso) 
                                      FROM temporal t2
                                      WHERE t1.correo = t2.correo)
                  GROUP by correo 
                  HAVING COUNT(correo) > 1);

/* Hacer que tlf_movil pueda ser null */
ALTER TABLE alumno MODIFY tlf_movil INT(9) NULL;

/* Cambiar telefonos en 0 a null */
UPDATE alumno SET tlf_movil=null WHERE tlf_movil = 0;

/* ------------------------------------------- INSERCION DATOS EN NUEVA BBDD ------------------------------------------- */
/* Insertar en fos_user */
INSERT INTO devlanpoltsa.fos_user (username, username_canonical, email, email_canonical, enabled, salt, password, last_login, confirmation_token, password_requested_at, roles, creado, modificado)
SELECT correo, correo, correo, correo,1, null,'pendiente', null, null,null,'a:1:{i:0;s:11:"ROLE_ALUMNO";}',null,null
FROM egibideLanpoltsa.alumno
WHERE 1=1
AND migrar = 1
GROUP BY egibideLanpoltsa.alumno.correo;

/* Insertar alumnos */
INSERT INTO devlanpoltsa.alumno (user_id, nombre, apellidos, email, emailegibide, movil, cv, foto, carnet, busquedaempleo, notificaciones, situacion, creado, modificado)
SELECT (SELECT id FROM devlanpoltsa.fos_user WHERE fos_user.email = correo), nombre, apellidos, correo, usuario, tlf_movil, curriculum, foto, carnet, busca_empleo, avisos, situacion, null, null
FROM egibideLanpoltsa.alumno
WHERE 1=1
AND migrar = 1
GROUP BY egibideLanpoltsa.alumno.correo;

/* Insertar profesores en fos_user */
INSERT INTO devlanpoltsa.fos_user (username, username_canonical, email, email_canonical, enabled, salt, password, last_login, confirmation_token, password_requested_at, roles, creado, modificado)
SELECT usuario, usuario, usuario, usuario, 1, null, 'pendiente', null, null,null,'a:1:{i:0;s:11:"ROLE_PROFESOR";}',null,null
FROM egibideLanpoltsa.profesor
WHERE 1=1
group by egibideLanpoltsa.profesor.usuario;

/* Insertar profesores */
INSERT INTO devlanpoltsa.profesor (user_id, nombre, apellidos, email, emailegibide, notificaciones, creado, modificado)
SELECT (SELECT id FROM devlanpoltsa.fos_user WHERE fos_user.email = usuario), nombre, apellidos, usuario, usuario, null, null, null
FROM egibideLanpoltsa.profesor
WHERE 1=1
GROUP BY egibideLanpoltsa.profesor.usuario;

/* Insertar empresas */
INSERT INTO devlanpoltsa.empresa(name, contacto, email, movil, creado, modificado)
SELECT nombre, contacto, null, null, null, null
FROM egibideLanpoltsa.empresa
WHERE 1=1
GROUP BY egibideLanpoltsa.empresa.nombre;

/* Insertar idiomas */
INSERT INTO devlanpoltsa.empresa(name, nivel)
SELECT nombre, null
FROM egibideLanpoltsa.idioma
WHERE 1=1
GROUP BY egibideLanpoltsa.idioma.nombre;

/* Insertar oferta */
INSERT INTO devlanpoltsa.empresa(profesor_id, empresa_id, name, fechafin, descripcion, carnet, situacion, creado, modificado)
SELECT nombre, null
FROM egibideLanpoltsa.idioma
WHERE 1=1
GROUP BY egibideLanpoltsa.idioma.nombre;