package lesson2;

/*
* Написать функцию добавления элемента в конец массива таким
образом, чтобы она расширяла массив при необходимости.
* */
public class Task4 {

    /*
     * Решение для случая если pos может быть больше размера исходного массива
     * */
    static int[] extendedArr(int[] arr, int val, int pos) {
        if (pos < 0) throw new IllegalArgumentException("Argument 'pos' must be greater than 0.");
        int size;
        if (pos <= arr.length) {
            size = arr.length + 1;
        } else {
            size = pos + 1;
        }
        int[] newArr = new int[size];
        newArr[pos] = val;

        int newInd = 0;
        for (int j : arr) {
            if (newInd == pos) newInd++;
            newArr[newInd] = j;
            newInd++;
        }
        return newArr;
    }

    static int[] extendedArr(int[] arr, int val) {
        return extendedArr(arr, val, arr.length);
    }

    /*
     * Решение для случая когда pos в пределах исходного массива. Используется функция System.arraycopy
     * Делим исходный массив на две части: до pos и после. копируем эти части в новый массив. и val на поз
     * */
    static int[] insertIntoArray(int[] arr, int val, int pos) {
        if (pos < 0 || pos > arr.length) throw new IllegalArgumentException("Argument 'pos' must in 0 and arr.length.");
        int[] newArr = new int[arr.length + 1];
        System.arraycopy(arr, 0, newArr, 0, pos);
        newArr[pos] = val;
        System.arraycopy(arr, pos, newArr, pos + 1, arr.length - pos);
        return newArr;
    }


}
