import clases.*;

public class Main {

    public static void main(String[] args) {

        Conductor general = new Conductor("Juan");
        Conductor piloto = new Piloto("Ana");

        Vehiculo opel = new Coche(140);
        Vehiculo moto = new Moto(15);

        general.compra(opel);
        general.reposta(opel,10f);
        System.out.println("\nPrimer tramo:");
        general.conduce(opel,100f);
        System.out.println("\nSegundo tramo:");
        general.conduce(opel,100f);

        piloto.compra(moto);
        System.out.println("\nTramo de piloto:");
        piloto.conduce(moto, 300f);

    }

}
