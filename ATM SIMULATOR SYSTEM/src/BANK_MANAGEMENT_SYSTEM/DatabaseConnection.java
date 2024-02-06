package BANK_MANAGEMENT_SYSTEM;
import java.sql.*;
public class DatabaseConnection {

    Connection c;
    Statement s;
    public DatabaseConnection() {


        try{
          //  Class.forName(com.mysql.cj.jdbc.driver);
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagementsystem","root","918233");

            s = c.createStatement();

        }
        catch(Exception e){
            System.out.println(e);
        }

    }
}
