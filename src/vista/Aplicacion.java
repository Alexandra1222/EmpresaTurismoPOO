package vista;

import controlador.EmpresaTurismo;
import modelo.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Aplicacion {
    public static void main(String[] args) {
        EmpresaTurismo empresa = new EmpresaTurismo(new ArrayList<>());
        String rutCliente;


        int opcion;
        do {
            opcion = menu();
            switch (opcion) {
                case 1:
                    rutCliente = ingreseRutCliente();
                    if (empresa.buscarCliente(rutCliente) == -1) {
                        System.out.println("Ingrese su nombre");
                        String nombre = Leer.dato();

                        System.out.println("Ingrese el valor base por noche");
                        int valorBaseNoche = Leer.datoInt();

                        System.out.println("Ingrese cantidad de noches a reservar");
                        int cantidadDeNoches = Leer.datoInt();

                        String tipoTemporada;
                        do {
                            System.out.println("Ingrese la temporada correspondiente (Temporada baja, temporada media o temporada alta)");
                            tipoTemporada = Leer.dato();
                        } while (tipoTemporada.compareToIgnoreCase("Temporada baja") != 0 &&
                                tipoTemporada.compareToIgnoreCase("Temporada media") != 0 &&
                                tipoTemporada.compareToIgnoreCase("Temporada alta") != 0);

                        int respuesta;
                        do {
                            System.out.println("El tipo de alojamiento es:   1) Carpa    2)Cabaña      3)Hotel");
                            System.out.println("Ingrese opción para continuar");
                            respuesta = Leer.datoInt();
                        } while (respuesta < 1 || respuesta > 3);

                        if (respuesta == 1) {
                            String tipoDeMedioDeAlojamiento = "Carpa";
                            System.out.println("Ingrese la cantidad de personas");
                            int cantidadPersonas = Leer.datoInt();
                            empresa.ingresarMedioDeAlojamientoCarpa(new Carpa(new DatosCliente(nombre, rutCliente),cantidadDeNoches,valorBaseNoche,tipoDeMedioDeAlojamiento,tipoTemporada,cantidadPersonas));
                            System.out.println("Se ingresa reserva en carpa con éxito");
                        } else {
                            System.out.println("Ingrese capacidad");
                            int capacidad = Leer.datoInt();

                            int fumador;
                            boolean esFumador = false;
                            do {
                                System.out.println("¿El cliente es fumador? 1) Sí  2) No");
                                System.out.println("Ingrese opción para continuar");
                                fumador = Leer.datoInt();
                                switch (fumador) {
                                    case 1:
                                        esFumador = true;
                                        break;
                                    case 2:
                                        esFumador = false;
                                        break;
                                }
                            } while (fumador < 0 || fumador > 2);

                            if (respuesta == 2) {
                                String tipoDeMedioDeAlojamiento = "Cabaña";
                                int chimenea;
                                boolean conChimenea = false;
                                do {
                                    System.out.println("¿El cliente desea reservar una cabaña con chimenea? 1) Sí  2) No");
                                    System.out.println("Ingrese opción para continuar");
                                    chimenea = Leer.datoInt();
                                    switch (chimenea) {
                                        case 1:
                                            conChimenea = true;
                                            break;
                                        case 2:
                                            conChimenea = false;
                                            break;
                                    }
                                } while (chimenea < 0 || chimenea > 2);
                                empresa.ingresarMedioDeAlojamientoCabagna(new Cabagna(new DatosCliente(nombre, rutCliente),cantidadDeNoches,valorBaseNoche,tipoDeMedioDeAlojamiento,tipoTemporada,esFumador,capacidad,conChimenea));
                                System.out.println("Se ingresa reserva en cabaña con éxito");
                            } else {

                                String tipoDeMedioDeAlojamiento = "Hotel";
                                int desayuno;
                                boolean conDesayuno = false;
                                do {
                                    System.out.println("¿El cliente desea servicio de desayuno? 1) Sí  2) No");
                                    System.out.println("Ingrese opción para continuar");
                                    desayuno = Leer.datoInt();
                                    switch (desayuno) {
                                        case 1:
                                            conDesayuno = true;
                                            break;
                                        case 2:
                                            conDesayuno = false;
                                            break;
                                    }
                                } while (desayuno < 0 || desayuno > 2);
                                empresa.ingresarMedioDeAlojamientoHotel(new Hotel(new DatosCliente(nombre,rutCliente),cantidadDeNoches,valorBaseNoche,tipoDeMedioDeAlojamiento,tipoTemporada,esFumador,capacidad,conDesayuno));
                                System.out.println("Se ingresa reserva en hotel con éxito");
                            }
                        }
                    } else {
                        System.out.println("El cliente " + rutCliente + " ya está registrado");
                    }

                    break;
                case 2:
                    if (empresa.getEmpresa().size() == 0) {
                        System.out.println("No hay alojamientos registrados");
                    } else {
                        System.out.println(empresa.mediosDeAlojamiento());
                    }
                    break;
                case 3:
                    if (empresa.getEmpresa().size() == 0) {
                        System.out.println("No hay alojamientos registrados");
                    } else {
                        String rut;
                        rut = ingreseRutCliente();
                        System.out.println(empresa.datosClienteX(rut));
                    }
                    break;
                case 4:
                    if (empresa.getEmpresa().size() == 0) {
                        System.out.println("No hay alojamientos registrados");
                    } else {

                        System.out.println("El Hotel tiene un total adicional de: $" + empresa.totalAdicional());
                    }
                    break;
                case 5:
                    if (empresa.getEmpresa().size() == 0) {
                        System.out.println("No hay alojamientos registrados");
                    } else {

                        System.out.println("El total del bono descuento es de de: $" + empresa.totalBonoDescuento());
                    }
                    break;
                case 6:
                    if (empresa.getEmpresa().size() == 0) {
                        System.out.println("No hay alojamientos registrados");
                    } else {

                        System.out.println(empresa.todosLosMediosAlojamiento());
                    }
                    break;
                case 7:
                    if (empresa.getEmpresa().size() == 0) {
                        System.out.println("No hay alojamientos registrados");
                    } else {
                        String rut;
                        rut = ingreseRutCliente();
                        System.out.println(empresa.valorACancelar(rut));
                    }
                    break;
                case 8:
                    if (empresa.getEmpresa().size() == 0) {
                        System.out.println("No hay alojamientos registrados");
                    } else {
                        String rut;
                        rut = ingreseRutCliente();
                        System.out.println(empresa.incrementoValorBase(rut));
                    }
                    break;
            }
        }
        while (opcion != 9);


}



        public static int menu () {
            System.out.println("**********EMPRESA TURISMO :D *********");
            System.out.println("1.\tIngresar Medio de Alojamiento ");
            System.out.println("2.\tMostrar Medios de Alojamiento");
            System.out.println("3.\tDatos de un cliente X");
            System.out.println("4.\tTotal Adicional");
            System.out.println("5.\tTotal Bono Descuento");
            System.out.println("6.\tCantidad medios de Alojamiento X");
            System.out.println("7.\tValor a Cancelar por un Cliente x");
            System.out.println("8.\tAplicar incremento del valor base ");
            System.out.println("9.Favor ingrese opción para continuar...");

            return Leer.datoInt();

        }

        public static String ingreseRutCliente () {
            System.out.println("Favor ingrese rut del cliente (Ej: 50776546)");
            return Leer.dato();

        }

}