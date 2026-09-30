import java.util.ArrayList;
import java.util.Date;

public class RegistroSeguimiento {
    private ArrayList<Movimiento> registro;

    public RegistroSeguimiento() {
        registro = new ArrayList<Movimiento>();
    }

    private void agregarRegistro(Sucursal sucursal, TipoMovimiento tipoMov) {
        registro.add(new Movimiento(new Date(), sucursal, tipoMov));
    }

    public void registrarPreparacion() {
        agregarRegistro(null, TipoMovimiento.EN_PREPARACION);
    }

    public void registrarReciboSucursal(Sucursal sucursal) {
        agregarRegistro(sucursal, TipoMovimiento.RECIBIDO_EN_SUCURSAL);
    }

    public void registrarDespachoSucursal(Sucursal sucursal) {
        agregarRegistro(sucursal, TipoMovimiento.DESPACHADO_DE_SUCURSAL);
    }

    public void registrarEntrega() {
        agregarRegistro(null, TipoMovimiento.ENVIO_ENTREGADO);
    }

    public ArrayList<Movimiento> getRegistro() {
        return registro;
    }

    public void mostrar() {
        if (!registro.isEmpty()) {
            for (Movimiento reg : registro) {
                System.out.println(reg);
            }
        } else {
            System.out.println("No hay registros que mostrar");
        }
    }
}
