import java.io.PrintStream;
import java.util.Scanner;
public class Main {
    public static Scanner in = new Scanner(System.in);
    public static PrintStream out = System.out;
    public static void main(String[] args) {
        // Считываем количество чисел
        out.print("Введите число N: ");
        int N = in.nextInt();
        int []num=new int[N];
        out.println("Введите " + N + " натуральных числа:");
        //создаем массив из N чисел
        for (int i = 0; i < N; i++) {
            num[i] = in.nextInt();
        }
        // массив для чисел Фибоначчи
        int[] fibn = new int[N];
        // масив для чисел, которыми не являются числами Фибоначчи
        int[] notfib = new int[N];
        //массив, где элементы будут поменяны на порядковый номер или на -1
        int[] zamena= new int[N];
        //счетчик для чисел Фибоначчи
        int fibc = 0;
        //счетчик не для чисел Фибоначчи
        int notfibc = 0;
        // Считывание и классификация чисел
        for (int i = 0; i < N; i++) {
            int number = num[i];
            int a = 0, b = 1;//начальные значения для чисел Фибоначчи
            boolean fibonacci=false;//флажок для поиска числа Фибоначчи в массиве
            if (number==a || number==b){//если число равно начальным значениям Фибоначчи
                fibonacci = true;// то число Фибоначчи найдено
            }
            while (b < number) {
                int c=b;//идем дальше по циклу
                b+=a;
                a=c;
                if(b==number){
                    fibonacci=true;
                    break;
                }
            }
            if (fibonacci) {//если число Фибоначчи найдено в массиве
                fibn[fibc++] = number;//формируем массив из чисел Фибоначчи(это нужно для дальнейших действий)
            }
            else {
                notfib[notfibc++] = number;//если число не является числом Фибоначчи, создаем для таких чисел массив
            }
        }
        //Отсортировываем массив с числами Фибоначчи по возрастанию
        for (int i = 0; i < fibc - 1; i++) {
            for (int j = 0; j < fibc - i - 1; j++) {
                if (fibn[j] > fibn[j + 1]) {
                    // Меняем местами
                    int f = fibn[j];
                    fibn[j] = fibn[j + 1];
                    fibn[j + 1] = f;
                }
            }
        }
        //Отсортировываем массив не с числами Фибоначчи по убыванию
        for (int i = 0; i < notfibc - 1; i++) {
            for (int j = 0; j < notfibc - i - 1; j++) {
                if (notfib[j] < notfib[j + 1]) {
                    //меняем местами
                    int f = notfib[j];
                    notfib[j] = notfib[j + 1];
                    notfib[j + 1] = f;
                }
            }
        }
        // Вывод конечного отсортированного массива для пункта 2
        out.println("Отсортированный массив по возрастанию/убыванию:");
        for (int i = 0; i < fibc; i++)
            out.print(fibn[i] + " ");
        for (int i = 0; i < notfibc; i++)
            out.print(notfib[i] + " ");
        out.println();
        out.println("Количество чисел Фибоначчи: " + fibc);//вывод количества чисел Фибоначчи
        for (int i = 0; i < N; i++) {
            int numbers = num[i];
            int a = 0, b = 1, index = 0;
            // Проверка на число Фибоначчи для поиска порядкового номера в последовательности Фибоначчи
            if (numbers == a) {
                zamena[i] = index+1;//в новый массив добавляем порядковый номер для 0
            } else if (numbers == b) {
                zamena[i] = index + 2;//в новый массив добавляем порядковый номер для 1
            } else {
                index += 2;
                while (b <= numbers) {
                    if (b == numbers) {
                        zamena[i] = index;
                        break;
                    }
                    int temp = b;
                    b += a;
                    a = temp;
                    index++;
                }
                if (b > numbers) {
                    zamena[i] = -1; // Не является числом Фибоначчи
                }
            }
        }
        // Вывод элементов массива, где числа Фибоначчи заменились на порядковый номер, а остальные числа на -1
        out.println("Вывод элементов массива, где числа Фибоначчи заменились на порядковый номер, а остальные числа на -1:");
        for (int i = 0; i < N; i++) {
            out.print(zamena[i] + " ");
        }
        out.println();
        //  Замена каждого числа на сумму его четных цифр
        for (int i = 0; i < N; i++) {
            int sum = 0;
            int t = num[i];
            while (t> 0) {
                int digit = t % 10;
                if (digit % 2 == 0) {
                    sum += digit;
                }
                t /= 10;
            }
            num[i] = sum;
        }
        // Вывод полученного массива, где каждое число заменилось на сумму его нечетных цифр
        out.println("Массив, где каждое число заменилось на сумму его нечетных цифр:");
        for (int i = 0; i < N; i++) {
            out.print(num[i] + " ");
        }
    }
}
