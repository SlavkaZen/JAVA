import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("1 — Площадь");
        System.out.println("2 — треугольник");
        System.out.println("3 — Переворот");
        System.out.println("Выберите:");

        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                System.out.print("радиус: ");
                double r = sc.nextDouble();
                double s = Math.PI * r * r;
                System.out.println("Площадь круга: " + s);
                break;

            case 2:
                System.out.print("Введите  a: ");
                double a = sc.nextDouble();

                System.out.print("Введите  b: ");2
                double b = sc.nextDouble();

                System.out.print("Введите  c: ");
                double c = sc.nextDouble();

                boolean exists = (a + b > c) && (a + c > b) && (b + c > a);

                if (exists) {
                    System.out.println("существует");
                } else {
                    System.out.println("НЕ существует");
                }
                break;

            case 3:
                System.out.print("Введите число: ");
                int n = sc.nextInt();

                int reversed = 0;
                while (n != 0) {
                    int digit = n % 10;
                    reversed = reversed * 10 + digit;
                    n /= 10;
                }

                System.out.println("Перевернутое число: " + reversed);
                break;

            default:
                System.out.println("Нет такого");
        }
    }
}
