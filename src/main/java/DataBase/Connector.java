package DataBase;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class Connector {
    private static Connection connection;
    public static Connection getConnection(){

        Properties readerFile = new Properties();

        try {
            readerFile.load(new FileInputStream("dataConnection.properties"));
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection= DriverManager.getConnection(
                    readerFile.getProperty("url") +
                            readerFile.getProperty("database"),
                    readerFile.getProperty("user"),
                    readerFile.getProperty("password"));
            System.out.println("Connected");
//            Statement st;
//            ResultSet rs;
//            st = connection.createStatement();
//            rs = st.executeQuery("Select * from alumnos");
//            while (rs.next()){
//                System.out.println(rs.getString("name"));
//            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return connection;
    }


}
