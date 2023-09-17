package projectZoo.src.main.java;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class AddAnimal {
    public static void addNewAnimal(Connection connection, Counter counter) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите тип животного:");
        System.out.println("1. Собака");
        System.out.println("2. Кошка");
        System.out.println("3. Хомяк");
        System.out.println("4. Верблюд");
        System.out.println("5. Осел");
        System.out.println("6. Лошадь");
        int animalTypeChoice = scanner.nextInt();

        scanner.nextLine();

        System.out.print("Имя: ");
        String name = scanner.nextLine();
        System.out.print("Команда: ");
        String command = scanner.nextLine();
        System.out.print("Дата рождения (гггг-мм-дд): ");
        String birthdateStr = scanner.nextLine();

        String insertQuery;

        switch (animalTypeChoice) {
            case 1:
                insertQuery = "INSERT INTO Dogs (Name, Command, Birthdate, AnimalID) VALUES (?, ?, ?, 1)";
                break;
            case 2:
                insertQuery = "INSERT INTO Cats (Name, Command, Birthdate, AnimalID) VALUES (?, ?, ?, 1)";
                break;
            case 3:
                insertQuery = "INSERT INTO Hamsters (Name, Command, Birthdate, AnimalID) VALUES (?, ?, ?, 1)";
                break;
            case 4:
                insertQuery = "INSERT INTO Camels (Name, Command, Birthdate, AnimalID) VALUES (?, ?, ?, 2)";
                break;
            case 5:
                insertQuery = "INSERT INTO Donkeys (Name, Command, Birthdate, AnimalID) VALUES (?, ?, ?, 2)";
                break;
            case 6:
                insertQuery = "INSERT INTO Horses (Name, Command, Birthdate, AnimalID) VALUES (?, ?, ?, 2)";
                break;
            default:
                System.out.println("Неверный выбор типа животного.");
                return;
        }

        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, command);
            preparedStatement.setString(3, birthdateStr);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Новое животное успешно добавлено.");
                counter.add();
            } else {
                System.out.println("Не удалось добавить новое животное.");
            }
        }
    }
}
