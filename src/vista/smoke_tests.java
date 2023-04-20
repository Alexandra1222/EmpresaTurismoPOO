package vista; //te esta diciendo el package que pertenece la clase :D
//linkea :D

import controlador.EmpresaTurismo;
import modelo.*;
import java.util.ArrayList;
import java.util.ArrayList;

//Los modificadores de acceso definen el como acceso a las clases/Atributos/metodos
public class smoke_tests { //Define la estructura de la clase

    public static void smoke_test(String[] args) {
            EmpresaTurismo empresaTurismo = new EmpresaTurismo(new ArrayList<>());

            Carpa carpa = new Carpa(new DatosCliente("caramelito caramelito", "60009876"),5,4000,"1","baja",5);
            Hotel hotel = new Hotel(new DatosCliente("sandokan sandokan", "30998765"),5,10000,"2","Alta",true,6,true);
            Cabagna cabagna = new Cabagna(new DatosCliente("Tiziana Titi", "40567543"), 6, 8000, "0", "Media", true, 7,true);

            empresaTurismo.ingresarMedioDeAlojamientoCarpa(carpa);
            empresaTurismo.ingresarMedioDeAlojamientoHotel(hotel);
            empresaTurismo.ingresarMedioDeAlojamientoCabagna(cabagna);

    }
}
