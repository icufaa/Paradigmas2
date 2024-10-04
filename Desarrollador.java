public class Desarrollador extends Empleado{
    public Desarrollador(String nombre){
        super(nombre,"Desarrollador");
    }

    @Override
    public void actualizar(Tarea tarea) {
        System.out.println("Desarrollador " + getNombre() + " ha sido notificado del cambio de estado de la tarea: " + tarea.getEstado());
    }
}
