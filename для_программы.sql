CREATE DATABASE ZooDatabase;
USE ZooDatabase;

-- Таблица "Животные"
CREATE TABLE Animals (
    AnimalID INT AUTO_INCREMENT PRIMARY KEY,
    AnimalType VARCHAR(50) NOT NULL
);

-- Таблицы для домашних животных
CREATE TABLE Dogs (
    DogID INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(50) NOT NULL,
    Command VARCHAR(100),
    Birthdate DATE,
    AnimalID INT,
    FOREIGN KEY (AnimalID) REFERENCES Animals(AnimalID)
);

CREATE TABLE Cats (
    CatID INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(50) NOT NULL,
    Command VARCHAR(100),
    Birthdate DATE,
    AnimalID INT,
    FOREIGN KEY (AnimalID) REFERENCES Animals(AnimalID)
);

CREATE TABLE Hamsters (
    HamsterID INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(50) NOT NULL,
    Command VARCHAR(100),
    Birthdate DATE,
    AnimalID INT,
    FOREIGN KEY (AnimalID) REFERENCES Animals(AnimalID)
);

-- Таблицы для вьючных животных
CREATE TABLE Horses (
    HorseID INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(50) NOT NULL,
    Command VARCHAR(100),
    Birthdate DATE,
    AnimalID INT,
    FOREIGN KEY (AnimalID) REFERENCES Animals(AnimalID)
);

CREATE TABLE Camels (
    CamelID INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(50) NOT NULL,
    Command VARCHAR(100),
    Birthdate DATE,
    AnimalID INT,
    FOREIGN KEY (AnimalID) REFERENCES Animals(AnimalID)
);

CREATE TABLE Donkeys (
    DonkeyID INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(50) NOT NULL,
    Command VARCHAR(100),
    Birthdate DATE,
    AnimalID INT,
    FOREIGN KEY (AnimalID) REFERENCES Animals(AnimalID)
);

INSERT INTO Animals (AnimalType) VALUES ('Домашние');
INSERT INTO Dogs (Name, Command, Birthdate, AnimalID) VALUES ('Барон', 'Сидеть', '2018-05-10', 1);
INSERT INTO Cats (Name, Command, Birthdate, AnimalID) VALUES ('Мурка', 'Ловить мышей', '2019-02-15', 1);
INSERT INTO Hamsters (Name, Command, Birthdate, AnimalID) VALUES ('Шарик', NULL, '2020-07-20', 1);


INSERT INTO Animals (AnimalType) VALUES ('Вьючные');
INSERT INTO Horses (Name, Command, Birthdate, AnimalID) VALUES ('Буран', 'Тянуть упряжку', '2015-04-03', 2);
INSERT INTO Camels (Name, Command, Birthdate, AnimalID) VALUES ('Саид', 'Перевозить грузы', '2017-09-22', 2);
INSERT INTO Donkeys (Name, Command, Birthdate, AnimalID) VALUES ('Ассоль', 'Нести грузы', '2019-11-18', 2);