public class EnvioEstandar extends Envio {
    public EnvioEstandar(int numeroEnvio) {
        super(numeroEnvio);
    }

    @Override
    public double calcularCosto() {
        return obtenerPesoTotal()*100;
    }
}
