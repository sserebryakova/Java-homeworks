package lesson2;

public class Main {
    public static void main(String[] args) {
        String[][] array = new String[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                array[i][j] = String.valueOf(i + j);
            }
        }
        try {
            int sum = countArraySum(array);
            System.out.println(sum);
            array[1][2] = "a";
            countArraySum(array);

        } catch (MyArraySizeException e) {
            System.out.println("Массив должен быть размера 4х4");
        } catch (MyArrayDataException e) {
            System.out.println("Неверный формат данных: " + e.getMessage());
        }

    }
    public static int countArraySum(String[][] array) throws MyArraySizeException, MyArrayDataException {
        if (array.length != 4) {
            throw new MyArraySizeException();
        } else {
            for (int i = 0; i < array.length; i++) {
                if (array[i].length != 4) {
                    throw new MyArraySizeException();
                }
            }
        }
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    result += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Значение ячейки с координатами " + i + ", " + j + " не является числом");
                }
            }
        }
        return result;
    }
}
