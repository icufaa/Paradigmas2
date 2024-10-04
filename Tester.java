public class Tester extends Empleado{
    public Tester(String nombre){
        super(nombre,"Tester");
    }

    @Override
    public void actualizar(Tarea tarea) {
        System.out.println("Tester " + getNombre() + " ha sido notificado del cambio de estado de la tarea: " + tarea.getEstado());
    }
}
