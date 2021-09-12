package estancias.persistencias;

import estancias.entidades.Familia;

import java.util.ArrayList;
import java.util.List;

public class FamiliaDAO extends DAO{

    public List<Familia> obtenerFamilias() throws Exception{

        try {
            List<Familia> lista = new ArrayList<>();
            String query = "SELECT id_familia, nombre, edad_minima, edad_maxima, num_hijos, email, id_casa_familia FROM familias f";

            consultarBase(query);

            while (resultado.next()){

                Familia fam = new Familia();

                fam.setId(resultado.getInt(1));
                fam.setNombre(resultado.getString(2));
                fam.setEdad_minima(resultado.getInt(3));
                fam.setEdad_maxima(resultado.getInt(4));
                fam.setNum_hijos(resultado.getInt(5));
                fam.setEmail(resultado.getString(6));
                fam.setCasa(new CasaDAO().obtenerUnaCasa(resultado.getInt(7)));

                lista.add(fam);
            }
            return lista;

        }catch (Exception e){
            e.printStackTrace();
            throw new Exception("Hubo un problema trayendo la lista de la famlilia");
        }finally {
            desconectarBase();
        }
    }
}
