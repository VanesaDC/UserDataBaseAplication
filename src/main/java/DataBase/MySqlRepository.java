package DataBase;

import Domain.*;
import com.UI.AlertPanel;

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
            statement.setString(1, user.getDni().getString());
            statement.setString(2, user.getName().getString());
            statement.setString(3, user.getAge().getString());
            statement.setString(4, user.getEmail().getString());

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
        String query = "UPDATE alumnos SET name=?, age=?, email=? WHERE dni= '"+user.getDni().getString()+"'";
        Connection connection = Connector.getConnection();
        System.out.println(user.toString());
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, user.getName().getString());
            statement.setString(2, user.getAge().getString());
            statement.setString(3, user.getEmail().getString());

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                AlertPanel.showInformationMessageSaying("El usuario se actualizó con éxito");
            }
            connection.close();
        } catch (SQLException e) {
            AlertPanel.showAttentionMessageSaying("Sucedió un error al tratar de cambiar los datos en la base de datos"+e);
        }

    }

    @Override
    public void deleteUser(User user) {
    }

    @Override
    public List<User> getUserByDni(String dniSelected) {
        String query = "SELECT * FROM alumnos WHERE dni= '" + dniSelected+ "'";
        Connection connection;
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
