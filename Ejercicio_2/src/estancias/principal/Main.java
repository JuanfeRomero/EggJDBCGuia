package estancias.principal;

import estancias.servicios.CasaServicio;
import estancias.servicios.EstanciaServicio;
import estancias.servicios.FamiliaServicio;


public class Main {
    public static void main(String[] args) {
        try{
            EstanciaServicio servicio = new EstanciaServicio();

            servicio.clientesEstanciados();
        }catch (Exception e){
            System.out.println("ERROR EN EL SERVICIO");
        }
    }
}
