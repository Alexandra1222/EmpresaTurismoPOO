package modelo;

public class Carpa extends MedioDeAlojamiento{



    private int cantidadPersonas;

    public Carpa() {
    }

    public Carpa(DatosCliente datoCliente, int cantidadDeNoches, int valorBaseNoche, String tipoDeMedioDeAlojamiento, String tipoTemporada, int cantidadPersonas) {
        super(datoCliente, cantidadDeNoches, valorBaseNoche, tipoDeMedioDeAlojamiento, tipoTemporada);
        this.cantidadPersonas = cantidadPersonas;
    }

    public int getCantidadPersonas() {
        return cantidadPersonas;
    }

    public void setCantidadPersonas(int cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
    }


    /*incrementaValorBase: aumenta el valor base en un 18%
    si la capacidad de la cabaña es superior a 5.
    @Override
    public int incrementaValorBase() {
        int incrementoValorBase=0;
        if(this.getCantidadPersonas()>5){
            incrementoValorBase=getValorBaseNoche()*18/100;
            return incrementoValorBase;
        }
        return incrementoValorBase;
    }*/
    @Override
    public int valorACancelar() {
        return this.subTotal() - bonoDescuento();
    }
}

