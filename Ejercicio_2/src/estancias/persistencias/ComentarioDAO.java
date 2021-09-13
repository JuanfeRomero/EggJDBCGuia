package estancias.persistencias;

import estancias.entidades.Comentario;

import java.util.ArrayList;
import java.util.List;

public class ComentarioDAO extends DAO{
    public List<Comentario> obtenerComentarios() throws Exception{
        try {
            List<Comentario> comentarios = new ArrayList<>();

            String query = "Select id_comentario, id_casa, comentario FROM comentarios";

            consultarBase(query);

            while (resultado.next()){
                Comentario comentario = new Comentario();

                comentario.setId(resultado.getInt(1));
                comentario.setCasa(new CasaDAO().obtenerUnaCasa(resultado.getInt(2)));
                comentario.setMensaje(resultado.getString(3));

                comentarios.add(comentario);
            }

            return comentarios;
        }catch (Exception e){
            System.out.println("Problemas trayendo los comentarios");
            throw new Exception("Error en traer comentarios");
        }finally {
            desconectarBase();
        }
    }

    public void crearEstancia() {
        // 1- mostrar la lista de clientes
        // 2- elegir uno de los clientes o crear uno nuevo (si crea nuevo, hacer crearCliente en clienteServicio
        // 3- mostrar la lista de las casas
        // 4- preguntar las fechas de inicio y fin // otra opcion es primero elegir las fechas y ahi verificar y mostrar solo las casas disponibles
        // 5- verificar las fechas con la casa seleccionada
        // 6- si la fecha no esta disponible, ofrecer cambiar la fecha o cambiar la casa
        // 7- despues de que este verificado en su totalidad, hacer la query con el insert.
    }
}
