# Ejercicio 10 - Pedido

Desarrolla una definición de esquema XML apropiada para describir una clase de documentos "Pedido de compra":

Una orden de compra debe contener información acerca del destinatario del envío, datos de facturación, datos sobre la forma de pago, fecha de pedido y una relación de los productos adquiridos. Adicionalmente, podrá contener una sección de comentarios opcional que admitirá un máximo de 1000 caracteres. Acerca del destinatario del envío, debe recoger al menos sus datos personales, teléfono y email de contacto y la dirección postal de entrega, así como los datos de contacto que estime convenientes. Además, deberá indicar el código de dicho cliente que actúa como clave en la base de datos del sistema.

Una dirección postal viene determinada por el nombre del destinatario, la vía, el número, el piso, escalera y letra (estos tres últimos campos son opcionales) la ciudad, la provincia y el código postal. Considera la posibilidad de indicar el tipo de vía de que se trata. Por omisión, el tipo de vía será "calle", aunque también puede tomar como valores "Avda.", "plaza", "glorieta" o "lugar". No se admiten pedidos de fuera de España, por lo que si bien es necesario que se especifique el país, éste será un dato fijo.


Como datos de facturación, debe recoger al menos la dirección postal de facturación, así como el NIF/CIF del comprador.

Dependiendo de si el pago se realizó mediante tarjeta de crédito, o por transferencia bancaria, el pedido contendrá la siguiente información:

- Tarjeta de crédito: Los cuatro últimos dígitos de la tarjeta utilizada, y el resto de dígitos ocultos mediante "x", preservando los espacios presentes en el formato típico de número de tarjeta. Además deberá constar información sobre la entidad emisora de la tarjeta, tipo de tarjeta (VISA, MasterCard, American Express, etc.), nombre del titular que figura en el anverso y fecha de caducidad.
- Transferencia bancaria: identificador de la transferencia, cuenta origen de la misma, titular, fecha en que se realizó y fecha efectiva (fecha valor) del cobro. Opcionalmente, podrá contener el código SWIFT de la entidad.

Para cada producto adquirido se recogerá la siguiente información: Nombre del producto, cantidad (que podrá venir expresada en unidades no podrá exceder de 100), código de producto, precio antes de impuestos y descuentos, fecha de envío sólo si se trata de un pedido que será enviado en varias partes, descuento aplicado, IVA aplicado y un comentario opcional de máx. 100 caracteres.

El formato del código de producto viene determinado por el correspondiente campo en la base de datos de productos y es de tres dígitos seguidos de un guión y de dos letras mayúsculas. Interpreta libremente aquellos aspectos del tipo de documento que no hayan quedado perfectamente definidos en este enunciado, y añade un comentario en el esquema para saber como lo has interpretado.
