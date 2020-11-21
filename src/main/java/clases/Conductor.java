package clases;

import java.util.ArrayList;
import java.util.List;

public class Conductor {
    private String nombre;
    protected Integer velocidadMedia;
    protected List<Vehiculo> vehiculos;

    public Conductor(String nombre){
        this.nombre = nombre;
        this.velocidadMedia = 100;
        this.vehiculos = new ArrayList<>();
    }

    public void compra(Vehiculo vehiculo){
        this.vehiculos.add(vehiculo);
    }

    public void conduce(Vehiculo vehiculo, Float distancia){
        System.out.println(nombre+" conduciendo");
        if(vehiculo.encender()){
            Incidente incidente = vehiculo.recorrer(distancia);
            switch (incidente){
                case OK -> System.out.println("Hemos llegado al destino en "+distancia/this.velocidadMedia+" horas");
                case NO_LLEGO ->  System.out.println("No hay suficiente combustible");
                case AVERIA -> System.out.println("Hay una nueva avería");
                default -> vehiculo.apagar();
            }
        }
        else System.out.println("El vehículo no enciende");
    }

    public void reposta(Vehiculo vehiculo, Float litrosCombustible){
        vehiculo.reposta(litrosCombustible);
    }

}
