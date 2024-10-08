import java.util.Scanner;

public class Menu {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        GestorDeProyectos gestor = GestorDeProyectos.getInstancia();

        while (true){
            System.out.println("\nMenú:");
            System.out.println("1. Agregar Proyecto");
            System.out.println("2. Agregar Empleado");
            System.out.println("3. Asignar Empleado a Proyecto");
            System.out.println("4. Asignar Tarea a Empleado");
            System.out.println("5. Mostrar Resumen de Proyecto");
            System.out.println("6. Simular Notificaciones de Tareas");
            System.out.println("7. Salir");
            System.out.print("Elegi una opcion flaquito: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea que queda después de nextInt()

            switch (opcion){
                // Caso 1: Agregar proyecto
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

                // Caso 2: Agregar empleado
                case 2:
                    System.out.print("Nombre del empleado: ");
                    String nombreEmpleado = scanner.nextLine();
                    System.out.print("Rol (Desarrollador/Tester): ");
                    String tipoEmpleado = scanner.nextLine();
                    Empleado empleado = FabricaDeEmpleados.crearEmpleado(tipoEmpleado, nombreEmpleado);
                    gestor.agregarEmpleado(empleado);
                    System.out.println("Empleado agregado.");
                    break;

                // Caso 3: Asignar empleado a proyecto
                case 3:
                    System.out.println("Lista de proyectos:");
                    for (int i = 0; i < gestor.getProyectos().size(); i++) {
                        System.out.println((i + 1) + ". " + gestor.getProyectos().get(i).getNombre());
                    }
                    System.out.print("Selecciona un proyecto: ");
                    int proyectoIndex = scanner.nextInt() - 1;
                    scanner.nextLine(); // Consumir la nueva línea

                    System.out.println("Lista de empleados:");
                    for (int i = 0; i < gestor.getEmpleados().size(); i++) {
                        System.out.println((i + 1) + ". " + gestor.getEmpleados().get(i).getNombre() + " - " + gestor.getEmpleados().get(i).getRol());
                    }
                    System.out.print("Selecciona un empleado: ");
                    int empleadoIndex = scanner.nextInt() - 1;
                    scanner.nextLine(); // Consumir la nueva línea

                    Proyecto proyectoSeleccionado = gestor.getProyectos().get(proyectoIndex);
                    Empleado empleadoSeleccionado = gestor.getEmpleados().get(empleadoIndex);

                    proyectoSeleccionado.asignarEmpleado(empleadoSeleccionado);
                    System.out.println("Empleado " + empleadoSeleccionado.getNombre() + " asignado al proyecto " + proyectoSeleccionado.getNombre() + ".");
                    break;

                // Caso 4: Asignar tarea a empleado
                case 4:
                    System.out.println("Lista de proyectos:");
                    for (int i = 0; i < gestor.getProyectos().size(); i++) {
                        System.out.println((i + 1) + ". " + gestor.getProyectos().get(i).getNombre());
                    }
                    System.out.print("Selecciona un proyecto: ");
                    proyectoIndex = scanner.nextInt() - 1;
                    scanner.nextLine(); // Consumir la nueva línea

                    proyectoSeleccionado = gestor.getProyectos().get(proyectoIndex);

                    System.out.print("Nombre de la tarea: ");
                    String nombreTarea = scanner.nextLine();

                    Tarea tarea = new Tarea(nombreTarea);
                    proyectoSeleccionado.agregarTarea(tarea);
                    proyectoSeleccionado.asignarTarea(tarea);
                    System.out.println("Tarea '" + tarea.getNombre() + "' asignada exitosamente.");
                    break;

                // Caso 5: Mostrar resumen del proyecto
                case 5:
                    System.out.println("Lista de proyectos:");
                    for (int i = 0; i < gestor.getProyectos().size(); i++) {
                        System.out.println((i + 1) + ". " + gestor.getProyectos().get(i).getNombre());
                    }
                    System.out.print("Selecciona un proyecto: ");
                    proyectoIndex = scanner.nextInt() - 1;
                    scanner.nextLine(); // Consumir la nueva línea

                    proyectoSeleccionado = gestor.getProyectos().get(proyectoIndex);
                    System.out.println(proyectoSeleccionado.mostrarResumen());
                    break;

                // Caso 6: Simular notificaciones
                case 6:
                    System.out.println("Simulando notificaciones de tareas a los empleados...");
                    for (Empleado emp : gestor.getEmpleados()) {
                        for (Tarea t : emp.getTareasAsignadas()) {
                            emp.actualizar(t);
                        }
                    }
                    System.out.println("Notificaciones enviadas.");
                    break;

                // Caso 7: Salir del menú
                case 7:
                    System.out.println("Saliendo...");
                    scanner.close();
                    return;

                // Default
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}
