package lesson2;

import java.util.*;

public class Task5 {
    /**
     * Написать метод, осуществляющий сортировку одномерного
     * массива подсчётом. Важное ограничение состоит в том, что для этой
     * сортировки диапазон значений исходного массива должен находиться в
     * разумных пределах, например, не более 1000.
     *
     * @param arr the arr
     * @return the int [ ]
     */
    static int[] sortedArr(int[] arr) {
        TreeMap<Integer, Integer> counter = new TreeMap<>();
        for (int i : arr) {
            counter.putIfAbsent(i, 0);
            counter.put(i, counter.get(i) + 1);
        }
        ArrayList<Integer> resultList = new ArrayList<>();
        counter.forEach((key, value) -> {
            for (int i = 0; i < value; i++) resultList.add(key);
        });
        return resultList.stream().mapToInt(Integer::intValue).toArray();
    }
}
