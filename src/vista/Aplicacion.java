package vista;

import controlador.EmpresaTurismo;
import modelo.MedioDeAlojamiento;
import modelo.Cabagna;
import modelo.Hotel;
import modelo.Carpa;
import modelo.Hospederia;
import modelo.DatosCliente;

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
                        System.out.println("ingrese el nombre del cliente");
                        String nombre = Leer.dato();
                    }
                    Scanner scanner = new Scanner(System.in);
                    int valorBasePorNoche = 0;
                    while (valorBasePorNoche == 0) {
                        System.out.println("ingrese el valor Base por noche de este modo (Sin puntos, ejemplo: 40000)");
                        if (scanner.hasNextInt()) {
                            valorBasePorNoche = scanner.nextInt();
                        } else {
                            System.out.println("Debe ingresar un valor numerico,intentelo nuevamente por favor");
                            scanner.next();
                        }
                    }
                    int numNoches = 0;
                    while (numNoches == 0) {
                        System.out.println("Ingrese la cantidad de noches, ejemplo: 8");
                        if (scanner.hasNextInt()) {
                            numNoches = scanner.nextInt();
                        } else {
                            System.out.println("Debe ingresar un valor numerico, intente nuevamente");
                            scanner.next();
                        }
                    }

                    String tipoTemporada;
                    do {
                        System.out.println("Ingrese  tipo de temporada (baja - media - alta)");
                        tipoTemporada = Leer.dato();
                    } while (tipoTemporada.compareToIgnoreCase("baja") != 0 && tipoTemporada.compareToIgnoreCase("media") != 0 && tipoTemporada.compareToIgnoreCase("alta") != 0);
                    int respuesta;
                    do {
                        System.out.println("Opciones: 0 = Carpa, 1= Hotel, 2 = Cabagna");
                        System.out.println("Ingrese numero de opcion para continuar... Ejemplo: 0");
                        respuesta = Leer.datoInt();
                    } while (respuesta < 1 || respuesta > 3);
                    if (respuesta == 1) {

                        int cantidadDePersonas = 0;
                        while (cantidadDePersonas == 0) {
                            System.out.println("Ingrese el numero de personas que ocuparan la carpa. Ejemplo: 4");
                            if (scanner.hasNextInt()) {
                                cantidadDePersonas = scanner.nextInt();
                            } else {
                                System.out.println("Debe ingresar un valor numerico, intente nuevamente");
                                scanner.next();
                            }
                        }

                        empresa.ingresarMedioDeAlojamientoCarpa(new Carpa(new DatosCliente(nombre,rutCliente),cantidadDePersonas,numNoches,tipoDeMedioDeAlojamiento,valorBasePorNoche,tipoTemporada);
                        System.out.println("Se reservo la carpa  exitosamente \n");
                    } else {
                        String fuma;
                        boolean clienteFuma = false;
                        do {
                            System.out.println("¿El cliente fuma? Ejemplo: Si / No");
                            fuma = Leer.dato();
                            switch (fuma.toLowerCase()) {
                                case "si":
                                    clienteFuma = true;
                                    break;
                                case "no":
                                    clienteFuma = false;
                                    break;
                                default: // caso de respuesta inválida
                                    System.out.println("Respuesta no inválida. Ingrese 'si' o 'no'.");
                                    break;
                            }
                        } while (!fuma.equalsIgnoreCase("si") && !fuma.equalsIgnoreCase("no"));

                        int capacidadAlojamiento = 0;
                        while (capacidadAlojamiento == 0) {
                            System.out.println("Ingrese capacidad. Ejemplo: 5");
                            if (scanner.hasNextInt()) {
                                capacidadAlojamiento = scanner.nextInt();
                            } else {
                                System.out.println("Debe ingresar un valor numerico, intentelo nuevamente");
                                scanner.next();
                            }
                        }

                        if (respuesta == 2) {
                            String desayuno;
                            boolean incluyeDesayuno = false;
                            do {
                                System.out.println("¿desea  desayuno incluido? Ejemplo: Si / No");
                                desayuno = Leer.dato();
                                switch (desayuno.toLowerCase()) {
                                    case "si":
                                        incluyeDesayuno = true;
                                        break;
                                    case "no":
                                        incluyeDesayuno = false;
                                        break;
                                    default: // caso de respuesta inválida
                                        System.out.println("Respuesta inválida. Por favor, ingrese 'si' o 'no'.");
                                        break;
                                }
                            } while (!desayuno.equalsIgnoreCase("si") && !desayuno.equalsIgnoreCase("no"));
                            empresa.ingresarMedioDeAlojamientoHotel(new Hotel(new DatosCliente(nombre, rutCliente), valorBasePorNoche, numNoches, tipoTemporada, clienteFuma, capacidadAlojamiento, incluyeDesayuno));
                            System.out.println("El hotel se reservó exitosamente \n");

                        } else {
                            String conChimenea;
                            boolean chimenea = false;
                            do {
                                System.out.println("¿Desea que la cabania tenga  chimenea? Ejemplo: Si / No");
                                conChimenea = Leer.dato();
                                switch (conChimenea.toLowerCase()) {
                                    case "si":
                                        chimenea = true;
                                        break;
                                    case "no":
                                        chimenea = false;
                                        break;
                                    default: // caso de respuesta inválida
                                        System.out.println("Respuesta inválida. Por favor, ingrese 'si' o 'no'.");
                                        break;
                                }
                            } while (!conChimenea.equalsIgnoreCase("si") && !conChimenea.equalsIgnoreCase("no"));
                            empresa.ingresarMedioDeAlojamientoCabagna(new Cabagna(new DatosCliente(nombre, rutCliente), valorBasePorNoche, numNoches, tipoTemporada, clienteFuma, capacidadAlojamiento, chimenea));
                            System.out.println("La cabania se ha reservado de forma exitosa \n");
                        }
                    }
            } else{
                System.out.println("El rut: " + rutCliente + " ya existe en nuestros registros");
            }
            break;
            case 2:
                if (empresa.getEmpresa().size() == 0) {
                    System.out.println("Aun no se han agregado alojamientos en nuestro sistema :( \n");
                } else {
                    System.out.println(empresa.mediosDeAlojamiento());
                }
                break;
            case 3:
                if (empresa.getEmpresa().size() == 0) {
                    System.out.println("Aun no se han ingresado clientes, consulte mas tarde. \n");
                } else {
                    String rutSolicitado;
                    rutSolicitado = ingreseRutCliente();
                    empresa.datosClienteX(rutSolicitado);
                }
                break;
            case 4:
                if (empresa.getEmpresa().size() == 0) {
                    System.out.println("Aun no se han ingresado clientes. :( \n");
                } else {
                    String rutSolicitado;
                    rutSolicitado = ingreseRutCliente();
                    System.out.println("Total adicional: " + empresa.totalAdicional(rutSolicitado) + "\n");
                }
                break;
            case 5:
                if (empresa.getEmpresa().size() == 0) {
                    System.out.println("Aun no se han ingresado clientes. :( \n");
                } else {
                    String rutSolicitado;
                    rutSolicitado = ingreseRutCliente();
                    System.out.println("Total bono descuento: " + empresa.totalBonoDescuento(rutSolicitado) + "\n");
                }
                break;
            case 6:
                if (empresa.getEmpresa().size() == 0) {
                    System.out.println("Aun no se han ingresado clientes. :( \n");
                } else {
                    System.out.println("El número de alojamientos actuales en el sistema es de : " + empresa.todosLosMediosAlojamiento() + "\n");
                }
                break;
            case 7:
                if (empresa.getEmpresa().size() == 0) {
                    System.out.println("Aun no se han ingresado clientes. :( \n");
                } else {
                    String rutSolicitado;
                    rutSolicitado = ingreseRutCliente();
                    System.out.println("El rut ingresado tiene un valor a cancelar de : " + empresa.valorACancelar(rutSolicitado) + "$" + "\n");
                }
                break;
            case 8:
                if (empresa.getEmpresa().size() == 0) {
                    System.out.println("no se ingresaron clientes todavia. :( \n");
                } else {
                    String rutSolicitado;
                    rutSolicitado = ingreseRutCliente();
                    System.out.println("El incremento valor base de acuerdo a la capacidad de la cabagna es de : " + empresa.incrementoValorBase(rutSolicitado) + "\n");
                }
                break;

        }
    } while(opcion !=9);
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

}