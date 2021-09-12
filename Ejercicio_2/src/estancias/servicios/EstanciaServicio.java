package estancias.servicios;

import estancias.entidades.Casa;
import estancias.entidades.Estancia;
import estancias.persistencias.EstanciaDAO;

import java.util.List;

public class EstanciaServicio {
    public void clientesEstanciados(){
        try {
            List<Estancia> estancias = new EstanciaDAO().obtenerEstancias();

            for (Estancia estancia: estancias) {
                Casa casa = estancia.getCasa();
                System.out.printf("Estancia %d. Cliente %s. Casa %d en %s %d tipo %s\n", estancia.getId(), estancia.getCliente().getNombre(), casa.getId(), casa.getCalle(), casa.getNumero(), casa.getTipo_vivienda());
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
