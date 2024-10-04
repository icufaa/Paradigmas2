import java.util.List;

public class AsignacionPorCarga implements EstrategiaAsignacionTareas {
    @Override
    public void asignarTarea(Tarea tarea,List<Empleado> empleados){
        // esta funcionar es para asignar al empleado con menos tareas
        if(!empleados.isEmpty()){
            tarea.asignarEmpleado((empleados.get(0))); //esto asigna al primer empleado
            System.out.println("Tarea asignada a " + empleados.get(0).getNombre());
        }
    }
}
