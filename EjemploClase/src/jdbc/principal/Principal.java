package jdbc.principal;

import jdbc.persistencia.DAO;
import jdbc.servicio.UsuarioService;

public class Principal {
    public static void main(String[] args) {
        UsuarioService servicio = new UsuarioService();

        try{
            servicio.crearUsuario("juanfe@romero.com","Juanfe","Romero");
            servicio.crearUsuario("facundo@benitez.com", "Facundo", "Benitez");
            servicio.crearUsuario("donato@abramo.com", "Donato", "Abramo");

            servicio.imprimirUsuarios();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
