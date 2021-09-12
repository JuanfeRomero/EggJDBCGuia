package EjemploJDBCLibrary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tienda", "root", "password");

            Statement statement = con.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM producto");

            while(resultSet.next()){
                System.out.println(resultSet.getString("nombre"));
                System.out.println(resultSet.getString("codigo"));
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
