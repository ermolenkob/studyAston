package lesson2;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class FileManager {

    /**
     * Записывает данные в файл
     * @param filePath путь к файлу
     * @param data данные для записи
     * @param append true - дописать в конец, false - перезаписать файл
     * @throws FileOperationException если произошла ошибка при записи
     */
    public static void writeToFile(String filePath, String data, boolean append)
            throws FileOperationException {

        try (BufferedWriter writer = Files.newBufferedWriter(
                Paths.get(filePath),
                append ? StandardOpenOption.APPEND : StandardOpenOption.CREATE,
                StandardOpenOption.WRITE)) {

            writer.write(data);
            writer.newLine();

        } catch (IOException e) {
            throw new FileOperationException(
                    "Ошибка записи в файл: " + filePath, e);
        }
    }

    /**
     * Читает все данные из файла
     * @param filePath путь к файлу
     * @return список строк из файла
     * @throws FileOperationException если произошла ошибка при чтении
     */
    public static List<String> readFromFile(String filePath)
            throws FileOperationException {

        List<String> lines = new ArrayList<>();

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(filePath))) {

            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }

        } catch (NoSuchFileException e) {
            throw new FileOperationException(
                    "Файл не найден: " + filePath, e);
        } catch (IOException e) {
            throw new FileOperationException(
                    "Ошибка чтения файла: " + filePath, e);
        }

        return lines;
    }

    /**
     * Читает файл и возвращает содержимое в виде одной строки
     * @param filePath путь к файлу
     * @return содержимое файла как строка
     * @throws FileOperationException если произошла ошибка при чтении
     */
    public static String readFileAsString(String filePath)
            throws FileOperationException {

        StringBuilder content = new StringBuilder();

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(filePath))) {

            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }

        } catch (NoSuchFileException e) {
            throw new FileOperationException(
                    "Файл не найден: " + filePath, e);
        } catch (IOException e) {
            throw new FileOperationException(
                    "Ошибка чтения файла: " + filePath, e);
        }

        return content.toString();
    }
}