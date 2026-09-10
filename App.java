public class App {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente(34567890, "Martín", "Ciudad de Buenos Aires");
        Cliente cliente2 = new Cliente(37485925, "María", "Villa La Angostura");

        Paquete paq1 = new Paquete(1, "Audífonos", 0.5, "José");
        Paquete paq2 = new Paquete(2, "Notebook", 2.5, "Ernesto");
        Paquete paq3 = new Paquete(3, "Celular", 1.0, "Thiago");
        Paquete paq4 = new Paquete(4, "Tablet", 1.25, "Rodrigo");
        Paquete paq5 = new Paquete(5, "Audífonos", 0.4, "Juana");

        Sucursal sucursal1 = new Sucursal(1, "Ciudad de Buenos Aires");
        Sucursal sucursal2 = new Sucursal(2, "Bahía Blanca");
        Sucursal sucursal3 = new Sucursal(3, "Neuquén");
        Sucursal sucursal4 = new Sucursal(4, "San Carlos de Bariloche");
        Sucursal sucursal5 = new Sucursal(5, "La Plata");
        Sucursal sucursal6 = new Sucursal(6, "Villa La Angostura");
        Sucursal sucursal7 = new Sucursal(7, "Osorno (Chile)");

        Envio envio1 = new EnvioEstandar(11532);

        envio1.agregarPaquete(paq1);
        envio1.agregarPaquete(paq2);
        envio1.agregarPaquete(paq3);

        envio1.mostrarInformacion();

        Envio envio2 = new EnvioExpress(11533);

        envio2.agregarPaquete(paq4);

        envio2.mostrarInformacion();

        cliente1.asignarEnvio(envio1);
        cliente1.asignarEnvio(envio2);
        cliente1.mostrarInformacion();

        Envio envio3 = new EnvioInternacional(11534);

        envio3.agregarPaquete(paq5);

        envio3.mostrarInformacion();

        System.out.println("Envío 1");
        envio1.iniciarEnvio();

        sucursal1.recibirEnvio(envio1);
        envio1 = sucursal1.despacharEnvio();

        sucursal2.recibirEnvio(envio1);
        envio1 = sucursal2.despacharEnvio();

        sucursal3.recibirEnvio(envio1);
        envio1 = sucursal3.despacharEnvio();

        sucursal4.recibirEnvio(envio1);
        envio1 = sucursal4.despacharEnvio();

        envio1.finalizarEnvio();
        envio1.mostrarHistorial();

        System.out.println("\nEnvío 2");

        envio2.iniciarEnvio();

        sucursal5.recibirEnvio(envio2);
        envio2 = sucursal5.despacharEnvio();

        envio2.finalizarEnvio();
        envio2.mostrarHistorial();

        System.out.println("\nEnvío 3");

        envio3.iniciarEnvio();

        sucursal6.recibirEnvio(envio3);
        envio3 = sucursal6.despacharEnvio();

        sucursal7.recibirEnvio(envio3);
        envio3 = sucursal7.despacharEnvio();

        envio3.finalizarEnvio();
        envio3.mostrarHistorial();
    }
}
