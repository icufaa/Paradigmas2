public class Tester extends Empleado{
    public Tester(String nombre){
        super(nombre,"Tester");
    }

    @Override
    public void actualizar(Tarea tarea) {
        System.out.println("Tester " + getNombre() + " ha sido notificado de que la tarea '" + tarea.getNombre() + "' ha cambiado de estado a " + tarea.getEstado());

    }
}
