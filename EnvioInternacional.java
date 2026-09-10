public class EnvioInternacional extends Envio {
    public EnvioInternacional(int numeroEnvio) {
        super(numeroEnvio);
    }

    @Override
    public double calcularCosto() {
        return obtenerPesoTotal()*300 + 2000;
    }
}
