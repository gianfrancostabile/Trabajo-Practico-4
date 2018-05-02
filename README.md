# Trabajo-Practico-4
* Maven: <br />
	* **A -** Explique los siguientes goals: <br />
		* **mvn clean** - Borra todas las clases que fueron compiladas previamente en la carpeta target. <br />
		* **mvn compile** - Compila/ejecuta el proyecto. <br />
		* **mvn package** - Empaqueta el proyecto con una extension .jar o .war dependiendo de que tipo se le dió. El .jar es para proyectos java simples, y el .war es para proyectos web. <br />
		* **mvn install** - Guarda el proyecto en la carpeta local .m2 del usuario. <br /> <br />
	* **B -** Explique los siguientes scopes: <br />
		* **compile** - Determina que la dependencia es necesaria para compilar el proyecto. Este scopes esta por default. <br />
		* **provided** - Determina que la dependencia reutiliza las librerias que ya fueron instaladas y no se ejecuta. <br />
		* **runtime** - La dependencia es necesaria en tiempo de ejecución pero no es necesaria para compilar. <br />
		* **test** - Ejecuta la dependencia únicamente cuando se está realizando el testing del proyecto. <br />
		* **system** - Hay que especificar explicitamente donde tiene que buscar la dependencia porque no la va a buscar en el repositorio local de la carpeta .m2. <br />
		* **import** - Indica la dependencia a reemplazar con la lista de dependencias en la sección <dependencyManagement> del POM especificado. <br /> <br />
	* **C - ¿Qué es un Archetype?** - Es una plantilla que se especifica al crear un proyecto maven. Esta plantilla crea la estructura del proyecto, el contenido del POM, la estructura de carpetas y los ficheros que incluye por defecto. <br /> <br />
	* **D - Defina la estructura base de un proyecto maven.** - La estructura base del proyecto contiene un POM, donde se hace la configuración del proyecto, y una carpeta src, esta a, a la vez, tiene 2 carpetas: main, test (esta carpeta esta porque la incluyo una dependencia de maven). Finalmente dentro de la carpeta main se va a encontrar todas las carpetas de java (clases, intefaces, paquetes, etc). <br /> <br />
	* **E - Diferencia de Archetype y Artifact.** - El archetype es la plantilla que creará toda la carpeta del proyecto dependiendo el tipo que se le indicó, y el artifact en sí es el proyecto (todo lo que integra la carpeta main del proyecto), a este último se le tiene que poner un identificador. <br /> <hr />
	
* Spring: <br />
	* Explique los 4 stereotypes basicos y realice un diagrama de cada uno de ellos . (@Component, @Repository, @Service, @Controller). <br />
		* **- @Component:** Es el estereotipo general y permite anotar un bean para que Spring lo considere uno de sus objetos. <br />
    	![Imagen Diagrama @Component](https://www.arquitecturajava.com/wp-content/uploads/SpringStereotypes.png) <br />
		* **- @Repository:** Es el estereotipo que se encarga de dar de alta un bean para que implemente el patrón repositorio que es el encargado de almacenar datos en una base de datos o repositorio de información que se necesite. <br />
    	![Imagen Diagrama @Repository](https://www.arquitecturajava.com/wp-content/uploads/SpringStereotypesRepository.png) <br />
		* **- @Service:** Este estereotipo se encarga de gestionar las operaciones de negocio más importantes a nivel de la aplicación y aglutina llamadas a varios repositorios de forma simultánea. Su tarea es ser el intermediario del @Controller y del @Repository. <br />
    	![Imagen Diagrama @Service](https://www.arquitecturajava.com/wp-content/uploads/SpringStereotypesService.png) <br />
		* **- @Controller:** El último de los estereotipos que es el que realiza las tareas de controlador y gestión de la comunicación entre el usuario y el aplicativo. Es el encargado de realizar las acciones que realiza el usuario en la aplicación. <br />
    	![Imagen Diagrama @Controller](https://www.arquitecturajava.com/wp-content/uploads/SpringStereotypesController.png) <br /> <hr /> 

* REST: <br />
	* Explique cada uno de los verbos.
