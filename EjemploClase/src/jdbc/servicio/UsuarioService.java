package jdbc.servicio;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import jdbc.entidad.Usuario;
import jdbc.persistencia.UsuarioDAO;

import java.util.List;

public class UsuarioService {

    private UsuarioDAO usuarioDAO;

    public UsuarioService(){
        usuarioDAO = new UsuarioDAO();
    }

    public void crearUsuario(String correo, String nombre, String apellido) throws Exception{
        try {
            if(!correo.matches("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)])")){
                throw new Exception("Debe ingresar un correo");
            }

            if(nombre == null || nombre.trim().isEmpty()){
                throw new Exception("Debe ingresar un nombre");
            }

            if(apellido == null || apellido.trim().isEmpty()){
                throw new Exception("Debe ingresar un apellido");
            }

            Usuario usuario = new Usuario();

            usuario.setApellido(apellido);
            usuario.setNombre(nombre);
            usuario.setCorreo(correo);

            usuarioDAO.guardarUsuario(usuario);
        }catch (Exception e){
            throw e;
        }
    }

    public void imprimirUsuarios() throws Exception {
        try {
            List<Usuario> usuarios = usuarioDAO.obtenerUsuario();

            if(usuarios.isEmpty()){
                throw new Exception("No existen usuarios");
            }else {
                System.out.println("**** LISTA DE USUARIOS ****");
                System.out.printf("%-25s%-15s%15s\n", "CORREO", "NOMBRE", "APELLIDO");
                for(Usuario usuario: usuarios){
                    System.out.printf("%-25s%-15s%15s\n", usuario.getCorreo(), usuario.getNombre(), usuario.getApellido());
                }
            }
        }catch (Exception e){
            throw e;
        }
    }


}
