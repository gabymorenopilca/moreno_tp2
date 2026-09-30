public class Paquete {
    private int id;
    private String descripcion;
    private double peso;
    private String destinatario;
    private EstadoPaquete estado;

    public Paquete(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
        this.estado = EstadoPaquete.RECIBIDO;
    }

    public Paquete(int id, String descripcion, double peso, String destinatario) {
        this.id = id;
        this.descripcion = descripcion;
        this.peso = peso;
        this.destinatario = destinatario;
        this.estado = EstadoPaquete.RECIBIDO;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPeso() {
        return peso;
    }

    public EstadoPaquete getEstado() {
        return estado;
    }

    public void preparar() {
        if (estado == EstadoPaquete.RECIBIDO) {
            estado = EstadoPaquete.EN_PREPARACION;
        } else {
            throw new IllegalStateException("El paquete " + id + " debe estar recibido para ser preparado");
        }
    }

    public void enviarDistribucion() {
        if (estado == EstadoPaquete.EN_PREPARACION) {
            estado = EstadoPaquete.EN_DISTRIBUCION;
        } else {
            throw new IllegalStateException("El paquete " + id + " no se puede distribuir porque no está preparado");
        }
    }

    public void entregar() {
        if (estado == EstadoPaquete.EN_DISTRIBUCION) {
            estado = EstadoPaquete.ENTREGADO;
        } else {
            throw new IllegalStateException("El paquete " + id + " no se puede entregar porque no está en distribución");
        }
    }

    public String toString() {
        return "Paquete{id=" + id + ", descripcion='" + descripcion + "', peso=" + peso + ", destinatario='" + destinatario + "', estado=" + estado + "}";
    }
}
