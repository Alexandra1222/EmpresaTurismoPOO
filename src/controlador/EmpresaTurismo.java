package controlador;

import modelo.MedioDeAlojamiento;
import modelo.Hotel;
import modelo.Carpa;
import modelo.Hospederia;
import modelo.DatosCliente;
import modelo.Cabagna;


import java.util.ArrayList;

public class EmpresaTurismo {
    //atributos
    private ArrayList<MedioDeAlojamiento> empresa;//{medioAlojamiento1,medioAlojamiento2}

    //metodos accesadores y modificadores
    public ArrayList<MedioDeAlojamiento> getEmpresa() {
        return empresa;
    }

    public void setEmpresa(ArrayList<MedioDeAlojamiento> empresa) {

        this.empresa = empresa;
    }

    public EmpresaTurismo(ArrayList<MedioDeAlojamiento> empresa) {

        this.empresa = empresa;
    }

    //Logica
    public int buscarCliente(String rutCliente) {
        for (int i = 0; i < empresa.size(); i++) {
            //condicion para encontrar cliente
            if (empresa.get(i).getDatoCliente().getRutCliente().compareToIgnoreCase(rutCliente) == 0) {
                return i;
            }
        }
        return -1;
    }
////////////////////////////////////////////////////////////////////////////////////////////////////

    //ingresar medios de Alojamiento
    public void ingresarMedioDeAlojamientoCarpa(Carpa carpa) {
        if (buscarCliente(carpa.getDatoCliente().getRutCliente()) == -1) {
            empresa.add(carpa);
        }
    }

    public void ingresarMedioDeAlojamientoHotel(Hotel hotel) {
        if (buscarCliente(hotel.getDatoCliente().getRutCliente()) == -1) {
            empresa.add(hotel);
        }
    }

    public void ingresarMedioDeAlojamientoCabagna(Cabagna cabagna) {
        if (buscarCliente(cabagna.getDatoCliente().getRutCliente()) == -1) {
            empresa.add(cabagna);
        }
    }


    /*MOSTRAR MEDIOS DE ALOJAMIENTO*/
    public String mediosDeAlojamiento() {
        String mensaje = "";
        Cabagna cabagna = null;
        Hotel hotel = null;
        Carpa carpa = null;
        int contador = 0;
        for (int i = 0; i < empresa.size(); i++) { //iterar en la colección
            if (empresa.get(i) instanceof Cabagna) {
                cabagna = (Cabagna) empresa.get(i);
                mensaje = mensaje + "\n/////" + "\n El medio de alojamiento es: " + cabagna.getTipoDeMedioDeAlojamiento() + "\n El cliente que se hospeda aquí es:" + cabagna.getDatoCliente().getNombre() + "\n  El rut asociado al cliente: " + cabagna.getDatoCliente().getRutCliente() + "\n  El Valor base por noche es: $" + cabagna.getValorBaseNoche() + "\n la cantidad de noches es: " + cabagna.getCantidadDeNoches() + "\n La temporada es : " + cabagna.getTipoTemporada() + "\n La capacidad de personas: " + cabagna.getCapacidad() + "\n Es fumador: " + cabagna.isEsFumador() + "\n Es con Chimenea " + cabagna.isChimenea() + "\n/////";
                contador++;
            } else if (empresa.get(i) instanceof Hotel) {
                hotel = (Hotel) empresa.get(i);
                mensaje = mensaje + "\n/////" + "\n El medio de alojamiento es: " + hotel.getTipoDeMedioDeAlojamiento() + "\n El cliente que se hospeda aquí es:" + hotel.getDatoCliente().getNombre() + "\n  El rut asociado al cliente: " + hotel.getDatoCliente().getRutCliente() + "\n  El Valor base por noche es: $" + hotel.getValorBaseNoche() + "\n la cantidad de noches es: " + hotel.getCantidadDeNoches() + "\n La temporada es : " + hotel.getTipoTemporada() + "\n La capacidad de personas: " + hotel.getCapacidad() + "\n Es fumador: " + hotel.isEsFumador() + "\n Es con desayuno " + hotel.isConDesayuno() + "\n/////";
                contador++;
            } else if (empresa.get(i) instanceof Carpa) {
                carpa = (Carpa) empresa.get(i);
                mensaje = mensaje + "\n/////" + "\n El medio de alojamiento es: " + carpa.getTipoDeMedioDeAlojamiento() + "\n El cliente que se hospeda aquí es: " + carpa.getDatoCliente().getNombre() + "\n El rut asociado al cliente:: " + carpa.getDatoCliente().getRutCliente() + "\n El Valor base por noche es: $" + carpa.getValorBaseNoche() + "\n la Cantidad de noches es: " + carpa.getCantidadDeNoches() + "\n La temporada es : " + carpa.getTipoTemporada() + "\n La capacidad de personas es: " + carpa.getCantidadPersonas() + "\n/////";
                contador++;
            }
        }
        if (contador == 0)
            System.out.println("No hay medios de alojamiento registrados");
        return mensaje;
    }


    public String datosClienteX(String rutCliente) {
        String mensaje = "";
        Cabagna cabagna = null;
        Hotel hotel = null;
        Carpa carpa = null;
        for (int i = 0; i < empresa.size(); i++) {
            if (empresa.get(i).getDatoCliente().getRutCliente().compareToIgnoreCase(rutCliente) == 0) {
                if (empresa.get(i) instanceof Cabagna) {
                    cabagna = (Cabagna) empresa.get(i);
                    mensaje = "\n El rut del cliente es: " + cabagna.getDatoCliente().getRutCliente() + "\n y se encuentra asociado al cliente: " + cabagna.getDatoCliente().getNombre()
                            + "\n El tipo de alojamiento de este cliente es: " + cabagna.getTipoDeMedioDeAlojamiento() + "\n La cantidad de noches que se queda es: " + cabagna.getCantidadDeNoches() + "\n En temporada: " + cabagna.getTipoTemporada() + "\n La cantidad de personas que se  aloja  es: " + cabagna.getCapacidad() + "\n Con un valor base :  $" + cabagna.getValorBaseNoche() + "es fumador:" + cabagna.isEsFumador() + "es con chimenea: " + cabagna.isChimenea() + "\n El descuento por temporada es un total de : $" + cabagna.bonoDescuento() + "\n El total a cancelar tiene un valor de: $" + cabagna.valorACancelar() + "\n///////";
                } else if (empresa.get(i) instanceof Hotel) {
                    hotel = (Hotel) empresa.get(i);
                    mensaje = "\n El rut del cliente es: " + hotel.getDatoCliente().getRutCliente() + "\n y se encuentra asociado al cliente: " + hotel.getDatoCliente().getNombre()
                            + "\n El tipo de alojamiento de este cliente es: " + hotel.getTipoDeMedioDeAlojamiento() + "\n La cantidad de noches que se queda es: " + hotel.getCantidadDeNoches() + "\n En temporada: " + hotel.getTipoTemporada() + "\n La cantidad de personas que se  aloja  es: " + hotel.getCapacidad() + "\n Con un valor base :  $" + hotel.getValorBaseNoche() + "es fumador:" + hotel.isEsFumador() + "es con desayuno: " + hotel.isConDesayuno() + "\n El descuento por temporada es un total de : $" + hotel.bonoDescuento() + "\n El total a cancelar tiene un valor de: $" + hotel.valorACancelar() + "\n///////";
                } else if (empresa.get(i) instanceof Carpa) {
                    carpa = (Carpa) empresa.get(i);
                    mensaje = "\n El rut del cliente es: " + carpa.getDatoCliente().getRutCliente() + "\n y se encuentra asociado al cliente: " + carpa.getDatoCliente().getNombre()
                            + "\n El tipo de alojamiento de este cliente es: " + carpa.getTipoDeMedioDeAlojamiento() + "\n La cantidad de noches que se queda es: " + carpa.getCantidadDeNoches() + "\n En temporada: " + carpa.getTipoTemporada() + "\n La cantidad de personas que se  aloja  es: " + carpa.getCantidadPersonas() + "\n Con un valor base :  $" + carpa.getValorBaseNoche() + "\n El descuento por temporada es un total de : $" + carpa.bonoDescuento() + "\n El total a cancelar tiene un valor de: $" + carpa.valorACancelar() + "\n///////";

                }
                return mensaje;
            }
        }
        return "No hay clientes asociados al rut ingresado";

    }
    /////////////////////////////////////////////////////////////////////////////////////////////
    public int totalBonoDescuento() {
        int total = 0;

        for (int i = 0; i < empresa.size(); i++) {
            total = total + (empresa.get(i).bonoDescuento());
        }
        return total;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////
    public int totalAdicional() {
        int total = 0;
        Hotel hotel = null;
        for (int i = 0; i < empresa.size(); i++) {
            if (empresa.get(i) instanceof Hotel) {
                hotel = (Hotel) empresa.get(i);
                total = total + (hotel.valorAdicional());
            }
        }
        return total;
    }
///////////////////////////////////////////////////////////////////////////////////////////////////
public String todosLosMediosAlojamiento() {
    String mensaje = "";

    for (int i = 0; i < empresa.size(); i++) {
        if (i > 0) {
            mensaje = mensaje + "La cantidad de medios de alojamiento es de : " + empresa.size();
            break;
        }
    }
    return mensaje;
}
///////////////////////////////////////////////////////////////////////////////////////////////////

    public String incrementoValorBase(String rut) {
        Cabagna cabagna = null;
        for (int i = 0; i < empresa.size(); i++) {
            if (empresa.get(i).getDatoCliente().getRutCliente().compareToIgnoreCase(rut) == 0) {
                if (empresa.get(i) instanceof Cabagna) {
                    cabagna = (Cabagna) empresa.get(i);
                    return "El incremento al valor base es de: " + cabagna.incrementaValorBase()+ "$";

                }
            }
        }
        return "No corresponde un incremento del valor base";
    }


// /////////////////////////////////////////////////////////////////////////////////////////////////
public String valorACancelar(String rutCliente) {
    int total = 0;
    for (int i = 0; i < empresa.size(); i++) {
        if (empresa.get(i).getDatoCliente().getRutCliente().compareToIgnoreCase(rutCliente) == 0) {
            return "El valor a cancelar  es de : " + empresa.get(i).getDatoCliente().getRutCliente() + " corresponde al valor  de: " + empresa.get(i).valorACancelar()+" $";
        }
    }
    return "No se encuentra el cliente, intente con otro rut.";
}
///////////////////////////////////////////////////////////////////////////////////////////////////////

}