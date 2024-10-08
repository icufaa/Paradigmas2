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
        if (this.estado != estado) { // Solo notificar si hay un cambio
            this.estado = estado;
            notificarEmpleado(); // Llamamos al metodo para notificar al empleado cuando cambia el estado
        }
    }


    public String getNombre() {
        return nombre;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void asignarEmpleado(Empleado empleado) {
        this.empleado = empleado;
        System.out.println("Tarea '" + nombre + "' asignada a " + empleado.getNombre() + " (" + empleado.getRol() + ").");
        empleado.asignarTarea(this); // Asigna la tarea a la lista de tareas del empleado
    }

    private void notificarEmpleado() {
        if (empleado != null) {
            // Solo notifica si hay un cambio real que reportar
            empleado.actualizar(this);
        }
    }

}
