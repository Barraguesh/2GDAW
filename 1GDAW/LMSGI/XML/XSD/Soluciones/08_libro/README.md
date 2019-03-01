# Ejercicio 8 - Libro

Construir un esquema XML para la siguiente DTD:

```dtd
<!ELEMENT Libro (Titulo, Contenido, Copyright)>
<!ATTLIST Libro ISBN CDATA #REQUIRED>
<!ELEMENT Titulo (#PCDATA)>
<!ELEMENT Contenido ((Capitulo+, Separacion?)+)>
<!ELEMENT Capitulo (Tema, Seccion+)>
<!ATTLIST Capitulo materia (XML|Java) "Java" >
<!ELEMENT Tema (#PCDATA)>
<!ELEMENT Seccion (#PCDATA)>
<!ATTLIST Seccion apartados CDATA #REQUIRED dificil (si|no) "no">
<!ELEMENT Separacion EMPTY>
<!ELEMENT Copyright (#PCDATA)>
```

y probarlo con un documento xml cuyos datos serian:

```xml
<Libro>
<Titulo>Java y XML</Titulo>
<Contenido>
<Capitulo materia="XML">
<Tema>Introducción</Tema>
<Seccion apartados="7">Qué es</Seccion>
<Seccion apartados="3">Cómo se usa</Seccion>
</Capitulo>
<Capitulo materia="XML">
<Tema>Creando XML</Tema>
<Seccion apartados="0">Un documento XML</Seccion>
<Seccion apartados="2">La cabecera</Seccion>
<Seccion apartados="6">El contenido</Seccion>
</Capitulo>
<Capitulo>
<Tema>Analizando XML</Tema>
<Seccion apartados="3">Preparación</Seccion>
<Seccion apartados="3" dificil="true">SAX</Seccion>
<Seccion apartados="9" dificil="true">Manejadores</Seccion>
<Seccion apartados="0">Una forma mejor de cargar el
analizador</Seccion>
</Capitulo>
<Separacion/>
<Capitulo materia="Java">
<Tema>JDOM</Tema>
<Seccion apartados="2">Introducción</Seccion>
<Seccion apartados="4" dificil="true">DOM&amp;JDOM</Seccion>
</Capitulo>
</Contenido>
<Copyright>&OReillyCopyright;</Copyright><!-- Fichero con informacion sobre el copyright -->
</Libro>
```
