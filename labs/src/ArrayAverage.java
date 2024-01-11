
public class ArrayAverage {
    public static void main(String[] args) {
        String[] arr = {"1", "2", "ф"};
        int sum = 0;
        try {
            for (int i = 0; i < arr.length; i++) {
                sum += Integer.parseInt(arr[i]);
            }
            System.out.println(sum/arr.length);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Ошибка: Попытка доступа к элементу за пределами массива.");
        }
        catch (NumberFormatException e) {
            System.out.println("Ошибка: Элемент массива не является числом.");
        }
        catch (ArithmeticException e) {
            System.out.println("Ошибка: Массив не содержит элементов.");
        }
    }
}
