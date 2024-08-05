package lesson5;

import java.util.Arrays;

import static lesson5.ArrayHandler.readArrayFromFile;
import static lesson5.ArrayHandler.saveArrayToFile;
import static lesson5.Backup.saveToBackup;

public class Main {

    /*
    *   1. Написать функцию, создающую резервную копию всех файлов в директории (без
поддиректорий) во вновь созданную папку ./backup

        2. Предположить, что числа в исходном массиве из 9 элементов имеют диапазон [0,
3], и представляют собой, например, состояния ячеек поля для игры в крестики-
нолики, где 0 – это пустое поле, 1 – это поле с крестиком, 2 – это поле с ноликом, 3
– резервное значение. Такое предположение позволит хранить в одном числе типа
int всё поле 3х3. Записать в файл 9 значений так, чтобы они заняли три байта.

        3. Прочитать числа из файла, полученного в результате выполнения задания 2.
    * */

    public static void main(String[] args) {
        /*Task 1*/
        saveToBackup(".", "./backup");

        /*Task 2*/
        saveArrayToFile(new int[]{0, 1, 2, 3, 2, 1, 0, 0, 1}, "output.txt");

        /*Task 3*/
        int[] intArray = readArrayFromFile("output.txt");
        System.out.println(Arrays.toString(intArray));
    }

}
