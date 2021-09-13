package estancias.servicios;

import estancias.entidades.Casa;
import estancias.persistencias.CasaDAO;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class CasaServicio {
    public void mostrarCasas(){
        try {
            CasaDAO DAO = new CasaDAO();
            List<Casa> casas = DAO.obtenerCasas();

            System.out.println("Tamaño de casas + " + casas.size());
            for (Casa casa: casas) {
                System.out.println(casa);
            }
        }catch (Exception e){
            System.out.println("Algo salio mal trayendo las casas");
        }
    }

    public void casasEntreFechas(LocalDate fecha_desde, LocalDate fecha_hasta){
        try {
            CasaDAO DAO = new CasaDAO();
            List<Casa> casaList = DAO.obtenerCasas();

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

    public void actualizarPrecioReinoUnido(){
        System.out.println("ACTUALIZANDO LOS PRECIOS DE LAS CASAS EN REINO UNIDO POR 5%");
        try {
            CasaDAO DAO = new CasaDAO();
            List<Casa> casas = DAO.obtenerCasas();

            for (Casa casa: casas) {
                if(casa.getPais().equalsIgnoreCase("Reino Unido")){
                    DAO.actualizarPrecioCasa(casa, casa.getPrecio_habitacion()*1.05);
                }
            }
        }catch (Exception e){
            System.out.println("Hubo un error en el servicio actualizando las casas");
        }
    }

    public void contarCasas(){
        System.out.println("contando casas");
        new CasaDAO().contarCasasPorPais();
    }
}
