package DataBase;

import Domain.*;
import com.UI.AlertPanel;
import javafx.scene.control.Alert;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySqlRepository implements MySqlUserRepository {
    @Override
    public void saveUser(User user) {
        String query = "INSERT INTO alumnos (dni, name, age, email) VALUES (?, ?, ?, ?)";
        Connection connection = Connector.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, user.getDni().getDni());
            statement.setString(2, user.getName().getName());
            statement.setString(3, user.getAge().getAge());
            statement.setString(4, user.getEmail().getEmail());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                AlertPanel.showInformationMessageSaying("El usuario se guardó correctamente.");
            }
            connection.close();
            System.out.println("Disconnected");
        } catch (SQLException e) {
            AlertPanel.showAttentionMessageSaying("Ocurrió un fallo al grabar el usuario en la base de datos."+ e);
        }

    }

    @Override
    public void upDateUser(User user) {
    }

    @Override
    public void deleteUser(User user) {
    }

    @Override
    public List<User> getUserByDni(User userSolicited) {
        String query = "SELECT * FROM alumnos WHERE dni= '" + userSolicited.getDni().getDni()+"'";
        Connection connection = null;
        List<User> users = new ArrayList<>();
            try {
                connection= Connector.getConnection();
                Statement statement = connection.createStatement();
                ResultSet result = statement.executeQuery(query);
                while (result.next()) {
                    Dni dni = Dni.createDni(result.getString(1));
                    Name name = Name.createName(result.getString(2));
                    Age age = Age.createAge(result.getString(3));
                    Email email = Email.createEmail(result.getString(4));
                    User user = new User(dni, name, age, email);
                    users.add(user);
                }
                connection.close();
                System.out.println("Disconnected");
            } catch (SQLException | DniException | NameException | AgeException | EmailException e) {
                AlertPanel.showAttentionMessageSaying("Sucededió un error al buscar el usuario en la base de datos." + e);
            }
            return users;
        }



    @Override
    public List<User> getAllUser() {
        return null;
    }
}
