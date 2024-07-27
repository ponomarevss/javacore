package lesson2;

import java.util.Arrays;

/*
 *
 *   1. Написать метод, возвращающий количество чётных элементов массива. countEvens([2, 1, 2, 3, 4]) → 3 countEvens([2, 2, 0]) → 3 countEvens([1, 3, 5]) → 0
 *   2. Написать функцию, возвращающую разницу между самым большим и самым маленьким элементами переданного не пустого массива.
 *   3. Написать функцию, возвращающую истину, если в переданном массиве есть два соседних элемента, с нулевым значением.
 * */
public class Homework {
    /**
     * Метод, возвращающий количество чётных элементов массива.
     *
     * @param arr the arr
     * @return the int
     */
    static int countEvens(int[] arr) {
        int count = 0;
        for (int a : arr) if (a % 2 == 0) count++;
        return count;
    }

    /**
     * Метод, возвращающий разницу между самым большим и самым маленьким элементами переданного не пустого массива.
     *
     * @param arr the arr
     * @return the amplitude
     */
    static int getAmplitude(int[] arr) {
        if (arr.length == 0) throw new IllegalArgumentException("Array cannot be empty");
        return Arrays.stream(arr).max().getAsInt() - Arrays.stream(arr).min().getAsInt();
    }

    /**
     * Метод, возвращающий истину, если в переданном массиве есть два соседних элемента, с нулевым значением.
     *
     * @param arr the arr
     * @return the boolean
     */
    static boolean checkDoubleZeroes(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == 0 && arr[i + 1] == 0) return true;
        }
        return false;
    }
}
