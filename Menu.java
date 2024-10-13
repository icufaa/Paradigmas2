import java.util.Scanner;

public class Menu {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        GestorDeProyectos gestor = GestorDeProyectos.getInstancia();

        while (true){
            System.out.println("\nMenu:");
            System.out.println("1. Agregar Proyecto");
            System.out.println("2. Agregar Empleado");
            System.out.println("3. Asignar Empleado a Proyecto");
            System.out.println("4. Asignar Tarea a Empleado");
            System.out.println("5. Mostrar Resumen de Proyecto");
            System.out.println("6. Cambiar Estado de una Tarea");
            System.out.println("7. Simular Notificaciones de Tareas");
            System.out.println("8. Salir");
            System.out.print("Elegi una opcion: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion){
                // Agregar proyecto
                case 1:
                    System.out.print("Nombre del proyecto: ");
                    String nombreProyecto = scanner.nextLine();
                    System.out.print("Descripción: ");
                    String descripcion = scanner.nextLine();
                    Cliente cliente = new Cliente("El bicho","bichito@gmail.com");
                    Empleado gerente = FabricaDeEmpleados.crearEmpleado("Desarrollador","Messi");
                    Proyecto proyecto = new Proyecto(nombreProyecto, descripcion, cliente, gerente, new AsignacionAleatoria());
                    gestor.agregarProyecto(proyecto);
                    System.out.println("Proyecto agregado.");
                    break;

                // Agregar empleado
                case 2:
                    System.out.print("Nombre del empleado: ");
                    String nombreEmpleado = scanner.nextLine();
                    System.out.print("Rol (Desarrollador/Tester): ");
                    String tipoEmpleado = scanner.nextLine();
                    Empleado empleado = FabricaDeEmpleados.crearEmpleado(tipoEmpleado, nombreEmpleado);
                    gestor.agregarEmpleado(empleado);
                    System.out.println("Empleado agregado.");
                    break;

                // Asignar empleado a proyecto
                case 3:
                    System.out.println("Lista de proyectos:");
                    for (int i = 0; i < gestor.getProyectos().size(); i++) {
                        System.out.println((i + 1) + ". " + gestor.getProyectos().get(i).getNombre());
                    }
                    System.out.print("Selecciona un proyecto: ");
                    int proyectoIndex = scanner.nextInt() - 1;
                    scanner.nextLine();

                    System.out.println("Lista de empleados:");
                    for (int i = 0; i < gestor.getEmpleados().size(); i++) {
                        System.out.println((i + 1) + ". " + gestor.getEmpleados().get(i).getNombre() + " - " + gestor.getEmpleados().get(i).getRol());
                    }
                    System.out.print("Selecciona un empleado: ");
                    int empleadoIndex = scanner.nextInt() - 1;
                    scanner.nextLine();

                    Proyecto proyectoSeleccionado = gestor.getProyectos().get(proyectoIndex);
                    Empleado empleadoSeleccionado = gestor.getEmpleados().get(empleadoIndex);

                    proyectoSeleccionado.asignarEmpleado(empleadoSeleccionado);
                    System.out.println("Empleado " + empleadoSeleccionado.getNombre() + " asignado al proyecto " + proyectoSeleccionado.getNombre() + ".");
                    break;

                // Asignar tarea a empleado
                case 4:
                    System.out.println("Lista de proyectos:");
                    for (int i = 0; i < gestor.getProyectos().size(); i++) {
                        System.out.println((i + 1) + ". " + gestor.getProyectos().get(i).getNombre());
                    }
                    System.out.print("Selecciona un proyecto: ");
                    proyectoIndex = scanner.nextInt() - 1;
                    scanner.nextLine();

                    proyectoSeleccionado = gestor.getProyectos().get(proyectoIndex);

                    System.out.print("Nombre de la tarea: ");
                    String nombreTarea = scanner.nextLine();

                    Tarea tarea = new Tarea(nombreTarea);
                    proyectoSeleccionado.agregarTarea(tarea);
                    proyectoSeleccionado.asignarTarea(tarea);
                    System.out.println("Tarea '" + tarea.getNombre() + "' asignada exitosamente.");
                    break;

                // Mostrar resumen del proyecto
                case 5:
                    System.out.println("Lista de proyectos:");
                    for (int i = 0; i < gestor.getProyectos().size(); i++) {
                        System.out.println((i + 1) + ". " + gestor.getProyectos().get(i).getNombre());
                    }
                    System.out.print("Selecciona un proyecto: ");
                    proyectoIndex = scanner.nextInt() - 1;
                    scanner.nextLine(); //

                    proyectoSeleccionado = gestor.getProyectos().get(proyectoIndex);
                    System.out.println(proyectoSeleccionado.mostrarResumen());
                    break;

                case 6:
                    // va a verificar si hay proyectos pendientes
                    if (gestor.getProyectos().isEmpty()) {
                        System.out.println("No hay proyectos disponibles.");
                        break;
                    }

                    System.out.println("Lista de proyectos:");
                    for (int i = 0; i < gestor.getProyectos().size(); i++) {
                        System.out.println((i + 1) + ". " + gestor.getProyectos().get(i).getNombre());
                    }
                    System.out.print("Selecciona un proyecto: ");


                    proyectoIndex = scanner.nextInt() - 1;
                    scanner.nextLine();

                    // Validar el índice de proyecto
                    if (proyectoIndex < 0 || proyectoIndex >= gestor.getProyectos().size()) {
                        System.out.println("Índice de proyecto no válido.");
                        break;
                    }

                    // esto porque me daba problemas con la variable al igual que con proyectoIndex, queseyo
                    proyectoSeleccionado = gestor.getProyectos().get(proyectoIndex);

                    // Verifica si hay tareas en el proyecto
                    if (proyectoSeleccionado.getTareas().isEmpty()) {
                        System.out.println("No hay tareas en este proyecto.");
                        break;
                    }

                    // print de listas de tareas
                    System.out.println("Tareas del proyecto:");
                    for (int i = 0; i < proyectoSeleccionado.getTareas().size(); i++) {
                        System.out.println((i + 1) + ". " + proyectoSeleccionado.getTareas().get(i).getNombre() + " (" + proyectoSeleccionado.getTareas().get(i).getEstado() + ")");
                    }
                    System.out.print("Selecciona una tarea: ");
                    int tareaIndex = scanner.nextInt() - 1;
                    scanner.nextLine();

                    // indice de la tarea, para que no haya desbordamientos
                    if (tareaIndex < 0 || tareaIndex >= proyectoSeleccionado.getTareas().size()) {
                        System.out.println("Índice de tarea no válido.");
                        break;
                    }

                    Tarea tareaSeleccionada = proyectoSeleccionado.getTareas().get(tareaIndex);

                    // estados de la tarea
                    System.out.println("Selecciona el nuevo estado:");
                    System.out.println("1. PENDIENTE");
                    System.out.println("2. EN_CURSO");
                    System.out.println("3. FINALIZADA");
                    int estadoSeleccionado = scanner.nextInt();
                    scanner.nextLine();

                    // cambio de la tarea
                    switch (estadoSeleccionado) {
                        case 1:
                            tareaSeleccionada.setEstado(Tarea.EstadoTarea.PENDIENTE);
                            break;
                        case 2:
                            tareaSeleccionada.setEstado(Tarea.EstadoTarea.EN_CURSO);
                            break;
                        case 3:
                            tareaSeleccionada.setEstado(Tarea.EstadoTarea.FINALIZADA);
                            break;
                        default:
                            System.out.println("Estado no válido.");
                            break;
                    }

                    System.out.println("El estado de la tarea '" + tareaSeleccionada.getNombre() + "' ha sido cambiado a " + tareaSeleccionada.getEstado());
                    break;


                //Simular notificaciones
                case 7:
                    System.out.println("Simulando notificaciones de tareas a los empleados...");
                    for (Empleado emp : gestor.getEmpleados()) {
                        for (Tarea t : emp.getTareasAsignadas()) {
                            emp.actualizar(t);
                        }
                    }
                    System.out.println("Notificaciones enviadas.");
                    break;

                // Salir
                case 8:
                    System.out.println("Saliendo...");
                    scanner.close();
                    return;

                // error
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}
