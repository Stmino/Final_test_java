package projectZoo.src.main.java;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class AnimalInfo {
    public static void displayAnimalInfo(Statement statement) throws SQLException {
        String query = "SELECT * FROM Dogs UNION SELECT * FROM Cats UNION SELECT * FROM Hamsters " +
                "UNION SELECT * FROM Horses UNION SELECT * FROM Camels UNION SELECT * FROM Donkeys";
        ResultSet resultSet = statement.executeQuery(query);
        System.out.println("Информация о животных:");
        while (resultSet.next()) {
            System.out.println("ID: " + resultSet.getInt("AnimalID"));
            System.out.println("Имя: " + resultSet.getString("Name"));
            System.out.println("Команда: " + resultSet.getString("Command"));
            System.out.println("Дата рождения: " + resultSet.getDate("Birthdate"));
            System.out.println("--------------------------");
        }
    }
}
