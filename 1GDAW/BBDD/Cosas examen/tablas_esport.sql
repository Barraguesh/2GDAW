DROP TABLE usuarios cascade constraints;
DROP TABLE duennos cascade constraints;
DROP TABLE jugadores cascade constraints;
DROP TABLE partidos cascade constraints;
DROP TABLE equipos cascade constraints;
DROP TABLE jornadas cascade constraints;


CREATE TABLE usuarios
  (
   cod  INTEGER GENERATED ALWAYS AS IDENTITY,
   nickname VARCHAR2(15) UNIQUE NOT NULL,
   nombre VARCHAR2(15) NOT NULL,
   apellido VARCHAR2(15) NOT NULL,
   contrasenna VARCHAR2(15) NOT NULL,
   CONSTRAINT usu_cod_pk PRIMARY KEY ( cod )
  ) ;


CREATE TABLE duennos
  (
    dni  VARCHAR2(9),
    nombre    VARCHAR2(10) NOT NULL,
    apellido  VARCHAR2(15),
    movil VARCHAR2(10),
    email VARCHAR2(30),
    CONSTRAINT duen_cod_pk PRIMARY KEY (dni)
  );

CREATE TABLE equipos
  (
    cod  INTEGER GENERATED ALWAYS AS IDENTITY,
    nombre  VARCHAR2(10) UNIQUE NOT NULL,
    duenno_dni VARCHAR2(9),
    CONSTRAINT equi_cod_pk PRIMARY KEY ( cod ),
    CONSTRAINT equipo_duenno_fk FOREIGN KEY ( duenno_dni  )
       REFERENCES duennos ( dni ) ON DELETE CASCADE
  ) ;


CREATE TABLE jugadores
  (
    cod  INTEGER GENERATED ALWAYS AS IDENTITY,
    nombre    VARCHAR2(10) NOT NULL,
    apellido  VARCHAR2(15),
    nickname  VARCHAR2(10) UNIQUE NOT NULL,
    sueldo    NUMBER,
    equipo_cod INTEGER,
    CONSTRAINT juga_cod_pk PRIMARY KEY ( cod ),
    CONSTRAINT jugador_equipo_fk FOREIGN KEY ( equipo_cod )
     REFERENCES equipos ( cod )
  ) ;


CREATE TABLE jornadas
  (
    cod    INTEGER GENERATED ALWAYS AS IDENTITY,
    fechaJornadaI DATE NOT NULL,
    fechaJornadaF DATE NOT NULL,
    CONSTRAINT jorna_cod_pk PRIMARY KEY ( cod )
  ) ;

CREATE TABLE partidos
  (
    cod   INTEGER GENERATED ALWAYS AS IDENTITY,
    fecha DATE NOT NULL,
    jugado CHAR(1) DEFAULT 'N',
    jornada_cod  INTEGER NOT NULL,
    codEquipo_Visitante   INTEGER NOT NULL,
    codEquipo_Local  INTEGER NOT NULL,
    resultadoEL   INTEGER DEFAULT 0,
    resultadoEV   INTEGER DEFAULT 0,
    CONSTRAINT part_cod_pk PRIMARY KEY ( cod ),
    CONSTRAINT part_jugado_ck CHECK (jugado in ('S','N')),
    CONSTRAINT part_equipo_visi_fk FOREIGN KEY ( codEquipo_Visitante )
      REFERENCES equipos ( cod ) ON DELETE CASCADE,
    CONSTRAINT part_equipo_local_fk FOREIGN KEY ( codEquipo_Local ) 
      REFERENCES equipos ( cod ) ON DELETE CASCADE,
    CONSTRAINT partido_jornada_fk FOREIGN KEY ( jornada_cod )
      REFERENCES jornadas ( cod ) ON DELETE CASCADE
  ) ;


--Insert de Usuarios
INSERT INTO usuarios VALUES(default,'admin','administrador','principal','admin');
INSERT INTO usuarios (nickname, nombre, apellido, contrasenna) VALUES('u1','a','a', 'passwa');
INSERT INTO usuarios (nickname, nombre, apellido, contrasenna) VALUES('u2','b','b', 'passwb');

--Insert de Duennos
INSERT INTO duennos (dni,nombre,apellido) VALUES ('20293875D', 'FERNANDO', 'PARRA');
INSERT INTO duennos (dni,nombre,apellido) VALUES ('82386993G', 'AMAYA', 'ANITUA');
INSERT INTO duennos (dni,nombre,apellido) VALUES ('78567456A', 'PEDRO', 'COLON');
INSERT INTO duennos (dni,nombre,apellido) VALUES ('67456938W', 'NEREA', 'ALZOLA');

--Insert de Equipos
INSERT INTO equipos VALUES(default,'eq0','20293875D');
INSERT INTO equipos VALUES(default,'eq1','82386993G');
INSERT INTO equipos VALUES(default,'eq2','78567456A');
INSERT INTO equipos VALUES(default,'eq3','67456938W');

--Insert de Jugadores
INSERT INTO jugadores VALUES(default,'jug1','a0','na0',1000,1);
INSERT INTO jugadores VALUES(default,'jug2','b0','nb0',1000,1);
INSERT INTO jugadores VALUES(default,'jug3','c0','nc0',1000,1);
INSERT INTO jugadores VALUES(default,'jug4','d0','nd0',1000,1);
INSERT INTO jugadores VALUES(default,'jug5','e0','ne0',1000,1);
--INSERT INTO jugadores VALUES(default,'f0','f0','nf0',1000,1);


INSERT INTO jugadores VALUES(default,'jug11','a1','na1',1000,2);
INSERT INTO jugadores VALUES(default,'jug12','b1','nb1',1000,2);
INSERT INTO jugadores VALUES(default,'jug13','c1','nc1',1000,2);
INSERT INTO jugadores VALUES(default,'jug14','d1','nd1',1000,2);
INSERT INTO jugadores VALUES(default,'jug15','e1','ne1',1000,2);
--INSERT INTO jugadores VALUES(default,'f1','f1','nf1',1000,2);


--Insert de Jornadas
INSERT INTO jornadas VALUES (DEFAULT,TO_DATE('3/5/2018','DD/MM/YYYY'),TO_DATE('7/5/2018','DD/MM/YYYY'));
INSERT INTO jornadas VALUES (DEFAULT,TO_DATE(SYSDATE-3,'DD/MM/YYYY'),TO_DATE(SYSDATE+3,'DD/MM/YYYY'));

--Insert de Jornadas
INSERT INTO Partidos VALUES (DEFAULT,TO_DATE('3/5/2018','DD/MM/YYYY'),'S',1,2,1,8,5);
INSERT INTO Partidos VALUES (DEFAULT,TO_DATE('7/5/2018','DD/MM/YYYY'),'S',1,4,3,1,0);
INSERT INTO Partidos VALUES (DEFAULT,TO_DATE(SYSDATE-2,'DD/MM/YYYY'),'S',2,1,2,3,5);
INSERT INTO Partidos VALUES (DEFAULT,TO_DATE(SYSDATE+1,'DD/MM/YYYY'),'N',2,3,4,DEFAULT,DEFAULT);

COMMIT;





