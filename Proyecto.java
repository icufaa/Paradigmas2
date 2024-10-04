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
        empleados.add(empleado);
    }


    public void agregarTarea(Tarea tarea) {
        tareas.add(tarea);
    }


    public void asignarTarea(Tarea tarea) {
        estrategia.asignarTarea(tarea, empleados);
    }

    // esto va a mostrar un resumen del estado del proyecto
    public String mostrarResumen() {
        int tareasPendientes = 0, tareasEnCurso = 0, tareasFinalizadas = 0;

        // Para ver todaas las tareas y en que estado estan
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

    // pa mostrar el nombre del proyecto
    public String getNombre() {
        return nombre;
    }
}
