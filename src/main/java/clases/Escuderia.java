package clases;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

public class Escuderia {

    private List<Piloto> pilotos;

    public Escuderia() {
        this.pilotos = new ArrayList<>();
    }

    public void contrataPiloto(Piloto piloto){
        this.pilotos.add(piloto);
    }

    public void asignaVehiculoAPiloto(Vehiculo vehiculo,Piloto piloto){
        /* Método tradicional
        for(int i = 0; i < pilotos.size(); i++){
            Piloto actual = pilotos.get(i);
            if(actual.getNombre().equals(piloto.getNombre())){
                actual.asigna(vehiculo);
            }
        }
        */
        // Método moderno
        Piloto pilotoEncontrado = pilotos.stream().filter(pilotoEnLista->pilotoEnLista.getNombre().equals(piloto.getNombre())).findFirst().get();
        pilotoEncontrado.asigna(vehiculo);
    }

    public Vehiculo getMasRodado(Piloto piloto){
        /*
        //Tradicional
        Vehiculo vehiculo = null;
        for(int i = 0; i < piloto.getVehiculos().size(); i++){
            Vehiculo vehiculoActual = piloto.getVehiculos().get(i);
            if(vehiculo == null){
                vehiculo = vehiculoActual;
            }
            else {
                if(vehiculo.getKm() < vehiculoActual.getKm()){
                    vehiculo = vehiculoActual;
                }
            }
        }
        return vehiculo
        */
        //Moderno
        return piloto.getVehiculos().stream().max(Comparator.comparing(Vehiculo::getKm)).orElseThrow(NoSuchElementException::new);
    }

    public Vehiculo getMasRodado(){
        List<Vehiculo> vehiculos = new ArrayList<>();
        this.pilotos.forEach(piloto -> {
            vehiculos.add(getMasRodado(piloto));
        });
        Vehiculo vehiculo = vehiculos.stream().max(Comparator.comparing(Vehiculo::getKm)).orElseThrow(NoSuchElementException::new);;
        return vehiculo;
    }

    @Override
    public String toString() {
        return "Escuderia{" +
                "pilotos=" + pilotos +
                '}';
    }
}
