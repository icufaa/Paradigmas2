import java.util.List;

public class AsignacionPorCarga implements EstrategiaAsignacionTareas {
    @Override
    public void asignarTarea(Tarea tarea, List<Empleado> empleados) {
        if (!empleados.isEmpty()) {
            Empleado empleadoConMenosTareas = empleados.get(0); // aca elige el primer empleado

            // Buscar el empleado con menos tareas
            for (Empleado empleado : empleados) {
                if (empleado.getCantidadTareas() < empleadoConMenosTareas.getCantidadTareas()) {
                    empleadoConMenosTareas = empleado;
                }
            }

            // Asignar la tarea al empleado que menos esta laburando
            empleadoConMenosTareas.asignarTarea(tarea);
            tarea.asignarEmpleado(empleadoConMenosTareas); 
            System.out.println("Tarea asignada a " + empleadoConMenosTareas.getNombre());
        } else {
            System.out.println("No hay empleados disponibles.");
        }
    }
}
