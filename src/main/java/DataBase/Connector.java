package DataBase;

import com.UI.AlertPanel;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class Connector {

    public static Connection getConnection(){
        Connection connection = null;
        Properties properties = new Properties();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            properties.load(new FileInputStream("ConnectionData.properties"));
            connection= DriverManager.getConnection(properties.getProperty("url") +
                            properties.getProperty("dataBaseName"),
                            properties.getProperty("userName"),
                            properties.getProperty("password"));
            System.out.println("Connected");
        } catch (Exception e) {
            AlertPanel.showAttentionMessageSaying("No se pudo establecer conexión con la base de datos");
        }
        return connection;
    }


}
