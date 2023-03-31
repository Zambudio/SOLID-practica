# Ejercicio de práctica sobre principios SOLID

## Modificar funcion getSize() en la clase Directory

El primer paso es realizar la modificación que se nos pide en el código. 

Realizo un primer commit para que se registre este cambio y comenzar a aplicar
los principios SOLID.


## Aplicar principio de responsabilidad única

### Problemas detectados:

Lo primero que veo es que tanto la clase Directory como la clase File implementan la interfaz
de FileSystemItem y ambas clases heredan de la clase FileSystemItemBase.

La clase Directory tiene varios métodos que generan directamente una excepción, debido a que no 
se pueden aplicar estos métodos en Directorios y la clase File también tiene métodos que no se 
pueden aplicar en ficheros.

La clase File no cumple el principio de **responsabilidad unica** debido a que tiene demasiadas
responsabilidades, por lo que voy a separarla en dos clases, una en la que lea y escriba en ficheros
y otra para la conversion de formatos.


### Aplicando soluciones:

Para solucionar este problema, he separado la clase file en dos clases, la que ya tenía la he renombrado
como FileReadWrite para especificar su funcionalidad y he eliminado los metodos de convertir archivos, los
cuales he implementado en otra clase llamada FileConverted. 

De esta manera ya hemos aplicado el principio de **responsabilidad única**


## Aplicar principio de segregación de interfaz

### Problemas detectados:

Otro problema que veo es que la interfaz que implementan las clases tiene muchos metodos que después las
clases Directory y File no implementan y generan excepciones, esto imcumple el principio de **segregación
de interfaz**.

Para solucionarlo voy a implementar interfaces más específicas.


### Aplicando soluciones:

He implementado tres nuevas interfaces, una para las operaciones de Directorios, otra para las operaciones
de Ficheros y una para las operaciones de convertir Ficheros.

Creo un commit con mi solucion de la segregacion de la interfaz.


## Aplicar principio de inversión de dependencia

### Problemas detectados:

He intendado eliminar los metodos de las clases que generan excepciones o no hacen nada, implementando
solo la interfaz especifica que corresponde a cada clase, pero me he encontrado con un problema de dependencias
entre las clases.

Al heredar tanto directory como files de FileSystemItemBase, tienen metodos que se están implementando en las
dos clases y estos se usan en FileSystemBuilder. Al intentar separar los metodos me he encontrado con muchos
fallos que no termino de ver como solucionarlos.

La solucion que me gustaría implementar para dejar el codigo limpio y cumpliendo el principio de inversion de 
dependencia sería la de que tanto en la clase File como en la clase Directory solo se implementaran los metodos
que les corresponden, pero después de trastear bastante no lo he conseguido.


### Aplicando soluciones:

He separado las interfaces en un paquete solo para ellas, me faltaria que no hubiera dependendias entre estas
interfaces y que las clases pudieran actuar por separado.


