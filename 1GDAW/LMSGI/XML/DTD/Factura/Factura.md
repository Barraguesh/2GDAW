# Ejercicio 6 - Factura

Utilizando como base el fichero [factura.xml](factura.xml) que se te facilita, crea un esquema en formato DTD que permita validar facturas como la anterior y que tenga en cuenta los siguientes aspectos:

- Toda `factura` tiene un identificador obligatorio.
- Los elementos `emision`, `vendedor`, `cliente` y `articulo` son obligatorios, mientras que `descuento` es opcional.
- El elemento `articulo` puede aparecer varias veces, los demás sólo una vez.
- `vendedor` tiene el atributo obligatorio `id` y el elemento obligatorio `nombre`.
- `cliente` tiene el atributo obligatorio `id` y los elementos `nombre`, `direccion` y `telefono`.
- `nombre` y `direccion` son obligatorios, mientras que `telefono` es opcional y además puede aparecer más de una vez.
- Cada `articulo` tiene los atributos obligatorios `id` e `iva` y los elementos obligatorios `denominacion`, `precio` y `cantidad`.
- `descuento` puede contener sólo un número.
