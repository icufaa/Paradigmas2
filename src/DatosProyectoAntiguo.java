// Este es el formato antiguo de los datos del proyecto
public class DatosProyectoAntiguo {
    private String nombreViejo;
    private String descripcionVieja;
    private String clienteViejo;

    public DatosProyectoAntiguo(String nombreViejo, String descripcionVieja, String clienteViejo) {
        this.nombreViejo = nombreViejo;
        this.descripcionVieja = descripcionVieja;
        this.clienteViejo = clienteViejo;
    }

    public String getNombreViejo() {
        return nombreViejo;
    }

    public String getDescripcionVieja() {
        return descripcionVieja;
    }

    public String getClienteViejo() {
        return clienteViejo;
    }
}
