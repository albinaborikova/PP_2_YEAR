//Борикова Альбина
//16.	Для заданной целочисленной матрицы найти минимум среди сумм модулей
//      элементов диагоналей, параллельных побочной диагонали матрицы.
/*Тесты
*Enter matrix size:
10
Matrix:
50 -55 -36 70 19 -9 -15 -40 -14 30
-50 51 -88 -54 -57 -95 29 -3 89 38
-71 -78 -64 -84 -67 -51 -85 -98 -6 -27
-97 11 -26 -52 85 3 85 59 41 71
-70 -41 -68 -64 -9 30 -7 -15 26 1
-33 -22 65 5 73 60 -85 83 98 -41
-85 49 -93 44 -51 75 30 68 -96 67
73 -75 92 -16 58 67 -59 -4 -79 31
-74 64 4 69 -31 -85 77 44 -85 -50
-2 45 16 -37 -4 -59 -79 96 -27 -48
The minimum of the amounts:-252 */

import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class Main {

    private static Integer numb;
    private static Vector<Vector<Integer>> matr;
    //private static Vector<Integer> tmp;

    //Заполнение матрицы
    public static void create_matr(Vector<Vector<Integer>> matr) {
        Random number = new Random();
        for (int i = 0; i < numb.intValue(); i++) {
            Vector<Integer> temp = new Vector<Integer>();
            for (int j = 0; j < numb.intValue(); j++) {
                temp.add(number.nextInt() % 100);
            }
            matr.add(temp);
        }
    }

    //Вывод матрицы
    public static void print(Vector<Vector<Integer>> matr) {
        System.out.println("Matrix:");
        for (int i = 0; i < numb.intValue(); i++) {
            for (int j = 0; j < numb.intValue(); j++) {
                System.out.print(matr.get(i).get(j) + " ");
            }
            System.out.print('\n');
        }
    }


    public static void min_amount(Vector<Vector<Integer>> matr) {
        Vector<Integer> tmp = new Vector<Integer>();
        for (int i = 0; i < matr.size(); ++i) {
            Integer sum = 0;
            for (int j = i; j >= 0; --j) {
                sum += matr.get(i).get(j);
            }
            tmp.add(sum);
        }

        for (int j = 1; j < matr.size(); ++j) {
            Integer sum = 0;
            for (int i = j; i < matr.size(); ++i) {

                sum += matr.get(i).get(matr.size() - 1 - (i - j));
            }
            tmp.add(sum);
        }
        Collections.sort(tmp);
        System.out.print("The minimum of the amounts:");
        System.out.print(tmp.get(0));
    }

        public static void main (String[]args){
            System.out.println("Enter matrix size: ");
            Scanner sc = new Scanner(System.in);
            String numbS = sc.next();
            numb = Integer.parseInt(numbS);
            if (numb > 0) {
                matr = new Vector<Vector<Integer>>();
                create_matr(matr);
                print(matr);
                min_amount(matr);
            } else
                System.out.println("Wrong matrix size!");
        }
    }

