package estancias.persistencias;

import estancias.entidades.Casa;

import java.util.ArrayList;
import java.util.List;

public class CasaDAO extends DAO{

    public Casa obtenerUnaCasa(int id_casa) throws Exception {
        Casa casa = new Casa();

        try {
            String query = "SELECT id_casa, calle, numero, codigo_postal, ciudad, pais, fecha_desde, fecha_hasta, tiempo_minimo, tiempo_maximo, precio_habitacion, tipo_vivienda FROM casas " +
                    "WHERE id_casa = " + id_casa + ";";

            consultarBase(query);

            while (resultado.next()){
                casa.setId(resultado.getInt(1));
                casa.setCalle(resultado.getString(2));
                casa.setNumero(resultado.getInt(3));
                casa.setCodigo_postal(resultado.getString(4));
                casa.setCiudad(resultado.getString(5));
                casa.setPais(resultado.getString(6));
                casa.setFecha_desde(resultado.getDate(7).toLocalDate());
                casa.setFecha_hasta(resultado.getDate(8).toLocalDate());
                casa.setTiempo_minimo(resultado.getInt(9));
                casa.setTiempo_maximo(resultado.getInt(10));
                casa.setPrecio_habitacion(resultado.getInt(11));
                casa.setTipo_vivienda(resultado.getString(12));
            }

            return casa;

        }catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Hubo un problema trayendo una casa con el id: " + id_casa);
        }finally {
            desconectarBase();
        }
    }

    public List<Casa> obtenerCasas() throws Exception {

        try {
            List<Casa> casas = new ArrayList<>();

            String query = "SELECT id_casa FROM casas;";

            consultarBase(query);

            while (resultado.next()){
                Casa casa = obtenerUnaCasa(resultado.getInt(1));
                casas.add(casa);
            }

            return casas;

        }catch (Exception e){
            e.printStackTrace();
            throw new Exception("Hubo un problema trayendo una lista de casas");
        }finally {
            desconectarBase();
        }
    }
}
