import clases.*;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        /*
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

         */

        Escuderia ferrari = new Escuderia();
        Coche coche1 = new Coche(990);
        Coche coche2 = new Coche(990);
        Coche coche3 = new Coche(990);
        Coche coche4 = new Coche(990);

        Piloto sainz = new Piloto("Sáinz");
        Piloto leclerc = new Piloto("Leclerc");

        ferrari.contrataPiloto(sainz);
        ferrari.contrataPiloto(leclerc);

        ferrari.asignaVehiculoAPiloto(coche1,sainz);
        ferrari.asignaVehiculoAPiloto(coche3,sainz);
        ferrari.asignaVehiculoAPiloto(coche2,leclerc);
        ferrari.asignaVehiculoAPiloto(coche4,leclerc);

        leclerc.conduce(coche1,260f);
        leclerc.conduce(coche2,250f);

        System.out.println(ferrari);

        System.out.println("Vehículo más rodado de Leclerc");
        Coche masRodado = (Coche) ferrari.getMasRodado(leclerc);
        System.out.println(masRodado);

        System.out.println("Vehículo más rodado de la escuderia");
        Coche masRodadoEscuderia = (Coche) ferrari.getMasRodado();
        System.out.println(masRodadoEscuderia);

    }

}
