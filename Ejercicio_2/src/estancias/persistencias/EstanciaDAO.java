package estancias.persistencias;

import estancias.entidades.Cliente;
import estancias.entidades.Estancia;

import java.util.ArrayList;
import java.util.List;

public class EstanciaDAO extends DAO{

    public List<Estancia> obtenerEstancias() throws Exception{

        try {
            String query = "SELECT id_estancia, id_cliente, id_casa, nombre_huesped, fecha_desde, fecha_hasta FROM estancias;";
            consultarBase(query);
            List<Estancia> lista = new ArrayList<>();

            while (resultado.next()){
                Estancia estancia = new Estancia();

                estancia.setId(resultado.getInt(1));
                estancia.setCliente(new ClienteDAO().obtenerCliente(resultado.getInt(2)));
                estancia.setCasa(new CasaDAO().obtenerUnaCasa(resultado.getInt(3)));
                estancia.setNombre_huesped(resultado.getString(4));
                estancia.setFecha_desde(resultado.getDate(5).toLocalDate());
                estancia.setFecha_hasta(resultado.getDate(6).toLocalDate());

                lista.add(estancia);
            }
            return lista;

        }catch (Exception e){
            e.printStackTrace();
            throw new Exception("Hubo un problema trayendo la lista de estancias");
        }finally {
            desconectarBase();
        }
    }
}
