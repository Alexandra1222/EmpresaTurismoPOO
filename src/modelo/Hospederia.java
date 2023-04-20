package modelo;

public abstract class Hospederia extends MedioDeAlojamiento{

    private boolean esFumador;
    private int capacidad;

    public Hospederia() {
    }


    public Hospederia(DatosCliente datoCliente, int cantidadDeNoches, int valorBaseNoche, String tipoDeMedioDeAlojamiento, String tipoTemporada, boolean esFumador, int capacidad) {
        super(datoCliente, cantidadDeNoches, valorBaseNoche, tipoDeMedioDeAlojamiento, tipoTemporada);
        this.esFumador = esFumador;
        this.capacidad = capacidad;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public boolean isEsFumador() {
        return esFumador;
    }

    public void setEsFumador(boolean esFumador) {
        this.esFumador = esFumador;
    }

    ////////////////////////////////////////////////////////////////////////////////

    /*adicional: devolverá el valor adicional, que corresponde al 30% del subtotal si es Fumador y con desayuno.*/
    /*public abstract  int valorAdicional();



    @Override
    public int incrementaValorBase() {
        return 0;
    }*/

}
