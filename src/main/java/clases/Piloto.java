package clases;

public class Piloto extends Conductor{

    public Piloto(String nombre) {
        super(nombre);
        this.velocidadMedia = 150;
    }

    @Override
    public void conduce(Vehiculo vehiculo, Float distancia) {
        //se calculan los litros necesarios para la carrera
        Float litrosNecesarios = vehiculo.calculoConsumo(distancia);
        vehiculo.reposta(litrosNecesarios);
        super.conduce(vehiculo, distancia);
    }
}
