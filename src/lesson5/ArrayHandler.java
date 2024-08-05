package lesson5;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Array handler.
 */
public class ArrayHandler {
    /**
     * Save int array to file.
     *
     * @param intArray the int array
     * @param pathname the pathname
     */
    public static void saveArrayToFile(int[] intArray, String pathname) {
        byte[] arrToWrite = convertIntArrToByteArr(intArray);
        writeByteArrayToFile(arrToWrite, pathname);
    }


    /**
     * Read int array from file.
     *
     * @param pathname the pathname
     * @return the int [ ]
     */
    public static int[] readArrayFromFile(String pathname) {
        List<Integer> data = readBytesFromFile(pathname);
        String formattedString = convertDataToFormattedString(data);
        return convertFormattedStringToIntArray(formattedString);
    }

    private static void writeByteArrayToFile(byte[] arrToWrite, String pathname) {
        File file = new File(pathname);
        try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
            fileOutputStream.write(arrToWrite);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(String.format("File '%s' Not Found", pathname));
        } catch (IOException e) {
            throw new RuntimeException("IO Exception");
        }
    }

    private static byte[] convertIntArrToByteArr(int[] numArr) {
        if (numArr.length > 9){
            throw new IllegalArgumentException("numArr.length > 9");
        }

        StringBuilder arrStr = new StringBuilder();
        for (int n : numArr) {
            if (n < 0 || n > 3) {
                throw new IllegalArgumentException("n < 0 || n > 3");
            }
            arrStr.append(String.format("%02d", Integer.parseInt(Integer.toBinaryString(n))));
        }

        byte b0 = Byte.parseByte(arrStr.substring(0, 6), 2);
        byte b1 = Byte.parseByte(arrStr.substring(6, 12), 2);
        byte b2 = Byte.parseByte(arrStr.substring(12), 2);

        return new byte[]{b0, b1, b2};
    }


    private static List<Integer> readBytesFromFile(String pathname) {
        List<Integer> data = new ArrayList<>();
        int d;
        try (FileInputStream fileInputStream = new FileInputStream(pathname)){
            while ((d = fileInputStream.read()) != -1) {
                data.add(d);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(String.format("File '%s' Not Found", pathname));
        } catch (IOException e) {
            throw new RuntimeException("IO Exception");
        }
        return data;
    }

    private static String convertDataToFormattedString(List<Integer> data) {
        StringBuilder dataStringBuilder = new StringBuilder();
        for (int d : data) {
            String binaryString = Integer.toBinaryString(d);
            dataStringBuilder.append(String.format("%06d", Integer.parseInt(binaryString)));
        }
        return dataStringBuilder.toString();
    }

    private static int[] convertFormattedStringToIntArray(String formattedString) {
        if (formattedString.length() > 18) {
            throw new IllegalArgumentException("formattedString.length() > 18");
        }
        int[] intArray = new int[9];
        for (int i = 0; i < intArray.length; i++) {
            char c0 = formattedString.charAt(i * 2);
            char c1 = formattedString.charAt(i * 2 + 1);
            String chunk = String.valueOf(c0) + c1;
            intArray[i] = Integer.parseInt(chunk, 2);
        }
        return intArray;
    }
}
