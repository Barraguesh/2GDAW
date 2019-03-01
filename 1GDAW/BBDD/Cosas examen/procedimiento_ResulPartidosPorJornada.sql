CREATE OR REPLACE 
  PROCEDURE ResulPartidosPorJornada (p_cod_jor integer,C_partidos OUT SYS_REFCURSOR) AS
  BEGIN
-- Abrir el cursor y llenarlo con datos
  OPEN C_partidos for
      SELECT P.cod, P.fecha,
          P.codEquipo_Local, P.codEquipo_Visitante
      FROM jornadas J, partidos P
      WHERE P.jornada_cod = J.cod
      AND J.cod=p_cod_jor
      AND P.jugado='S'
      ;
  END;

