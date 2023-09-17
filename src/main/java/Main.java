package projectZoo.src.main.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/ZooDatabase";
        String username = "root";
        String password = "root";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
             Statement statement = connection.createStatement();
             Counter counter = new Counter()) {

            Scanner scanner = new Scanner(System.in);
            int choice;

            do {
                System.out.println("Меню:");
                System.out.println("1. Вывести информацию о животных");
                System.out.println("2. Добавить новое животное");
                System.out.println("3. Выход");
                System.out.print("Выберите опцию: ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        AnimalInfo.displayAnimalInfo(statement);
                        break;
                    case 2:
                        AddAnimal.addNewAnimal(connection, counter);
                        break;
                    case 3:
                        System.out.println("Выход из программы.");
                        break;
                    default:
                        System.out.println("Неправильный выбор. Пожалуйста, выберите снова.");
                }
            } while (choice != 3);

            scanner.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
