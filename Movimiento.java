import java.util.Date;

public class Movimiento {
    private Date fecha;
    private Sucursal sucursal;
    private TipoMovimiento tipo;

    public Movimiento(Date fecha, Sucursal sucursal, TipoMovimiento tipo) {
        this.fecha = fecha;
        this.sucursal = sucursal;
        this.tipo = tipo;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public TipoMovimiento getTipo() {
        return tipo;
    }

    public String toString() {
        String resultado = "Estado: " + tipo + ", Fecha: " + fecha;
        if (sucursal != null) {
            resultado += ", sucursal: " + sucursal.getLocalidad();
        }

        return resultado;
    }
}
