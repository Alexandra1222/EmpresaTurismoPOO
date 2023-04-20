package modelo;

public class Cabagna extends Hospederia{


    private boolean chimenea;

    public Cabagna(DatosCliente datoCliente, int cantidadDeNoches, int valorBaseNoche, String tipoDeMedioDeAlojamiento, String tipoTemporada, boolean esFumador, int capacidad, boolean chimenea) {
        super(datoCliente, cantidadDeNoches, valorBaseNoche, tipoDeMedioDeAlojamiento, tipoTemporada, esFumador, capacidad);
        this.chimenea = chimenea;
    }

    public boolean isChimenea() {
        return chimenea;
    }

    public void setChimenea(boolean chimenea) {
        this.chimenea = chimenea;
    }

    /////////////////////////METODOS/////////////////////////////////////////
    public int incrementaValorBase(){

        int incrementaValorBase = 0;
        if(this.getCapacidad() > 5){
            incrementaValorBase = this.getValorBaseNoche() * 18/100;
            return incrementaValorBase;

        }
        return incrementaValorBase;

    }
    @Override
    public int valorACancelar() {
        return (this.subTotal() + incrementaValorBase()) - this.bonoDescuento() ;
    }
}
