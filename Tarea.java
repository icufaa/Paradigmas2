public class Tarea {
    // enum para los estados de las tareas, con cadena de caracteres se rompia todo
    public enum EstadoTarea {
        PENDIENTE,
        EN_CURSO,
        FINALIZADA
    }

    private String nombre;
    private EstadoTarea estado;
    private Empleado empleado;

    public Tarea(String nombre) {
        this.nombre = nombre;
        this.estado = EstadoTarea.PENDIENTE;
    }


    public EstadoTarea getEstado() {
        return estado;
    }


    public void setEstado(EstadoTarea estado) {
        this.estado = estado;
        notificarEmpleado();
    }


    public Empleado getEmpleado() {
        return empleado;
    }


    public void asignarEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }


    private void notificarEmpleado() {
        if (empleado != null) {
            empleado.actualizar(this);  // esto creo que tendria que estar en la clase empleado pero bue
        }
    }
}
