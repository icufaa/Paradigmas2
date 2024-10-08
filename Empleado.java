import java.util.ArrayList;
import java.util.List;

public abstract class Empleado {
    private String nombre;
    private String rol;
    private List<Tarea> tareasAsignadas;

    public Empleado(String nombre, String rol) {
        this.nombre = nombre;
        this.rol = rol;
        this.tareasAsignadas = new ArrayList<>(); // Nueva lista para las tareas asignadas
    }

    public String getNombre() {
        return nombre;
    }

    public String getRol() {
        return rol;
    }

    public List<Tarea> getTareasAsignadas() {
        return tareasAsignadas;
    }

    public void asignarTarea(Tarea tarea) {
        tareasAsignadas.add(tarea);
        // No notificar aquí, dejémoslo para que la tarea lo maneje
    }


    public int getCantidadTareas() {
        return tareasAsignadas.size();
    }

    public abstract void actualizar(Tarea tarea);
}
