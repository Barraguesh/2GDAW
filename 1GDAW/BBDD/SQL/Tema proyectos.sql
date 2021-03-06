--1--
SELECT DISTINCT C.NOMBRE
FROM CONDUCTORES C, TRABAJOS T, MAQUINAS M
WHERE C.COD_C = T.COD_C
AND T.COD_M = M.COD_M
AND UPPER(M.NOMBRE) = 'VOLQUETA';

--2--
SELECT P.COD_P, P.DESCRIPCION, P.CLIENTE
FROM PROYECTOS P , MAQUINAS M, CONDUCTORES C, TRABAJOS T
WHERE P.COD_P = T.COD_P
AND T.COD_C = C.COD_C
AND UPPER(C.LOCALIDAD) = 'RIVAS'
AND T.COD_M = M.COD_M
AND PRECIOHORA > 12;

--3--
SELECT COD_C
FROM TRABAJOS
WHERE COD_M = 'M03' 
INTERSECT 
SELECT COD_C
FROM TRABAJOS 
WHERE COD_M = 'M04';

--4--
SELECT T.COD_P, P.DESCRIPCION, P.CLIENTE, COUNT(*) AS "NUMERO DE TRABAJOS" 
FROM TRABAJOS T, PROYECTOS P
WHERE T.COD_P = P.COD_P
GROUP BY T.COD_P, P.DESCRIPCION, P.CLIENTE
HAVING COUNT(*) >= 2;

--5--
SELECT NOMBRE 
FROM CONDUCTORES
WHERE CATEGORIA < ANY (SELECT CATEGORIA
                        FROM CONDUCTORES
                        WHERE UPPER(LOCALIDAD) = 'ARGANDA');
                        
--6--
SELECT NOMBRE
FROM CONDUCTORES
WHERE COD_C <> ALL (SELECT COD_C
                  FROM TRABAJOS
                  WHERE COD_P = 'P01');

SELECT * FROM CONDUCTORES;
SELECT * FROM TRABAJOS;
SELECT * FROM MAQUINAS;
SELECT * FROM PROYECTOS;
