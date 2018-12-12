package Var_A;

/*
    Ввести целые числа как аргументы командной строки, подсчитать их суммы (произведения) и вывести результат на консоль.
 */

import java.util.Scanner;

public class Task05 {
    public static void main(String[] args) {
        try {
            if (args.length == 0) throw new NullPointerException();
            int sum = 0, mul = 1;
            for (int i = 0; i < args.length; i++) {
                sum += Integer.parseInt(args[i]);
                mul *= Integer.parseInt(args[i]);
            }
            System.out.println("Сумма: " + sum);
            System.out.println("Произведение: " + mul);
        } catch (NullPointerException e) {
            System.out.println("Вы не ввели аргументов");
        } catch (NumberFormatException e) {
            System.out.println("Введенные аргументы не корректны");

        }

    }
}