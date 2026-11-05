import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
Random rd = new Random();
        System.out.println("1 — Проверить, есть ли число X в массиве");
        System.out.println("2 — Проверить, является ли матрица магическим квадратом");
        System.out.println("Выберите действие:");

        int choice = sc.nextInt();

        switch (choice) {

            case 1:
                System.out.print("размер массива: ");
                int n = sc.nextInt();

                int[] arr = new int[n];

                System.out.println("элементы массива:");
                for (int i = 0; i < n; i++) {
                    //arr[i] = sc.nextInt();
                    arr[i]= rd.nextInt(10) ;
                }

                System.out.print("число X: ");
                int x = sc.nextInt();

                boolean found = false;

                for (int value : arr) {
                    if (value == x) {
                        found = true;
                        break;
                    }
                }

                if (found) {
                    System.out.println("X есть в массиве");
                } else {
                    System.out.println("X нет в массиве");
                }
                break;

            case 2:
                System.out.print("размер матрицы n: ");
                int size = sc.nextInt();

                int[][] m = new int[size][size];

                System.out.println("элементы матрицы:");
                for (int i = 0; i < size; i++) {
                    for (int j = 0; j < size; j++) {
                        m[i][j] = sc.nextInt();
                    }
                }

                int magicSum = 0;
                for (int j = 0; j < size; j++) {
                    magicSum += m[0][j];
                }

                boolean isMagic = true;

                // строки
                for (int i = 1; i < size; i++) {
                    int rowSum = 0;
                    for (int j = 0; j < size; j++) {
                        rowSum += m[i][j];
                    }
                    if (rowSum != magicSum) {
                        isMagic = false;
                        break;
                    }
                }

                //  столбцы
                if (isMagic) {
                    for (int j = 0; j < size; j++) {
                        int colSum = 0;
                        for (int i = 0; i < size; i++) {
                            colSum += m[i][j];
                        }
                        if (colSum != magicSum) {
                            isMagic = false;
                            break;
                        }
                    }
                }

                //  диагональ
                if (isMagic) {
                    int diag1 = 0;
                    for (int i = 0; i < size; i++) {
                        diag1 += m[i][i];
                    }
                    if (diag1 != magicSum) {
                        isMagic = false;
                    }
                }

                // вторая диагональ
                if (isMagic) {
                    int diag2 = 0;
                    for (int i = 0; i < size; i++) {
                        diag2 += m[i][size - 1 - i];
                    }
                    if (diag2 != magicSum) {
                        isMagic = false;
                    }
                }

                if (isMagic) {
                    System.out.println("Матрица является магическим квадратом");
                } else {
                    System.out.println("Матрица НЕ является магическим квадратом");
                }
                break;

            default:
                System.out.println("Нет такого пункта меню");
        }
    }
}
