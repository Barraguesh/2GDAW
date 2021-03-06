/*Especialista A: Dani*/

--1--
SELECT APELLIDO,SALARIO,DEPT_NO 
FROM EMPLE 
WHERE SALARIO > 200000 AND DEPT_NO IN (10,20);
--2--
SELECT APELLIDO,SALARIO 
FROM EMPLE 
WHERE SALARIO BETWEEN 150000 AND 200000;
--3--
SELECT APELLIDO 
FROM EMPLE 
WHERE DEPT_NO IN (10, 30);
--4--
SELECT APELLIDO,OFICIO 
FROM EMPLE 
WHERE ID_JEFE IS null;

/*Especialista B: Aitor*/

--1--
SELECT APELLIDO
FROM EMPLE
WHERE APELLIDO LIKE 'J%';
--2--
SELECT APELLIDO,SALARIO
FROM EMPLE
WHERE SALARIO NOT BETWEEN 150000 AND 200000;
--3--
SELECT APELLIDO
FROM EMPLE
WHERE DEPT_NO NOT IN (10,30);
--4--
SELECT DISTINCT OFICIO
FROM EMPLE;

/*Especialista C: Alejandro*/



/*Especialista D: Andrea*/

--1--
SELECT APELLIDO 
FROM EMPLE 
WHERE APELLIDO LIKE 'A%O%';
--2--
SELECT APELLIDO
FROM EMPLE
WHERE UPPER (OFICIO) NOT IN ('VENDEDOR', 'ANALISTA', 'EMPLEADO');
--3--
SELECT APELLIDO
FROM EMPLE
WHERE (COMISION_PCT IS NOT NULL);
--4--
SELECT  *
FROM EMPLE
WHERE UPPER (OFICIO) = 'ANALISTA'
ORDER BY EMP_NO; 