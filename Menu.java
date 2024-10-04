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
            System.out.println("6. Salir");
            System.out.print("Elegi una opcion flaquito: ");
            int opcion = scanner.nextInt();

            switch (opcion){
                //caso 1 agregar proyecto
                case 1:
                    System.out.print("Nombre del proyecto: ");
                    String nombreProyecto = scanner.next();
                    System.out.print("Descripcion: ");
                    String descripcion = scanner.next();
                    Cliente cliente = new Cliente("El bicho","bichito@gmail.com");
                    Empleado gerente = FabricaDeEmpleados.crearEmpleado("Desarrollador","Messi");
                    Proyecto proyecto = new Proyecto(nombreProyecto, descripcion, cliente, gerente, new AsignacionAleatoria());
                    gestor.agregarProyecto(proyecto);
                    System.out.println("Proyecto agregado.");
                    break;

                    //caso 2 agregar un empleadito
                case 2:
                    System.out.print("Nombre del empleado: ");
                    String nombreEmpleado = scanner.next();
                    System.out.print("Rol (Desarrollador/Tester): ");
                    String tipoEmpleado = scanner.next();
                    Empleado empleado = FabricaDeEmpleados.crearEmpleado(tipoEmpleado, nombreEmpleado);
                    gestor.agregarEmpleado(empleado);
                    System.out.println("Empleado agregado.");
                    break;

                case 3:
                    // para que el empleado agarre un laburo honesto
                    System.out.println("Lista de proyectos:");
                    for (int i = 0; i < gestor.getProyectos().size(); i++) {
                        System.out.println((i + 1) + ". " + gestor.getProyectos().get(i).getNombre());
                    }
                    System.out.print("Selecciona un proyecto: ");
                    int proyectoIndex = scanner.nextInt() - 1;

                    System.out.println("Lista de empleados:");
                    for (int i = 0; i < gestor.getEmpleados().size(); i++) {
                        System.out.println((i + 1) + ". " + gestor.getEmpleados().get(i).getNombre() + " - " + gestor.getEmpleados().get(i).getRol());
                    }
                    System.out.print("Selecciona un empleado: ");
                    int empleadoIndex = scanner.nextInt() - 1;

                    Proyecto proyectoSeleccionado = gestor.getProyectos().get(proyectoIndex);
                    Empleado empleadoSeleccionado = gestor.getEmpleados().get(empleadoIndex);

                    proyectoSeleccionado.asignarEmpleado(empleadoSeleccionado);
                    System.out.println("Empleado " + empleadoSeleccionado.getNombre() + " asignado al proyecto " + proyectoSeleccionado.getNombre() + ".");
                    break;

                case 4:
                    // y aca que el empleado vaya a laburar
                    System.out.println("Lista de proyectos:");
                    for (int i = 0; i < gestor.getProyectos().size(); i++) {
                        System.out.println((i + 1) + ". " + gestor.getProyectos().get(i).getNombre());
                    }
                    System.out.print("Selecciona un proyecto: ");
                    proyectoIndex = scanner.nextInt() - 1;

                    proyectoSeleccionado = gestor.getProyectos().get(proyectoIndex);

                    System.out.print("Nombre de la tarea: ");
                    String nombreTarea = scanner.next();

                    Tarea tarea = new Tarea(nombreTarea);
                    proyectoSeleccionado.agregarTarea(tarea);
                    proyectoSeleccionado.asignarTarea(tarea);
                    System.out.println("Tarea asignada exitosamente.");
                    break;

                case 5:
                    // print del resumen del proyecto (?
                    System.out.println("Lista de proyectos:");
                    for (int i = 0; i < gestor.getProyectos().size(); i++) {
                        System.out.println((i + 1) + ". " + gestor.getProyectos().get(i).getNombre());
                    }
                    System.out.print("Selecciona un proyecto: ");
                    proyectoIndex = scanner.nextInt() - 1;

                    proyectoSeleccionado = gestor.getProyectos().get(proyectoIndex);
                    System.out.println(proyectoSeleccionado.mostrarResumen());
                    break;

                case 6:
                    // pa salir
                    System.out.println("Saliendo...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opción no válida.");

            }




        }
    }
}
