package vsu.kiryanovaleksey.onesix;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        double x = readDoubleValueFromConsole("x");
        int n = readNaturalValueFromConsole("n");

        System.out.println("По количеству итераций  " + calcExp(x, n));
        System.out.println("По размеру элемента " + calcExp(x));
    }

    public static double calcExp(double x, int n) {
        boolean iteration = true;
        double last = x * x;
        double rez = 1 - last;

        for (int i = 2; i <= n; i++) {
            last = last * x * x / i;

            if (iteration) {
                rez += last;
            } else {
                rez -= last;
            }

            iteration = !iteration;

        }

        return rez;
    }

    public static double calcExp(double x) {
        boolean iteration = true;
        double last = x * x;
        double rez = 1 - last;

        int i = 2;
        double ESP = 1e-10;

        do {
            last = last * x * x / i;
            i++;

            if (iteration) {
                rez += last;
            } else {
                rez -= last;
            }

            iteration = !iteration;

        } while (last >= ESP);


        return rez;
    }

    public static double readDoubleValueFromConsole(String varName) {
        Scanner scanner = new Scanner(System.in);
        double a = 0;
        while (true) {
            System.out.printf("Введите действительное число %s = ", varName);
            try {
                String line = scanner.nextLine();
                a = Double.parseDouble(line);
                return a;
            } catch (Exception e) {
                System.out.println("Введено не число.");
            }
        }
    }

    public static int readNaturalValueFromConsole(String varName) {
        Scanner scanner = new Scanner(System.in);
        int a = 0;
        while (true) {
            System.out.printf("Введите натуральное число %s = ", varName);
            try {
                String line = scanner.nextLine();
                a = Integer.parseInt(line);
                if (a > 0) {
                    return a;
                } else {
                    System.out.println("Нужно ввести натуральное число.");
                }
            } catch (Exception e) {
                System.out.println("Введено не число.");
            }
        }
    }
}
