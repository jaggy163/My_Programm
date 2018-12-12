package Chapter1.Var_B;

/*
    Ввести числа и вызвать необходимые методы класса VarBTasks
 */

import java.util.Scanner;

public class VarBExecuter {
    static final int COUNT_OF_NUMBERS=5;
    static int[] Numbers = new int[COUNT_OF_NUMBERS];
    public static void main(String[] args) {
        System.out.println("Введите " + COUNT_OF_NUMBERS + " целых чисел:");
        for (int i=0; i<COUNT_OF_NUMBERS; i++) {
            Scanner scanNumbers = new Scanner(System.in);
            Numbers[i] = scanNumbers.nextInt();
        }
        VarBTasks.task01();
        VarBTasks.task02();
        VarBTasks.task03();
        VarBTasks.task04();
        VarBTasks.task05();
        VarBTasks.task06();
        VarBTasks.task07();

    }
}
