public class EnvioExpress extends Envio {
    public EnvioExpress(int numeroEnvio) {
        super(numeroEnvio);
    }

    @Override
    public double calcularCosto() {
        return obtenerPesoTotal()*180 + 500;
    }
}
