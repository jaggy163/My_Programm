package Var_A;

/*
    Вывести заданное количество случайных чисел с переходом и без перехода на новую строку
 */


import java.io.IOException;
import java.util.Scanner;

public class Task03 {
    public static void main(String[] args) {
        int countOfNumbers = 0;
            Scanner scanCountOfNumbers = new Scanner(System.in);
            countOfNumbers=scanCountOfNumbers.nextInt();
            int randomNumbers[] = new int[countOfNumbers];
        for (int i=0; i<countOfNumbers; i++) {
            int randomNubmer = (int) (Math.random()*100);
            randomNumbers[i] = randomNubmer;
            if (i==0) {
                System.out.print("Числа в строчку: " + randomNumbers[i] + ", ");
                continue;
            }
            if ((i+1)<countOfNumbers) {
                System.out.print(randomNumbers[i] + ", ");
            } else {
                System.out.print(randomNumbers[i] + ".");
            }
        }
        System.out.println();
        for (int i=0; i<countOfNumbers; i++) {
            if (i==0) System.out.println("Числа в столбец:");
            System.out.println(randomNumbers[i]);
        }
    }

}
