package estancias.servicios;

import estancias.entidades.Casa;
import estancias.persistencias.CasaDAO;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class CasaServicio {

    public void casasEntreFechas(LocalDate fecha_desde, LocalDate fecha_hasta){
        try {
            List<Casa> casaList = new CasaDAO().obtenerCasas();

            System.out.println("Casas con disponibilidad entre " + fecha_desde + " y " + fecha_hasta);
            for (Casa casa: casaList) {
                if(casa.getFecha_desde().isAfter(fecha_desde.minus(1, ChronoUnit.DAYS)) && casa.getFecha_hasta().isBefore(fecha_hasta.plus(1, ChronoUnit.DAYS))){
                    System.out.printf("Casa %d, %s %d, %s, disponible desde %s hasta %s\n", casa.getId(), casa.getCalle(), casa.getNumero(), casa.getCodigo_postal(), casa.getFecha_desde(), casa.getFecha_hasta());
                }
            }
        }catch (Exception e){
            System.out.println("ERROR DURANTE casasEntreFechas");
        }
    }
}
