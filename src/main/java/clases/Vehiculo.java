package clases;

import java.util.Random;

public abstract class Vehiculo implements Combustion{

    private Float km;
    protected Integer CV;
    protected Float consumoL100Km = null;
    private Float litrosCombustible;
    private Boolean buenFuncionamiento;

    public Vehiculo() {
        this.km = 0f;
        this.buenFuncionamiento = true;
        this.litrosCombustible = 0f;
    }

    public Float getKm(){
        return this.km;
    }

    @Override
    public Boolean encender() {
        return buenFuncionamiento;
    }

    @Override
    public Boolean apagar() {
        return buenFuncionamiento;
    }

    @Override
    public Incidente recorrer(Float distancia) {
        if(!buenFuncionamiento){
            return Incidente.ARRANQUE;
        }
        else{
            Random random = new Random();
            //probabilidad de rotura en viaje
            int rotura = random.nextInt(1000);
            if(rotura == 123){ //1 de cada 1000
                buenFuncionamiento = false;
                return Incidente.AVERIA;
            }
            else {
                Float distanciaMaxima = calculoDistanciaMaxima();
                System.out.println("Con el combustible actual puedo recorrer "+distanciaMaxima+" km");
                if (distanciaMaxima >= distancia) {
                    this.litrosCombustible -= calculoConsumo(distancia);
                    this.km+=distancia;
                    return Incidente.OK;
                } else {
                    return Incidente.NO_LLEGO;
                }
            }
        }
    }

    public Float calculoDistanciaMaxima(){
        return (litrosCombustible * 100) / consumoL100Km;
    }

    public Float calculoConsumo(Float distancia){
        return (consumoL100Km * distancia) / 100;
    }

    public void reparar(){
        this.buenFuncionamiento = true;
    }

    public void reposta(Float litrosCombustible){
        this.litrosCombustible+=litrosCombustible;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "km=" + km +
                ", CV=" + CV +
                ", consumoL100Km=" + consumoL100Km +
                ", litrosCombustible=" + litrosCombustible +
                ", buenFuncionamiento=" + buenFuncionamiento +
                '}';
    }

}
