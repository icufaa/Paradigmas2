## Gestión de Proyectos y Empleados
Este proyecto en Java implementa un sistema de gestión de proyectos y empleados. Utiliza varios patrones de diseño, como el Singleton, Factory Method, Adapter, Observer, y Strategy, para administrar las interacciones entre proyectos, empleados y tareas de manera eficiente. El sistema permite agregar empleados, asignarlos a proyectos y gestionar las diferentes relaciones entre ellos.

# Funcionalidades Principales
- Agregar Empleados:

Permite añadir empleados al sistema mediante una fábrica que crea objetos de tipo Empleado, según el rol especificado (Desarrollador o Tester).
Se implementa un manejo de errores que garantiza que el tipo de empleado sea válido, y se guía al usuario en caso de que ocurra un error.
- Asignar Empleados a Proyectos:

Muestra una lista de proyectos y permite al usuario seleccionar uno.
Muestra una lista de empleados y permite asignar un empleado al proyecto seleccionado.
El sistema maneja posibles errores, como índices fuera de rango o entradas no válidas, sin reiniciar el flujo, lo que permite al usuario corregir el error y continuar.
- Manejo de Excepciones:
Uso de bloques try-catch para manejar errores de entrada y selección, asegurando que el programa sea robusto frente a entradas incorrectas o fuera de rango.
Captura de errores comunes como IndexOutOfBoundsException e InputMismatchException, brindando mensajes de error descriptivos y permitiendo que el usuario vuelva a intentarlo sin perder el progreso.
Patrones de Diseño Implementados
.Singleton: Garantiza que solo exista una instancia del gestor que maneja empleados y proyectos en todo el sistema.
.Factory Method: Simplifica la creación de objetos Empleado según el tipo de rol, permitiendo escalabilidad para futuros roles o empleados especializados.
.Adapter: Facilita la interacción entre diferentes clases que manejan empleados y proyectos, adaptando interfaces cuando es necesario.
.Observer: Permite que las clases de proyecto se mantengan actualizadas sobre los cambios en los empleados asignados.
.Strategy: Define diferentes estrategias para la asignación de empleados a proyectos o para la organización de tareas dentro de los proyectos.


# Ejecución
Clona el repositorio:
git clone https://github.com/usuario/gestor-proyectos-empleados.git


