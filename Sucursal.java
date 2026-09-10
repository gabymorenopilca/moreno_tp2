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
        envio.recibirseEnSucursal(localidad);
        envios.add(envio);
    }

    public Envio despacharEnvio() {
        Envio despachado = envios.get(envios.size() - 1);

        envios.remove(envios.size() - 1);

        despachado.despacharseDeSucursal(localidad);

        return despachado;
    }
}
