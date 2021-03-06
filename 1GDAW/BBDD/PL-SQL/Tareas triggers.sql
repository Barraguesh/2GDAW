SET SERVEROUTPUT ON;

--1--
CREATE OR REPLACE TRIGGER ins_emple02
BEFORE INSERT ON EMPLE
DECLARE
    HORA VARCHAR(20);
BEGIN
    SELECT TO_CHAR(SYSDATE, 'HH24:MI') INTO HORA  FROM DUAL;    
    IF HORA NOT BETWEEN '09:30' AND '17:30'
        THEN RAISE_APPLICATION_ERROR (-20001, 'No se puede insertar fuera del horario laboral');
    END IF;
END;

SELECT * FROM EMPLE;

INSERT INTO EMPLE VALUES (7934,'MU�OZ','EMPLEADO',7782,'23/01/1982',169000,NULL,10);

ALTER TRIGGER ins_emple02 DISABLE;


--2--
CREATE OR REPLACE TRIGGER CTRL_EMPLE02
AFTER INSERT OR UPDATE OR DELETE ON EMPLE  
FOR EACH ROW        
BEGIN
    CASE
        WHEN INSERTING THEN
            INSERT INTO CRTL_EMPLEADOS VALUES('EMPLE',USER,SYSDATE,'INSERT');
        WHEN UPDATING THEN
            INSERT INTO CRTL_EMPLEADOS VALUES('EMPLE',USER,SYSDATE,'UPDATE');
        WHEN DELETING THEN
            INSERT INTO CRTL_EMPLEADOS VALUES('EMPLE',USER,SYSDATE,'DELETE');
        ELSE
            RAISE_APPLICATION_ERROR(-20001,'ERROR');
    END CASE;
END CTRL_EMPLE02;

SELECT * FROM CTRL_EMPLEADOS;

--3--
CREATE OR REPLACE TRIGGER NOPERMITIR02
BEFORE INSERT ON EMPLE
FOR EACH ROW
DECLARE
    DEPT_NU VARCHAR(2);
BEGIN
    SELECT EMPLE.DEPT_NO INTO DEPT_NU
    FROM EMPLE, DEPART
    WHERE EMPLE.DEPT_NO=DEPART.DEPT_NO
    AND UPPER(DEPART.DNOMBRE)='VENTAS'
    GROUP BY EMPLE.DEPT_NO;
    IF :NEW.DEPT_NO=DEPT_NU THEN
        RAISE_APPLICATION_ERROR(-20500,'ERROR, NO SE PUEDE INSERTAN EN EL DEPARTAMENTO VENTAS');
    END IF;
END NOPERMITIR02; 

INSERT INTO EMPLE VALUES (7934,'SARRALDE','EMPLEADO',7782,'23/01/1982',169000,NULL,10);
INSERT INTO EMPLE VALUES (7934,'SARRALDE','EMPLEADO',7782,'23/01/1982',169000,NULL,30);

--4--
CREATE OR REPLACE TRIGGER EJERCICIO402
BEFORE UPDATE OF SALARIO ON EMPLE
FOR EACH ROW WHEN (NEW.SALARIO > OLD.SALARIO * 0.2 + OLD.SALARIO)
BEGIN
    RAISE_APPLICATION_ERROR(-20600, 'NO SE PUEDE AUMENTAR M�S DEL 20% EL SALARIO. EMPLEADO AFECTADO: '||:NEW.APELLIDO);
END EJERCICIO402;

UPDATE EMPLE
SET SALARIO=SALARIO*2
WHERE DEPT_NO=20;

--5--

--TRIGGERS 2.1--
CREATE OR REPLACE TRIGGER EJERCICIO1P02
AFTER INSERT ON PRODUCTOS2
FOR EACH ROW
BEGIN
  INSERT INTO PRECIOS_PRODUCTOS2 (CO_PRODUCTO,PRECIO,FECHA_ACTUALIZACION)
  VALUES (:NEW.CO_PRODUCTO,100,SYSDATE);
END;

SELECT * FROM PRODUCTOS2;
SELECT * FROM PRECIOS_PRODUCTOS2;
DESC PRODUCTOS2;
INSERT INTO PRODUCTOS2 (NO_PRODUCTO) VALUES('COMIDITA');
ALTER TRIGGER EJERCICIO1P02 DISABLE;

--3--
CREATE OR REPLACE TRIGGER insert_comisionP02
BEFORE INSERT ON EMPLE
FOR EACH ROW
BEGIN
   IF :NEW.COMISION IS NULL OR :NEW.COMISION=0 THEN
      RAISE_APPLICATION_ERROR(-20000,'NO SE PUEDE INSERTAR');
    END IF;
END;

INSERT INTO EMPLE VALUES (7777,'Rodrigo','EMPLEADO',7782,'23/01/1982',169000,0,10);
INSERT INTO EMPLE VALUES (7777,'Rodrigo','EMPLEADO',7782,'23/01/1982',169000,null,10);
SELECT * FROM EMPLE;    
ALTER TRIGGER insert_comisionP02 DISABLE;

--4--
CREATE OR REPLACE TRIGGER INSERT_COMISIONP02
BEFORE INSERT ON EMPLE
FOR EACH ROW
BEGIN
IF :NEW.COMISION IS NULL OR :NEW.COMISION=() THEN
  :NEW.COMISION:=1;
END IF;
END;

--5--
CREATE OR REPLACE TRIGGER t_num_dirP02
BEFORE INSERT ON EMPLE
FOR EACH ROW
DECLARE
  VARR EMPLE.DIRECTOR%TYPE;
  VARR2 VARCHAR2(100);
BEGIN
    SELECT director,COUNT(director) "Num emple" INTO NULL,VARR2
    FROM emple
    GROUP BY director;
    IF VARR2>5 THEN
      RAISE_APPLICATION_ERROR(-20001,'EL EMPLEADO TIENE M�S DE 5 EMPLEADOS A SU CARGO');
    END IF;
END;

INSERT INTO EMPLE VALUES (7777,'Rodrigo','EMPLEADO',7782,'23/01/1982',169000,NULL,10);
SELECT * FROM EMPLE;

--6--
CREATE OR REPLACE TRIGGER PACKAGE RI_EMP AS
NEW_EMP EMPLE%ROWTYPE := NULL;
END;

CREATE OR REPLACE TRIGGGER
