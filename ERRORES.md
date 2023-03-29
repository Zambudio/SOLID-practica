# Ejercicio de práctica sobre principios SOLID
## Orden en el que proceso a realizar los cambios en el codigo proporcionado

### Modificar funcion getSize() en la clase Directory

El primer paso es realizar la modificación que se nos pide en el código. 

De momento voy a hacer una modificación provisional que no es realmente lo que se pide
para su implementacion, porque voy a centrarme primero en aplicar los principios SOLID.

Realizo un primer commit para que se registre ese cambio provisional y comenzar a aplicar
los principios SOLID.

## Problemas detectados:

Lo primero que veo es que tanto la clase Directory como la clase File implementan la interfaz
de FileSystemItem, y la clase Directory tiene muchos métodos que generan directamente una 
excepción, debido a que no se pueden aplicar estos métodos en Directorios.

La clase File también tiene métodos que no se pueden aplicar en ficheros como el método addFile
y tiene funciones que nunca se usan.

**Estas últimas funciones que no se usan (convertMp3ToWav() y convertWavToMp3()) no cumplen con 
los principios de responsabilidad única**, ya que la clase es responsable de diferentes tareas
y no sería escalable en un futuro. Debo separar estas funciones en otra clase.

Para solucionar el problema de las clases que tienen funciones que no necesitan **voy a aplicar el 
principio de segregación de la interfaz**, definiendo una interfaz para la clase Directory en la 
que defina los métodos que realmente necesito. La llamaré **DirectorySystemItem**.

# Aplicando soluciones

Una vez creada la interfaz e implementandola en la clase Directory, veo que tanto la clase File 
como Directory extienden de la clase abstracta FileSystemItemBase, en la que tienen definidos 
los metodos para las dos clases.

Voy a crear una clase abstracta llamada DirectorySystemItemBase para que la clase Directory extienda
de esta y asi aplicar el principio de **inversión de dependencia**, reduciendo el acoplamiento del codigo
al separar las clases entre ellas con interfaces y clases abstractas.

Mientras que voy realizando los cambios, me voy encontrando 