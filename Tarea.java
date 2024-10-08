public class Tarea {
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

    public String getNombre() {
        return nombre;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    // Este es el método que debes verificar o agregar
    public void asignarEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    private void notificarEmpleado() {
        if (empleado != null) {
            empleado.actualizar(this);
        }
    }
}
