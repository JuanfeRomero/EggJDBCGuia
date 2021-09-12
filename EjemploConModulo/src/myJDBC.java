import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class myJDBC {
    public static void main(String[] args) {
        try {
            Connection connection  = DriverManager.getConnection("jdbc:mysql://localhost:3306/tienda", "root", "password");

            Statement statement = connection.createStatement();

            ResultSet resultset = statement.executeQuery("SELECT * FROM producto");

            while(resultset.next()){
                System.out.println(resultset.getString("nombre"));
            }
        }catch (Exception e){
            System.out.println("hubo un error");
        }
    }
}
