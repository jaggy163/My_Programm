package Var_A;

/*
    Ввести пароль из командной строки и сравнить его со строкой-образцом
 */

import java.util.Scanner;

public class Task04 {
    public static final int POSSIBLEATTEMPTS=3;
    public static int countOfAttempts=0;

    public static void main(String[] args) {
        if (countOfAttempts==POSSIBLEATTEMPTS) {
            System.out.println("Всё, ёпта.");
            System.exit(0);
        }
        String keyPass = "4Thi8mk1";
        System.out.println("Введите пароль:");
        Scanner scanPass = new Scanner(System.in);
        String pass = scanPass.next();
        if (keyPass.equals(pass)) {
            System.out.println("Вы вошли в систему.");
        } else {
            countOfAttempts++;
            System.out.println("Неверный пароль, повторите попытку.");
            Task04.main(args);
        }
    }
}


