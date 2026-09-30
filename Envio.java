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

    public void agregarPaquete(Paquete paquete) throws Exception {
        if (paquete == null) {
            throw new IllegalArgumentException("No se pueden agregar paquetes nulos");
        }

        if (cabenPaquetes()) {
            paquetes.add(paquete);
        } else {
            throw new IllegalArgumentException("No se pueden agregar más de 3 paquetes.");
        }
    }

    public boolean estaSinPaquetes() {
        return paquetes.isEmpty();
    }

    public void iniciarEnvio() {
        if (paquetes.isEmpty()) {
            throw new IllegalStateException("No se puede enviar un envío sin paquetes");
        }

        for (Paquete paquete : paquetes) {
            if (paquete.getEstado() != EstadoPaquete.RECIBIDO) {
                throw new IllegalStateException("Todos los paquetes deben estar recibidos para ser enviados");
            }
            paquete.preparar();
            paquete.enviarDistribucion();
        }

        reg.registrarPreparacion();
    }

    public void finalizarEnvio() {
        if (paquetes.isEmpty()) {
            throw new IllegalStateException("No se puede finalizar un envío sin paquetes");
        }

        for (Paquete paquete : paquetes) {
            if (paquete.getEstado() != EstadoPaquete.EN_DISTRIBUCION) {
                throw new IllegalStateException("Todos los paquetes deben estar en distribución para ser entregados");
            }
            paquete.entregar();
        }

        reg.registrarEntrega();
    }

    public void recibirseEnSucursal(Sucursal sucursal) {
        reg.registrarReciboSucursal(sucursal);
    }

    public void despacharseDeSucursal(Sucursal sucursal) {
        reg.registrarDespachoSucursal(sucursal);
    }

    public Sucursal getSucursalActual() {
        ArrayList<Movimiento> registro = reg.getRegistro();

        for (int i = registro.size() - 1; i >= 0; i--) {
            Movimiento mov = registro.get(i);

            if (mov.getTipo() == TipoMovimiento.RECIBIDO_EN_SUCURSAL)
                return mov.getSucursal();
            else if (mov.getTipo() != TipoMovimiento.EN_PREPARACION)
                return null;
        }

        return null;
    }

    public boolean estaEnSucursal(Sucursal sucursal) {
        return getSucursalActual() == sucursal;
    }

    public boolean estaEntregado() {
        if (paquetes.isEmpty())
            return false;

        for (Paquete paq : paquetes) {
            if (paq.getEstado() != EstadoPaquete.ENTREGADO)
                return false;
        }

        return true;
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
