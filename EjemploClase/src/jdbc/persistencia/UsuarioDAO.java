package jdbc.persistencia;

import jdbc.entidad.Usuario;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO extends DAO{

    public void guardarUsuario(Usuario usuario) throws Exception{
        try {
            if(usuario == null){
                throw new Exception("Usuario inválido");
            }

            String plantilla = "INSERT INTO usuario(correo, nombre, apellido) VALUES ('%s', '%s', '%s')";

            String sql = String.format(plantilla, usuario.getCorreo(), usuario.getNombre(), usuario.getApellido());

            insertarModificarEliminar(sql);
        }catch (Exception e){
            System.out.println(e.getMessage());
            throw new Exception("Error al guardar usuario");
        }
    }

    public void modificarUsuario(Usuario usuario) throws Exception{
        try {
            if(usuario == null){
                throw new Exception("Usuario inválido");
            }

            String plantilla = "UPDATE usuario" +
                    "SET nombre ='%s', apellido = '%s'" +
                    "WHERE correo = '%s'";

            String sql = String.format(plantilla, usuario.getNombre(), usuario.getApellido(), usuario.getCorreo());

            insertarModificarEliminar(sql);
        }catch (Exception e){
            System.out.println(e.getMessage());
            throw new Exception("Error al modificar usuario");
        }
    }

    public void eliminarUsuario(String correo) throws Exception{
        try {
            String plantilla = "DELETE usuario" +
                    "WHERE correo = '%s'";

            String sql = String.format(plantilla, correo);

            insertarModificarEliminar(sql);
        }catch (Exception e){
            System.out.println(e.getMessage());
            throw new Exception("Error al eliminar usuario");
        }
    }

    public List<Usuario> obtenerUsuario() throws Exception{
        String sql = "SELECT correo, nombre, apellido FROM usuario";

        try {
            consultarBase(sql);

            List<Usuario> usuarios = new ArrayList<>();

            while(resultado.next()){
                Usuario usuario = new Usuario();

                usuario.setCorreo(resultado.getString(1));
                usuario.setNombre(resultado.getString(2));
                usuario.setApellido(resultado.getString(3));

                usuarios.add(usuario);
            }

            return usuarios;
        }catch (SQLException e) {
            throw new Exception();
        }finally {
            desconectarBase();
        }
    }
}
