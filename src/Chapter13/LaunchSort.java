package Chapter13;

import java.util.Random;

public class LaunchSort {
    public static void main(String[] args) {
        int[] numbers = new int[10000000];
        for (int i = 0; i < numbers.length; i++) {
            Random tmp = new Random();
            numbers[i] = tmp.nextInt(10000000);
        }
        Sort.sort(numbers);
        Sort.sort(numbers);
        Sort.sort(numbers);
        Sort.sort(numbers);
        Sort.sort(numbers);
//        for (int i = 0 ; i<20; i++) {
//            System.out.println(numbers[i]);
//        }
    }
}
