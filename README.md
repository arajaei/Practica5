# Aplicación Cliente/Servidor 

El objetivo de esta sesión práctica es aplicar los conceptos relacionados con el paradigma
cliente/servidor desde el punto de vista de la comunicación entre procesos.

## Ejercicio.

Implemente una aplicación cliente/servidor, utilizando el API de Sockets de flujo, en
la cual el cliente envíe dos arrays de enteros al servidor, este los sume y devuelva el 
array resultado al cliente.

1. Utilizar la clase serializable (DataObj) como interfaz entre el cliente y el servidor. 
   En esta clase se han de definer tres métodos: 

      * uno para inicializar los valores del array (*set*), 

      * uno para obtener los valores del array (*get*) y 

      * uno para mostrar el contenido del mismo (*show*).

2. Implementar el servidor (*ArithServer*)

   El servidor será un servidor simple que espera por una conección. 
   Cuando la conexión se establezca, leerá los objetos que le envía el cliente. 
   Realizará la suma y devolverá el objeto resultado.

3. Implementar el cliente ( *ArithClient*)

   El cliente será un cliente simple. 
   Ha de definir dos objetos arrays con los que realizará su solicitud al servidor. 
   Cuando recibe el resultado lo muestra por la pantalla.  

4. Utilizar el método *currentTimeMillis()* de la clase System para establecer un
   cronómetro en el cliente del ejercicio anterior ¿Cuánto tiempo consume la implementación?
