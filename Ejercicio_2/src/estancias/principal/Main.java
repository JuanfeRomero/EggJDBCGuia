package estancias.principal;

import estancias.servicios.CasaServicio;
import estancias.servicios.ComentarioServicio;
import estancias.servicios.EstanciaServicio;
import estancias.servicios.FamiliaServicio;

import java.time.LocalDate;


public class Main {
    public static void main(String[] args) {
        try{
            //FamiliaServicio servicio = new FamiliaServicio();
            //CasaServicio servicio = new CasaServicio();
            //ComentarioServicio servicio = new ComentarioServicio();
            //servicio.encontrarCasasLimpias();

        }catch (Exception e){
            System.out.println("ERROR EN EL SERVICIO");
        }
    }
}
