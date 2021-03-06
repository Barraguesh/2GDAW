--1--
SET SERVEROUTPUT ON
DECLARE 
  --V VARCHAR(15):='Hola Mundo';
  BEGIN 
  --DBMS_OUTPUT.PUT_LINE('Hola Mundo');
    DBMS_OUTPUT.PUT_LINE('Hola Mundo');
  END; 

--2-- 
  CREATE OR REPLACE PROCEDURE HOLA AS
    BEGIN 
    DBMS_OUTPUT.PUT_LINE('Hola Mundo');
  END; 
  
EXECUTE HOLA;

--3--
CREATE OR REPLACE FUNCTION FUNCTION_HOLA
  RETURN VARCHAR
    IS
      V VARCHAR(15):='Hola Mundo';
    BEGIN
        RETURN V;
    END;
    
    SELECT FUNCTION_HOLA FROM DUAL;

--Procedimiento con valor
CREATE OR REPLACE PROCEDURE HOLA3 (NOMBRE VARCHAR)AS
    BEGIN 
    DBMS_OUTPUT.PUT_LINE('Hola'||' '||NOMBRE);
  END; 
  
  EXECUTE HOLA3('ALEJANDRO');

--Procedimiento solo la primera en mayusculas
CREATE OR REPLACE PROCEDURE HOLA4 (NOMBRE VARCHAR)AS
    BEGIN 
    DBMS_OUTPUT.PUT_LINE('Hola'||' '||initcap(NOMBRE));
  END; 
/
  EXECUTE HOLA4('ALEJANDRO');

CREATE OR REPLACE FUNCTION FUNCTION_HOLA2(nombre VARCHAR)
RETURN VARCHAR
  IS
    V VARCHAR(15):='Hola';
  BEGIN 
      RETURN V||' '||UPPER(NOMBRE);
  END;
/
  SELECT FUNCTION_HOLA2('alejandro') FROM DUAL;
  
  BEGIN   
    DBMS_OUTPUT.PUT_LINE(FUNCTION_HOLA2('alejandro'));
  END;
  
CREATE OR REPLACE PROCEDURE HOLA5 (NOMBRE VARCHAR)AS
SALUDO VARCHAR(15);
  BEGIN 
    SELECT FUNCTION_HOLA2(NOMBRE) INTO SALUDO FROM DUAL;
    DBMS_OUTPUT.PUT_LINE(SALUDO);
  END;
/
EXECUTE HOLA5('ALEJANDRO');

CREATE OR REPLACE PROCEDURE HOLA6 (EMP_NOMBRE VARCHAR)AS
V_EMPLE EMPLE%ROWTYPE;
  BEGIN 
    SELECT * INTO V_EMPLE FROM EMPLE WHERE UPPER(APELLIDO)=UPPER(EMP_NOMBRE);
    DBMS_OUTPUT.PUT_LINE(V_EMPLE.DEPT_NO);
  END;
/
EXECUTE HOLA6('REY');

--EJERCICIO CLASE--
DECLARE
  X VARCHAR(2) := 20;
BEGIN
  X := RPAD(' ',30);
EXCEPTION
  WHEN VALUE_ERROR THEN DBMS_OUTPUT.PUT_LINE('OIE PAPI LA CADENA ES MU LARGA');
END;

--SUPUESTO SUPER GUAY SIN QUE EL ORA-06502 ESTE PROGRAMADO--
DECLARE
  X VARCHAR(2) := 20;
  MAXLONG EXCEPTION;
  PRAGMA EXCEPTION_INIT(MAXLONG, -06502);
BEGIN
  X := RPAD(' ',30);
EXCEPTION
  WHEN MAXLONG THEN DBMS_OUTPUT.PUT_LINE('OIE PAPI LA CADENA ES MU LARGA');
END;

DECLARE
    X NUMBER := 0;
    EFIN EXCEPTION;
BEGIN
    LOOP
        X := X + 1;
        DBMS_OUTPUT.PUT_LINE(TO_CHAR(X));
        IF X > 10 THEN 
            RAISE EFIN;
        END IF;
    END LOOP;
EXCEPTION
    WHEN EFIN THEN /*NULL*/DBMS_OUTPUT.PUT_LINE('EXCEPTION EFIN');
END;