/* Buscar correos de egibide duplicados */
SELECT * FROM alumno WHERE usuario IN (select usuario from alumno GROUP by usuario HAVING COUNT(usuario) > 1) AND migrar = 1

/* Insertar en fos_user */
INSERT INTO devlanpoltsa.fos_user (username, username_canonical, email, email_canonical, enabled, salt, password, last_login, confirmation_token, password_requested_at, roles, creado, modificado)
SELECT correo, correo, correo, correo,1, null,'pendiente', null, null,null,'a:1:{i:0;s:11:"ROLE_ALUMNO";}',null,null
FROM egibideLanpoltsa.alumno
WHERE 1=1
AND migrar = 1
GROUP BY egibideLanpoltsa.alumno.correo;

/* Hacer que tlf_movil pueda ser null */
ALTER TABLE alumno MODIFY tlf_movil INT(9) NULL;

/* Cambiar telefonos en 0 a null */
UPDATE alumno SET tlf_movil=null WHERE tlf_movil = 0;

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