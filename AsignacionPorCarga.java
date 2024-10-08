import java.util.List;

public class AsignacionPorCarga implements EstrategiaAsignacionTareas {
    @Override
    public void asignarTarea(Tarea tarea, List<Empleado> empleados) {
        if (!empleados.isEmpty()) {
            Empleado empleadoConMenosTareas = empleados.get(0);  // Inicializar con el primer empleado

            // Buscar el empleado con menos tareas
            for (Empleado empleado : empleados) {
                if (empleado.getCantidadTareas() < empleadoConMenosTareas.getCantidadTareas()) {
                    empleadoConMenosTareas = empleado;
                }
            }

            // Asignar la tarea al empleado con menos tareas
            empleadoConMenosTareas.asignarTarea(tarea);  // Asignar tarea al empleado
            tarea.asignarEmpleado(empleadoConMenosTareas);  // Asignar el empleado a la tarea
            System.out.println("Tarea asignada a " + empleadoConMenosTareas.getNombre());
        } else {
            System.out.println("No hay empleados disponibles.");
        }
    }
}
