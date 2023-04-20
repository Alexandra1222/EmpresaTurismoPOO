package modelo;

public class Hotel extends Hospederia {
    private boolean conDesayuno;

    public Hotel(DatosCliente datoCliente, int cantidadDeNoches, int valorBaseNoche, String tipoDeMedioDeAlojamiento, String tipoTemporada, boolean esFumador, int capacidad, boolean conDesayuno) {
        super(datoCliente, cantidadDeNoches, valorBaseNoche, tipoDeMedioDeAlojamiento, tipoTemporada, esFumador, capacidad);
        this.conDesayuno = conDesayuno;
    }

    public boolean isConDesayuno() {
        return conDesayuno;
    }



    public void setConDesayuno(boolean conDesayuno) {
        this.conDesayuno = conDesayuno;
    }


/////////////////////METODOS////////////////////////////////////////////////////

    public int valorAdicional() {
       int valorAdicional=0;
       if(this.isConDesayuno() && this.isEsFumador()){
          valorAdicional=this.subTotal() * 30/100;
          return valorAdicional;
       }
       return valorAdicional;
    }

    /*valorACancelar: devolverá el valor a cancelar, el cual al subtotal
     se le debe descontar el bono y sumar el adicional,
     donde corresponda*/
    @Override
    public int valorACancelar() {
        int valorACancelar = 0;
        valorACancelar=subTotal()-bonoDescuento()+valorAdicional();
        return valorACancelar;
    }

}
