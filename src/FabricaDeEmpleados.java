public class FabricaDeEmpleados {
    public static Empleado crearEmpleado(String tipo, String nombre) {
        switch (tipo) {
            case "Desarrollador":
                return new Desarrollador(nombre);
            case "Tester":
                return new Tester(nombre);
            default:
                throw new IllegalArgumentException("Tipo de empleado no valido.");
        }
    }
}
