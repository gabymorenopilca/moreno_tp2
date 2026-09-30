import java.util.ArrayList;

public class Sucursal {
    private int id;
    private String localidad;
    private ArrayList<Envio> envios;

    public Sucursal(int id, String localidad) {
        this.id = id;
        this.localidad = localidad;
        this.envios = new ArrayList<Envio>();
    }

    public void recibirEnvio(Envio envio) {
        if (envio == null) {
            throw new IllegalArgumentException("El paquete no puede ser nulo");
        }

        if (envio.estaSinPaquetes()) {
            throw new IllegalArgumentException("No se pueden recibir paquetes vacíos");
        }

        if (envio.estaEntregado()) {
            throw new IllegalArgumentException("No se puede recibir un envío ya entregado");
        }

        if (envio.getSucursalActual() != null) {
            throw new IllegalArgumentException("El envío todavía se encuentra en otra sucursal");
        }

        if (envios.contains(envio)) {
            throw new IllegalArgumentException("El envío ya existe en esta sucursal");
        }

        envio.recibirseEnSucursal(this);
        envios.add(envio);
    }

    public Envio despacharEnvio() {
        if (envios.isEmpty()) {
            throw new IllegalStateException("No hay envíos para despachar");
        }

        Envio despachado = envios.remove(envios.size() - 1);

        despachado.despacharseDeSucursal(this);

        return despachado;
    }

    public String getLocalidad() {
        return localidad;
    }
}
