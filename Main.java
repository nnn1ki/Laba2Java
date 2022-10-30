
/* (12)
a. определить число предложений в тексте;
b. найти самое часто встречающееся слово в тексте;
c. определить число слов в предложении, которые начинаются с гласной/согласной буквы;
d. удалить повторяющиеся значения числового одномерного массива.
 */

//System.out.println("Hello world!");
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int exampleNumber = -1;

        while (exampleNumber != 0){

            System.out.println("1 - первое задание с тектом, 2 - работа с одномерным массивом, 0 - выход");
            Scanner input = new Scanner(System.in);
            exampleNumber = input.nextInt();

            //решаем первые 3 задания
            if (exampleNumber == 1){
                System.out.println("Введите текст! Хотябы одно предложение!");
                System.out.println("p.s тессом считается нобор слов, заканчивающихся точкой. набор чисел не может являться предложением");

                String UserInput = "";
                Scanner t = new Scanner(System.in);
                UserInput = t.nextLine();

                Text userline = new Text(UserInput);

                System.out.println("a. определить число предложений в тексте: " + userline.numberSentences());
                System.out.println("b. найти самое часто встречающееся слово в тексте: " + userline.popularWord());

                userline.vowelOrConsonant();

            }

            if (exampleNumber == 2){
                System.out.println("d. удалить повторяющиеся значения числового одномерного массива.");
                System.out.println("Введите количество чисел для массива: ");

                Scanner inp = new Scanner(System.in);
                int count = inp.nextInt();

                int[] matr;
                matr = new int[count];
                matr = getMatrixComponents(count); //ввели массив

                Matrix userMatrix = new Matrix(matr);

                System.out.println("d. после преобразования:");
                System.out.println(userMatrix.deleteSimilar());

            }
        }
    }

    static int[] getMatrixComponents(int components) {
        int[] array = new int[components];
        Scanner scan = new Scanner(System.in);

        for (int i = 0; i < components; i++) {
            array[i] = scan.nextInt();
        }
        return array;
    }

}
