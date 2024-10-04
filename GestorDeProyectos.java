import java.util.ArrayList;

public class GestorDeProyectos {
    private static GestorDeProyectos instancia;
    private ArrayList<Proyecto> proyectos;
    private ArrayList<Empleado> empleados;

    private GestorDeProyectos(){
        proyectos = new ArrayList<>();
        empleados = new ArrayList<>();
    }

    public static GestorDeProyectos getInstancia(){
        if (instancia == null){
            instancia = new GestorDeProyectos();
        }
        return instancia;
    }

    public void agregarProyecto(Proyecto proyecto){
        proyectos.add(proyecto);
    }

    public void agregarEmpleado(Empleado empleado){
        empleados.add(empleado);
    }

    public ArrayList<Empleado> getEmpleados(){
        return empleados;
    }

    public ArrayList<Proyecto> getProyectos(){
        return proyectos;
    }
}
