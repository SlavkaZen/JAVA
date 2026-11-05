import java.util.Scanner;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("1 — Найти последнее 'о' ");
            System.out.println("2 — email");
            System.out.println("3 — Вывести отчёт ");
            System.out.println("4 — регулярки");
            System.out.println("0 — Выход");
            System.out.print("Ваш выбор: ");

            int choice = sc.nextInt();
            System.out.println();

            switch (choice) {

                case 1:
                    System.out.println("Введите слово:");
                    String s = sc.next();
                    int index = s.lastIndexOf('о');
                    System.out.println("Последняя позиция 'о': " + index);
                    System.out.println();
                    break;

                case 2:
                    System.out.println("Введите email:");
                    String email = sc.next();

                    int at = email.indexOf('@');
                    int dot = email.indexOf('.', at + 1);
                    boolean isValid = at != -1 && dot != -1;

                    System.out.println("Email корректен: " + isValid);
                    System.out.println();
                    break;

                case 3:
                    Employee[] arr = {
                            new Employee("Ivan", 50000.5),
                            new Employee("Petr", 72000.75),
                            new Employee("Sanya", 65000.0)
                    };
                    Report.generateReport(arr);
                    System.out.println();
                    break;

                case 4:
                    String text = "a1aa22aa333aa4444aa55555a";

                    Pattern p = Pattern.compile("a[2-5]+a");
                    Matcher m = p.matcher(text);

                    System.out.println("Совпадения:");
                    while (m.find()) {
                        System.out.println(m.group());
                    }
                    System.out.println();
                    break;

                case 0:
                    System.out.println("Выход...");
                    return;

                default:
                    System.out.println("Нет такого пункта меню.");
                    System.out.println();
            }
        }
    }
}
