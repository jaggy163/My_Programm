package Chapter1.Var_B;



public class VarBTasks {

    public static void task01() {
        // Вывести отдельно четные и нечетные числа
        System.out.println("\nЗадание 1");
        System.out.print("Четные числа: ");
        for (int i=0; i<VarBExecuter.COUNT_OF_NUMBERS; i++) {
            if (VarBExecuter.Numbers[i] % 2 == 0) System.out.print(VarBExecuter.Numbers[i] + " ");
        }
        System.out.print("\nНечетные числа: ");
        for (int i=0; i<VarBExecuter.COUNT_OF_NUMBERS; i++) {
            if (VarBExecuter.Numbers[i] % 2 == 1) System.out.print(VarBExecuter.Numbers[i] + " ");
        }
    }

    public static void task02() {
        // Вывести наибольшее и наименьшее число
        System.out.println("\nЗадание 2");
        System.out.println("Наибольшее число: " + maxNumber());
        System.out.print("Наименьшее число: " + minNumber());
    }

    public static int maxNumber() {
        // Вывести наибольшее и наименьшее число
        int max=VarBExecuter.Numbers[0];
        for (int i=0; i<VarBExecuter.COUNT_OF_NUMBERS; i++) {
            max = Math.max(max, VarBExecuter.Numbers[i]);
        }
        return max;
    }

    public static int minNumber() {
        // Вывести наибольшее и наименьшее число
        int min=VarBExecuter.Numbers[0];
        for (int i=0; i<VarBExecuter.COUNT_OF_NUMBERS; i++) {
            min = Math.min(min, VarBExecuter.Numbers[i]);
        }
        return min;
    }

    public static double mulNumber(int index) {
        return index>0 ? VarBExecuter.Numbers[index]*mulNumber(index-1) : VarBExecuter.Numbers[index];
    }

    public static void task03() {
        System.out.println("\nЗадание 3");
        System.out.print("Числа, которые делятся на 3 и 5: ");
        for (int i=0; i<VarBExecuter.COUNT_OF_NUMBERS; i++) {
            if (VarBExecuter.Numbers[i] % 3 == 0 || VarBExecuter.Numbers[i] % 5 ==0) System.out.print(VarBExecuter.Numbers[i] + " ");
        }
    }

    public static void task04() {
        System.out.println("\nЗадание 4");
        System.out.print("Числа, которые делятся на 5 и 7: ");
        for (int i=0; i<VarBExecuter.COUNT_OF_NUMBERS; i++) {
            if (VarBExecuter.Numbers[i] % 5 == 0 || VarBExecuter.Numbers[i] % 7 ==0) System.out.print(VarBExecuter.Numbers[i] + " ");
        }
    }

    public static void task05() {
        System.out.println("\nЗадание 5");
        System.out.print("Числа, расположенные по убыванию модулей: ");
        int[] sortNumbers = new int[VarBExecuter.COUNT_OF_NUMBERS];
        for (int i=0; i<VarBExecuter.COUNT_OF_NUMBERS; i++) {
            for (int j=0; j<VarBExecuter.COUNT_OF_NUMBERS-i-1; j++) {
                int tmp = VarBExecuter.Numbers[j];
                if (tmp<VarBExecuter.Numbers[j+1]) {
                    VarBExecuter.Numbers[j]=VarBExecuter.Numbers[j+1];
                    VarBExecuter.Numbers[j+1]=tmp;
                }
            }
        }
        for (int i=0; i<VarBExecuter.COUNT_OF_NUMBERS; i++) {
            System.out.print(VarBExecuter.Numbers[i] + " ");
        }
    }

    public static void task06() {
        System.out.println("\nЗадание 6");
        System.out.print("Числа, в написании которых нет повторяющихся цифр: ");
        for (int i=0; i<VarBExecuter.Numbers.length; i++) {
            boolean repeat = true;
            String numberInString = new String("");
            numberInString+=VarBExecuter.Numbers[i];
            char[] numberInCharArray = numberInString.toCharArray();
            for (int k=0; k<numberInCharArray.length-1; k++) {
                for (int j=k+1; j<numberInCharArray.length; j++) {
                    if (numberInCharArray[k]==numberInCharArray[j]) { repeat=false; break; }
                }
            }
            if(repeat) System.out.print(VarBExecuter.Numbers[i] + " ");
        }
    }

    public static void task07() {
        System.out.println("\nЗадание 7");
        System.out.print("Наибольший общий делитель: ");
        int max = maxNumber(), min = minNumber();
        double mul = mulNumber(VarBExecuter.COUNT_OF_NUMBERS-1), forKrat = mul/max;

        for (int i=1; i<forKrat; i++) {
            boolean stop=true;
            for (int j=0; j<VarBExecuter.COUNT_OF_NUMBERS; j++) {
                if (max*i % VarBExecuter.Numbers[j] != 0) stop = false;
            }
            if (stop) {
                System.out.println("Наименьшее общее кратное: " + max*i);
                break;
            }
        }

        for (int i=min; i>0 ; i--) {
            boolean stop = true;
            for (int j=0; j<VarBExecuter.COUNT_OF_NUMBERS; j++) {
                if (VarBExecuter.Numbers[j] % i != 0) stop = false;
            }
            if (stop) {
                System.out.println("Наибольший общий делитель: " + i);
                break;
            }
        }
    }


}
