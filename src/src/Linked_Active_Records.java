package src;

import java.sql.*;
import java.util.Set;
import java.util.TreeSet;

public class Linked_Active_Records {

    private Connection connection;

    public Linked_Active_Records() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/video8", "root", "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Set<String> getInitialRecords() {
        String query = "SELECT DISTINCT POBLACIÓN FROM CLIENTES";
        Set<String> poblaciones = new TreeSet<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String poblacion = resultSet.getString("POBLACIÓN");
                poblaciones.add(poblacion);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return poblaciones;
    }

    public Set<String> getFinalRecords(Object object) {
        Set<String> empresas = new TreeSet<>();
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("SELECT DISTINCT EMPRESA FROM CLIENTES WHERE POBLACIÓN = ?");
            preparedStatement.setString(1, (String)object);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String empresa = resultSet.getString("EMPRESA");
                empresas.add(empresa);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return empresas;
    }
}

