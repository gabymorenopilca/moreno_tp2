# Trabajo Practico N° 2

Materia: Desarrollo de Software  
Estudiante: Gabriela Moreno

## Respuesta

Desarrollé una clase Cliente que contiene un identificador, el nombre y la dirección del cliente y sus envíos. Ya que un cliente puede hacer varios envíos, decidí usar una lista ArrayList\<Envio\> para asociarlos al cliente. También usé un método para mostrar la información del cliente y los envíos que realizó.

En la clase Sucursal, usé un identificador, su nombre y una lista de envíos recibidos, que luego se despachan. Usé un método para recibir un envío y otro para despacharlo. Ya que un envío puede ser despachado a otra sucursal o ser entregado al destinatario, hice que el método de despacho devuelva un "Envio". Además, usé una ArrayList para almacenar los envíos que recibe y despacha, porque cada sucursal puede recibir más de un envío.

Para registrar los movimientos, hice una clase Movimiento que registra la fecha del movimiento, la sucursal y el tipo de movimiento. Para los tipos de movimiento, hice un enum TipoMovimiento que indica si el envío está en preparación, fue recibido en o despachado de una sucursal, o fue entregado.

Para la clase RegistroSeguimiento, usé una ArrayList de Movimiento para almacenar cada acontecimiento. También usé un método privado para agregar acontecimientos a la lista, cuatro métodos públicos para registrar cada evento (en preparación, recibo y despacho de sucursales y entrega a destinatario) y dos métodos públicos para mostrar el historial y obtener la lista de movimientos.

A la clase Envio le agregué una instancia de RegistroSeguimiento, donde se registra lo que se hizo con el envío, dos métodos para registrar los recibos y los despachos en sucursales, un método para mostrar este historial de movimientos en pantalla, un método para obtener la sucursal actual y tres métodos para verificar si no hay paquetes, si el envío fue entregado y si la sucursal actual es igual a otra.
