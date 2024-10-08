public class Desarrollador extends Empleado{
    public Desarrollador(String nombre){
        super(nombre,"Desarrollador");
    }

    @Override
    public void actualizar(Tarea tarea) {
        System.out.println("Desarrollador " + getNombre() + " ha sido notificado de que la tarea '"
                + tarea.getNombre() + "' ha cambiado su estado a: " + tarea.getEstado());
    }
}
