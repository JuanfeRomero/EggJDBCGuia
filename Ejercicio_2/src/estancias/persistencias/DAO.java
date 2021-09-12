package estancias.persistencias;

import java.sql.*;

public class DAO {
    protected Connection conexion = null;
    protected Statement sentencia = null;
    protected ResultSet resultado = null;

    private final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private final String URL = "jdbc:mysql://localhost:3306/estancias_exterior?useSSL=false";
    private final String USUARIO = "root";
    private final String CLAVE = "password";

    public void conectarBase() throws Exception{
        try {
            Class.forName(DRIVER);
            conexion = DriverManager.getConnection(URL, USUARIO, CLAVE);
        }catch (ClassNotFoundException | SQLException e){
            System.out.println(e.getMessage());
            throw new Exception("Error al conectarse");
        }
    }

    public void desconectarBase() throws Exception{
        try {
            if(resultado != null){
                resultado.close();
            }
            if(sentencia != null){
                sentencia.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        }catch (SQLException e){
            throw new Exception(e.getMessage());
        }
    }

    public void insertarModificarEliminar(String sql) throws Exception{
        try {
            conectarBase();
            sentencia = conexion.createStatement();
            sentencia.executeUpdate(sql);
        }catch (SQLException e){
            try {
                conexion.rollback();
            }catch (SQLException ex){
                throw new Exception("Error al ejecutar rollback");
            }
            throw new Exception("Error al ejecutar sentencia");
        } finally {
            desconectarBase();
        }
    }

    public void consultarBase(String sql) throws Exception{
        try {
            conectarBase();
            sentencia = conexion.createStatement();
            resultado = sentencia.executeQuery(sql);
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new Exception("Error al consultar");
        }
    }
}
