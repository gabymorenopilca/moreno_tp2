import java.util.ArrayList;

public class RegistroSeguimiento {
    ArrayList<String> registro;

    public RegistroSeguimiento() {
        registro = new ArrayList<String>();
    }

    private void agregarRegistro(String estado) {
        registro.add(estado);
    }

    public void registrarPreparacion() {
        agregarRegistro("Envío en preparación");
    }

    public void registrarReciboSucursal(String sucursal) {
        agregarRegistro("Envío recibido en Sucursal " + sucursal);
    }

    public void registrarDespachoSucursal(String sucursal) {
        agregarRegistro("Envío despachado desde Sucursal " + sucursal);
    }

    public void registrarEntrega() {
        agregarRegistro("Envío entregado");
    }

    public void mostrar() {
        for (String reg : registro) {
         System.out.println(reg);
     }
 }
}
