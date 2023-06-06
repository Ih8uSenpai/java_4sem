package com.example.practice12;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@SpringBootApplication
public class Practice12Application {
    static BufferedWriter writer;
    static BufferedReader reader;
    static Path filePath;

    @PostConstruct
    public void init() throws IOException, NoSuchAlgorithmException {
        // Создаем экземпляр MessageDigest с использованием алгоритма SHA-256
        MessageDigest digest = MessageDigest.getInstance("SHA-256");

        String line;
        // Считываем строки из исходного файла и хешируем их
        while ((line = reader.readLine()) != null) {
            // Хешируем строку с помощью метода hashString()
            writer.write(hashString(line, digest));
            // Добавляем перевод строки в выходной файл
            writer.newLine();
        }
        // Закрываем потоки чтения и записи
        reader.close();
        writer.close();
    }

    @PreDestroy
    public void destroy() throws IOException {
        // Удаляем исходный файл
        Files.delete(filePath.toAbsolutePath());
    }

    private String hashString(String input, MessageDigest digest) {
        // Преобразуем входную строку в байтовый массив
        byte[] hashBytes = digest.digest(input.getBytes(StandardCharsets.UTF_8));
        StringBuilder hashBuilder = new StringBuilder();

        // Преобразуем каждый байт хеша в шестнадцатеричную строку
        for (byte b : hashBytes) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                // Добавляем ведущий ноль, если значение шестнадцатеричной строки состоит из одной цифры
                hashBuilder.append('0');
            }
            // Добавляем шестнадцатеричную строку в построитель
            hashBuilder.append(hex);
        }

        // Возвращаем итоговый хеш в виде строки
        return hashBuilder.toString();
    }

    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            System.out.println("No arguments provided.");
            return;
        }
        // Создаем BufferedWriter для записи хешированных данных в файл
        writer = new BufferedWriter(new FileWriter(args[1]));
        // Создаем BufferedReader для чтения исходного файла
        reader = new BufferedReader(new FileReader(args[0]));
        // Получаем путь к исходному файлу
        filePath = Paths.get(args[0]);

        // Запускаем Spring Boot приложение
        SpringApplication.run(Practice12Application.class, args);
    }
}
