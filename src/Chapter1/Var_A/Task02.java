package Var_A;

/*
    Отобразить в окне консоли аргументы в обратном порядке
 */

public class Task02 {
    public static void main(String[] args) {
        int countOfArgs = args.length;
        for (int i = countOfArgs-1; i>=0; i--) {
            System.out.println("Аргумент -> " + args[i]);
        }
    }
}
