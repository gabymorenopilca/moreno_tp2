import java.util.ArrayList;

public class Cliente {
    private int id;
    private String nombre;
    private String direccion;
    private ArrayList<Envio> envios;

    public Cliente(int id, String nombre, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.envios = new ArrayList<Envio>();
    }

    public void asignarEnvio(Envio envio) {
        envios.add(envio);
    }

    public void mostrarInformacion() {
        System.out.println("Cliente: " + nombre + " (" + id + ")\nDirección: " + direccion + "\nEnvíos:");

        for (Envio envio : envios) {
            envio.mostrarInformacion();
        }
    }
}
