package lesson2;


import java.util.Arrays;

import static lesson2.Homework.*;
import static lesson2.Task5.sortedArr;

public class Main {
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4, 6, 7, 9, 11, 2, 3, 0, 6, 8, 12, 3, 0, 0};
        System.out.println(Arrays.toString(sortedArr(arr)));
        System.out.printf("countEvens(new int[]{2, 1, 2, 3, 4}): %s%n", countEvens(new int[]{2, 1, 2, 3, 4}));
        System.out.printf("countEvens([2, 2, 0]): %s%n", countEvens(new int[]{2, 2, 0}));
        System.out.printf("countEvens([1, 3, 5]): %s%n", countEvens(new int[]{1, 3, 5}));
        System.out.printf("getAmplitude(arr): %s%n", getAmplitude(arr));
        System.out.printf("checkDoubleZeroes(arr): %s%n", checkDoubleZeroes(arr));
    }
}

