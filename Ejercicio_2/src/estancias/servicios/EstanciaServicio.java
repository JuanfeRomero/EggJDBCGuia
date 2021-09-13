package estancias.servicios;

import estancias.entidades.Casa;
import estancias.entidades.Cliente;
import estancias.entidades.Estancia;
import estancias.persistencias.EstanciaDAO;

import java.util.List;

public class EstanciaServicio {
    public void clientesEstanciados(){
        try {
            List<Estancia> estancias = new EstanciaDAO().obtenerEstancias();

            for (Estancia estancia: estancias) {
                Casa casa = estancia.getCasa();
                Cliente cliente = estancia.getCliente();
                System.out.printf("Estancia %d. Cliente %s de %s, %s. Casa %d en %s %d tipo %s\n", estancia.getId(), cliente.getNombre(), cliente.getCiudad(), cliente.getPais() ,casa.getId(), casa.getCalle(), casa.getNumero(), casa.getTipo_vivienda());
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
