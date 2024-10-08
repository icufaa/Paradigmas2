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

        // Crea un gerente de prueba (puedes adaptar esto si tienes datos en la base antigua)
        Empleado gerente = FabricaDeEmpleados.crearEmpleado("Desarrollador", "Gerente Antiguo");

        // Devuelve un objeto Proyecto moderno con los datos adaptados
        return new Proyecto(nombre, descripcion, cliente, gerente, new AsignacionAleatoria());
    }
}
