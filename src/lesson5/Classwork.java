package lesson5;

import java.io.*;
import java.util.Arrays;

public class Classwork {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        /*
         * Создать массив из 9 цифр и записать его в файл, используя поток вывода.
         * */
        writeArrToFile(arr, "example1.txt");
        writeArrToFile(arr, "example2.txt");


        /*
         * Создать массив целых чисел и заполнить его информацией из файла, записанного в предыдущем задании.
         * */
        int[] redArr1 = readArrFromFile("example1.txt");
        int[] redArr2 = readArrFromFile("example2.txt");
        System.out.println(Arrays.toString(redArr1));
        System.out.println(Arrays.toString(redArr2));
    }

    private static void writeArrToFile(int[] arr, String filepath) {
        File file = new File(filepath);
        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write(formatArrToString(arr));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int[] readArrFromFile(String filepath) {
        File file = new File(filepath);
        StringBuilder sb = new StringBuilder();
        if (file.exists()) {
            try(FileReader fileReader = new FileReader(file)) {
                int n;
                while ((n = fileReader.read()) != -1) {
                    sb.append((char) n);
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return formatStringToArr(sb.toString());
    }

    static String formatArrToString(int[] arr) {
        StringBuilder sb = new StringBuilder();
        char sep = ';';
        for (int a : arr) {
            sb.append(a).append(sep);
        }
        return sb.substring(0, sb.length() - 1);
    }

    static int[] formatStringToArr(String s) {
        if (s.isEmpty()) {
            return new int[0];
        }
        return Arrays.stream(s.split(";")).mapToInt(Integer::parseInt).toArray();
    }
}
