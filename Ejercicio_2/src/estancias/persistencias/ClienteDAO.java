package estancias.persistencias;

import estancias.entidades.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteDAO extends DAO{
    public Cliente obtenerCliente(int id_cliente) throws Exception{

        try {
            String query = "SELECT id_cliente, nombre, calle, numero, codigo_postal, ciudad, pais, email FROM clientes " +
                    "WHERE id_cliente = " + id_cliente + ";";

            consultarBase(query);

            Cliente cliente = new Cliente();
            while (resultado.next()){
                cliente.setId(resultado.getInt(1));
                cliente.setNombre(resultado.getString(2));
                cliente.setCalle(resultado.getString(3));
                cliente.setNumero(resultado.getInt(4));
                cliente.setCodigo_postal(resultado.getString(5));
                cliente.setCiudad(resultado.getString(6));
                cliente.setPais(resultado.getString(7));
                cliente.setEmail(resultado.getString(8));
            }
            return cliente;

        }catch (Exception e){
            e.printStackTrace();
            throw new Exception("Hubo un problema trayendo un cliente con el id: " + id_cliente);
        }finally {
            desconectarBase();
        }
    }

    public List<Cliente> obtenerClientes() throws Exception{

        try {
            List<Cliente> lista = new ArrayList<>();
            String query = "SELECT id_cliente FROM clientes";

            consultarBase(query);

            while (resultado.next()){
                Cliente cliente = obtenerCliente(resultado.getInt(1));

                lista.add(cliente);
            }
            return lista;

        }catch (Exception e){
            e.printStackTrace();
            throw new Exception("Hubo un problema trayendo la lista de clientes");
        }finally {
            desconectarBase();
        }
    }
}
