import java.util.ArrayList;

public class Proyecto {
    private String nombre;
    private String descripcion;
    private Empleado gerente;
    private Cliente cliente;
    private ArrayList<Empleado> empleados;
    private ArrayList<Tarea> tareas;
    private EstrategiaAsignacionTareas estrategia;

    public Proyecto(String nombre, String descripcion, Cliente cliente, Empleado gerente, EstrategiaAsignacionTareas estrategia) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cliente = cliente;
        this.gerente = gerente;
        this.empleados = new ArrayList<>();
        this.tareas = new ArrayList<>();
        this.estrategia = estrategia;
    }

    public void asignarEmpleado(Empleado empleado) {
        if (!empleados.contains(empleado)) { // Evitar duplicados
            empleados.add(empleado);
        }
    }

    public void agregarTarea(Tarea tarea) {
        if (!tareas.contains(tarea)) { // Evitar duplicados
            tareas.add(tarea);
        }
    }

    public void asignarTarea(Tarea tarea) {
        if (tareas.contains(tarea)) { // Solo asignar si la tarea ya está en la lista
            estrategia.asignarTarea(tarea, empleados);
        } else {
            System.out.println("La tarea no está registrada en el proyecto.");
        }
    }

    public ArrayList<Tarea> getTareas() {
        return tareas; // Nuevo método para obtener la lista de tareas
    }

    public String mostrarResumen() {
        int tareasPendientes = 0, tareasEnCurso = 0, tareasFinalizadas = 0;

        for (Tarea tarea : tareas) {
            switch (tarea.getEstado()) {
                case PENDIENTE:
                    tareasPendientes++;
                    break;
                case EN_CURSO:
                    tareasEnCurso++;
                    break;
                case FINALIZADA:
                    tareasFinalizadas++;
                    break;
            }
        }

        return "Resumen de proyecto:\nPendientes: " + tareasPendientes +
                "\nEn curso: " + tareasEnCurso +
                "\nFinalizadas: " + tareasFinalizadas;
    }

    public String getNombre() {
        return nombre;
    }
}
