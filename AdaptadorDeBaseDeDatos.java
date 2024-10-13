public class AdaptadorDeBaseDeDatos {
    private BaseDeDatosAntigua baseDeDatosAntigua;

    public AdaptadorDeBaseDeDatos(BaseDeDatosAntigua baseDeDatosAntigua) {
        this.baseDeDatosAntigua = baseDeDatosAntigua;
    }

    // Metodo que adapta los datos antiguos a los actuales
    public Proyecto obtenerProyectoAdaptado(String id) {
        // Obtener datos en el formato antiguo
        DatosProyectoAntiguo datosAntiguos = baseDeDatosAntigua.obtenerProyectoAntiguo(id);

        // Convertir datos antiguos a datos compatibles con el sistema moderno
        String nombre = datosAntiguos.getNombreViejo();
        String descripcion = datosAntiguos.getDescripcionVieja();
        Cliente cliente = new Cliente(datosAntiguos.getClienteViejo(), "cliente@viejo.com");

        // Creo un gerente random
        Empleado gerente = FabricaDeEmpleados.crearEmpleado("Desarrollador", "Gerente Antiguo");

        return new Proyecto(nombre, descripcion, cliente, gerente, new AsignacionAleatoria());
    }
}
