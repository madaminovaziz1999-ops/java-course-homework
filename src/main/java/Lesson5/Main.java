package Lesson5;

public class Main {
    public static void main(String[] args) {

        // Правильный массив 4x4
        String[][] correct = {
                {"1","2","3","4"},
                {"5","6","7","8"},
                {"9","10","11","12"},
                {"13","14","15","16"}
        };

        // Массив неправильного размера
        String[][] wrongSize = {
                {"1","2","3"},
                {"4","5","6"},
                {"7","8","9"}
        };

        // Массив с неверными данными
        String[][] wrongData = {
                {"1","2","3","4"},
                {"5","six","7","8"},
                {"9","10","11","12"},
                {"13","14","15","16"}
        };

        // 1) Вызов для правильного массива
        try {
            int sum = ArrayProcessor.sum4x4(correct);
            System.out.println("Сумма = " + sum);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        // 2) Демонстрация MyArraySizeException
        try {
            ArrayProcessor.sum4x4(wrongSize);
        } catch (MyArraySizeException e) {
            System.out.println("Ошибка в размере: " + e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println("Ошибка в дате : " + e.getMessage());
        }

        // 3) Демонстрация MyArrayDataException
        try {
            ArrayProcessor.sum4x4(wrongData);
        } catch (MyArraySizeException e) {
            System.out.println("Ошибка в размере : " + e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println("Ошибка в дате [" + e.getRow() + "][" + e.getCol() + "]: " + e.getValue());
        }

        // 4) Пример генерации и обработки ArrayIndexOutOfBoundsException
        try {
            String[][] a = new String[2][2];
            // намеренно обращаемся по несуществующему индексу
            String s = a[5][0];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Возникло исключение  ArrayIndexOutOfBoundsException: " + e.getMessage());
        }
    }
}