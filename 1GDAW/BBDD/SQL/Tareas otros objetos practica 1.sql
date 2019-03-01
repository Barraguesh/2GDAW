--1--
SELECT * FROM DEPARTSEQ;
DESC DEPARTSEQ;

--2--
CREATE SEQUENCE  DEPT_ID_SEQ
START WITH 200
MAXVALUE 1000
INCREMENT BY 10;
--VISUALIZAR LA SENTENCIA--
SELECT * FROM USER_SEQUENCES
WHERE UPPER(SEQUENCE_NAME) = 'DEPT_ID_SEQ';

--3--
SELECT SEQUENCE_NAME, MAX_VALUE, MIN_VALUE, INCREMENT_BY, LAST_NUMBER
FROM USER_SEQUENCES;

--4--
INSERT INTO DEPARTSEQ VALUES (DEPT_ID_SEQ.NEXTVAL,'EDUCACION','VITORIA');
INSERT INTO DEPARTSEQ VALUES (DEPT_ID_SEQ.NEXTVAL,'ADMINISTRACION','RIOJA');

ALTER TABLE DEPARTSEQ
MODIFY (DEPT_NO
NUMBER(4));

--5--
SELECT DEPT_ID_SEQ.CURRVAL FROM DUAL;

--6--
CREATE TABLE CENTROS (
  ID NUMBER(2) GENERATED ALWAYS AS IDENTITY MINVALUE 1
  MAXVALUE 99
  INCREMENT BY 1
  START WITH 1
  NOORDER
  NOCYCLE
  NOT NULL ENABLE
  CONSTRAINT CEN_ID_PK PRIMARY KEY,
  NOMBRE VARCHAR(15),
  DIRECCION VARCHAR(30),
  HORARIO VARCHAR(20),
  CIUDAD VARCHAR(30) CONSTRAINT CEN_CI_CK CHECK (UPPER(CIUDAD) = CIUDAD AND CIUDAD !='TOLEDO')
);

SELECT * FROM CENTROS;

DROP TABLE CENTROS;

--7--
INSERT INTO CENTROS VALUES (/*DA ERROR LA PK*/'SAN VIATOR', 'CALLE SAN VIATOR', 'NUNCA ABRIMOS', 'VITORIA-GASTEIZ');

--8--
CREATE INDEX INDICE_DEPT_NO
ON EMPLE (DEPT_NO);

--9--
SELECT IX.INDEX_NAME, IX.UNIQUENESS, IC.COLUMN_NAME, IC.COLUMN_POSITION
FROM USER_INDEXES IX, USER_IND_COLUMNS IC
WHERE IX.INDEX_NAME = IC.INDEX_NAME
AND UPPER(IX.TABLE_NAME) = 'EMPLE';

--10--
DROP INDEX INDICE_DEPT_NO;

--11--
DROP INDEX IND_DEPT_DNOMBRE;
CREATE INDEX IND_DEPT_DNOMBRE
ON DEPARTSEQ (DNOMBRE);

--12--