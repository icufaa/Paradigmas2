public class Desarrollador extends Empleado {
    public Desarrollador(String nombre) {
        super(nombre, "Desarrollador");
    }

    @Override
    public void actualizar(Tarea tarea) {
        System.out.println("Desarrollador " + getNombre() + " ha sido notificado de que la tarea '" + tarea.getNombre() + "' ha cambiado de estado a " + tarea.getEstado());
        // Asegúrate de no cambiar el estado aquí para evitar ciclos
    }
}
