public class Tester extends Empleado{
    public Tester(String nombre){
        super(nombre,"Tester");
    }

    @Override
    public void actualizar(Tarea tarea) {
        System.out.println("Desarrollador " + getNombre() + " ha sido notificado de que la tarea '"
                + tarea.getNombre() + "' ha cambiado su estado a: " + tarea.getEstado());
    }
}
