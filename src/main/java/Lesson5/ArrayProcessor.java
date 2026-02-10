package Lesson5;

public class ArrayProcessor {


    public static int sum4x4(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        if (arr == null || arr.length != 4) {
            throw new MyArraySizeException("В массиве должно быть 4 строки");
        }
        for (int i = 0; i < 4; i++) {
            if (arr[i] == null || arr[i].length != 4) {
                throw new MyArraySizeException("В каждой строке должно быть 4 столбца (проблема в строке " + i + ")");
            }
        }

        int sum = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                String val = arr[i][j];
                try {
                    sum += Integer.parseInt(val);
                } catch (NumberFormatException e) {
                    // детализируем, в какой ячейке неверные данные
                    throw new MyArrayDataException(i, j, val);
                }
            }
        }
        return sum;
    }
}
