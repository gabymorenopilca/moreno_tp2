import java.util.ArrayList;

public class Envio {
    protected int numeroEnvio;
    protected ArrayList<Paquete> paquetes;
    protected RegistroSeguimiento reg;

    public Envio(int numeroEnvio) {
        this.numeroEnvio = numeroEnvio;
        this.paquetes = new ArrayList<Paquete>();
        this.reg = new RegistroSeguimiento();
    }

    public Envio(int numeroEnvio, ArrayList<Paquete> paquetes) {
        this.numeroEnvio = numeroEnvio;
        this.paquetes = paquetes;
        this.reg = new RegistroSeguimiento();
    }

    protected boolean cabenPaquetes() {
        return paquetes.size() < 3;
    }

    public void agregarPaquete(Paquete paquete) {
        if (cabenPaquetes()) {
            paquetes.add(paquete);
        } else {
            throw new Exception("No se pueden agregar más de 3 paquetes.");
        }
    }

    public void iniciarEnvio() {
        for (Paquete paquete : paquetes) {
            paquete.preparar();
            paquete.enviarDistribucion();
        }

        reg.registrarPreparacion();
    }

    public void finalizarEnvio() {
        for (Paquete paquete : paquetes) {
            paquete.entregar();
        }

        reg.registrarEntrega();
    }

    public void recibirseEnSucursal(String nombreSucursal) {
        reg.registrarReciboSucursal(nombreSucursal);
    }

    public void despacharseDeSucursal(String nombreSucursal) {
        reg.registrarDespachoSucursal(nombreSucursal);
    }

    public double calcularCosto() {
        return obtenerPesoTotal()*100;
    }

    protected double obtenerPesoTotal() {
        double peso = 0;

        for (Paquete paq : paquetes) {
            peso += paq.getPeso();
        }

        return peso;
    }

    public void mostrarInformacion() {
        System.out.println("ENVÍO N° " + numeroEnvio);

        for (Paquete paq : paquetes) {
            System.out.println(paq);
        }

        System.out.println("Costo: $" + calcularCosto());
        System.out.println();
    }

    public void mostrarHistorial() {
        reg.mostrar();
    }
}
