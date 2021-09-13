package estancias.servicios;

import estancias.entidades.Comentario;
import estancias.persistencias.ComentarioDAO;

import java.util.List;

public class ComentarioServicio {
    public void encontrarCasasLimpias() throws Exception {
        try {
            System.out.println("Mostrando Casas Limpias en el Reino Unido");

            List<Comentario> comentarios = new ComentarioDAO().obtenerComentarios();

            for (Comentario comentario: comentarios) {
                if(comentario.getCasa().getPais().equalsIgnoreCase("Reino Unido") && comentario.getMensaje().contains("limpi")){
                    System.out.println(comentario);
                }
            }
        }catch (Exception e){

        }
    }
}
