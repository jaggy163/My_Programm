package Var_A;

import java.io.IOException;
import java.util.Scanner;

/*
    Приветствовать любого пользователя при вводе его имени через командную строку
 */
public class Task01 {
    public static void main(String[] args) throws IOException {
        System.out.println("Привет, " + args[0] + "!");
        System.out.println("Вас зовут не Антон? Введите свое имя.");
        Scanner scanLogName = new Scanner(System.in);
        String logName = scanLogName.next();
        System.out.println("Привет, " + logName + "!");
    }
}
