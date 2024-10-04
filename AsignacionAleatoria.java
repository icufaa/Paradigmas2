import java.util.List;

public class AsignacionAleatoria implements EstrategiaAsignacionTareas {
    @Override
    public void asignarTarea(Tarea tarea, List<Empleado> empleados) {
        // Lógica para asignar la tarea de forma aleatoria
        if (!empleados.isEmpty()) {
            int index = (int) (Math.random() * empleados.size());
            tarea.asignarEmpleado(empleados.get(index));
            System.out.println("Tarea asignada a " + empleados.get(index).getNombre());
        }
    }
}
