package org.example;
import java.util.Locale;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== МЕНЮ ===");
            System.out.println("1. Информация о любимом фильме");
            System.out.println("2. 10 целых чисел, сумма положительных");
            System.out.println("3. Разделение чисел по остатку от деления на 3");
            System.out.println("4. Средний рост учеников");
            System.out.println("5. Количество чисел больше 50");
            System.out.println("0. Выход");
            System.out.print("Выберите задание: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> task1();
                case 2 -> task2();
                case 3 -> task3();
                case 4 -> task4();
                case 5 -> task5();
                case 0 -> {
                    System.out.println("Выход из программы.");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Неверный выбор. Повторите.");
            }
        }
    }

    // Задание 1
    static void task1() {
        String filename = "movie.txt";

        try (FileWriter writer = new FileWriter(filename)) {
            writer.write("Название: Интерстеллар\n");
            writer.write("Год: 2014\n");
            writer.write("Режиссер: Кристофер Нолан\n");
            writer.write("Жанр: Фантастика, драма\n");
            writer.write("Рейтинг: 8.6\n");
        } catch (IOException e) {
            System.out.println("Ошибка записи: " + e.getMessage());
        }

        File file = new File(filename);
        System.out.println("\n=== Данные о файле ===");
        System.out.println("Имя: " + file.getName());
        System.out.println("Путь: " + file.getAbsolutePath());
        System.out.println("Размер: " + file.length() + " байт");

        System.out.println("\n=== Содержимое файла ===");
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Ошибка чтения: " + e.getMessage());
        }
    }

    // Задание 2
    static void task2() {
        String filename = "f2.txt";

        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            System.out.println("Введите 10 целых чисел:");
            for (int i = 0; i < 10; i++) {
                System.out.print("Число " + (i + 1) + ": ");
                int num = scanner.nextInt();
                writer.println(num);
            }
        } catch (IOException e) {
            System.out.println("Ошибка записи: " + e.getMessage());
        }

        int sum = 0;
        System.out.println("\nЧисла из файла:");
        try (Scanner fileScanner = new Scanner(new File(filename))) {
            while (fileScanner.hasNextInt()) {
                int num = fileScanner.nextInt();
                System.out.print(num + " ");
                if (num > 0) {
                    sum += num;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + e.getMessage());
        }
        System.out.println("\nСумма положительных чисел: " + sum);
    }

    // Задание 3
    static void task3() {
        Random random = new Random();

        try (PrintWriter writer = new PrintWriter(new FileWriter("f3.txt"))) {
            for (int i = 0; i < 20; i++) {
                writer.println(random.nextInt(100) - 50);
            }
        } catch (IOException e) {
            System.out.println("Ошибка записи f3: " + e.getMessage());
        }

        try (Scanner sc = new Scanner(new File("f3.txt"));
             PrintWriter g = new PrintWriter(new FileWriter("g.txt"));
             PrintWriter h = new PrintWriter(new FileWriter("h.txt"))) {

            System.out.println("Числа в файле f3:");
            while (sc.hasNextInt()) {
                int num = sc.nextInt();
                System.out.print(num + " ");
                int remainder = ((num % 3) + 3) % 3;
                if (remainder == 1) {
                    g.println(num);
                } else {
                    h.println(num);
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        System.out.println("\n\nФайл g (остаток 1 при делении на 3):");
        printIntFile("g.txt");
        System.out.println("\nФайл h (остальные):");
        printIntFile("h.txt");
    }

    // Задание 4
    static void task4() {
        String filename = "rost.txt";

        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            System.out.println("Введите рост 14 учеников (см):");
            for (int i = 0; i < 14; i++) {
                System.out.print("Ученик " + (i + 1) + ": ");
                double height = scanner.nextDouble();

                if(height<=0){System.out.println("oшибка");
                break;}

                writer.println(height);
            }
        } catch (IOException e) {
            System.out.println("Ошибка записи: " + e.getMessage());
        }

        double sum = 0;
        int count = 0;
        try (Scanner fileScanner = new Scanner(new File(filename))) {
            fileScanner.useLocale(Locale.US);   // <-- добавьте эту строку
            while (fileScanner.hasNextDouble()) {
                sum += fileScanner.nextDouble();
                count++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + e.getMessage());
        }

        // после записи файла
        System.out.println("DEBUG: файл записан, выходим из цикла");

// после чтения
        System.out.println("DEBUG: count = " + count + ", sum = " + sum);

        if (count > 0) {
            System.out.printf("Средний рост: %.2f см%n", sum / count);
        } else {
            System.out.println("DEBUG: count == 0, среднее не считается");
        }
    }

    // Задание 5
    static void task5() {
        Random random = new Random();
        String filename = "f5.txt";

        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (int i = 0; i < 10; i++) {
                writer.println(random.nextInt(100));
            }
        } catch (IOException e) {
            System.out.println("Ошибка записи: " + e.getMessage());
        }

        int count = 0;
        System.out.println("Числа в файле:");
        try (Scanner sc = new Scanner(new File(filename))) {
            while (sc.hasNextInt()) {
                int num = sc.nextInt();
                System.out.print(num + " ");
                if (num > 50) {
                    count++;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + e.getMessage());
        }
        System.out.println("\nКоличество чисел больше 50: " + count);
    }

    // Вспомогательный метод для вывода целочисленного файла
    static void printIntFile(String filename) {
        try (Scanner sc = new Scanner(new File(filename))) {
            while (sc.hasNextInt()) {
                System.out.print(sc.nextInt() + " ");
            }
            System.out.println();
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + filename);
        }
    }
}