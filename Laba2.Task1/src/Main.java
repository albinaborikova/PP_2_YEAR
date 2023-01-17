//2.	Определить, является ли матрица симметричной (относительно
//главной диагонали). Вывести на экран соответствующее
//сообщение. Найти максимальный элемент среди  стоящих
//на главной и  побочной  диагонали  и поменять местами с
//элементом, стоящим на пересечении этих диагоналей.
/*Enter matrix size:
5
Matrix:
85 -57 14 -66 -95
40 60 66 69 77
30 -2 26 -68 -91
96 -98 46 85 -68
-81 -37 -57 -39 -82
Matrix is not symmetrical
Maximum element of diagonals:
96
An element at the intersection of diagonals:
26
Matrix:
85 -57 14 -66 -95
40 60 66 69 77
30 -2 96 -68 -91
26 -98 46 85 -68
-81 -37 -57 -39 -82*/
/*Enter matrix size:
4
Matrix:
-65 -26 -48 -96
-88 22 -39 34
93 -58 57 -8
2 79 22 -55
Matrix is not symmetrical
Maximum element of diagonals:
93
The matrix does not have an element at the intersection of the diagonals
Matrix:
-65 -26 -48 -96
-88 22 -39 34
93 -58 57 -8
2 79 22 -55 */


import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class Main {

    //заполнение рандомными значениями
    public static void create_matr(Integer matr[][]){
        Random numb = new Random();
        for(int i = 0; i < matr.length; i++)
            for (int j = 0; j < matr[i].length; j++) {
                matr[i][j] = numb.nextInt() % 100;
            }
    }

    public static void main_simmetric(Integer matr[][]){
        int flag=0;
        for(int i=0; i< matr.length; i++){
            for(int j=0; j< matr.length; j++){
                if(matr[i][j]!= matr[j][i]){
                    flag++;
                }
            }
        }
        if(flag==0){
            System.out.println("Matrix is symmetrical");
        }
        else {
            System.out.println("Matrix is not symmetrical");
        }
        //System.out.println(max_elem(elem));
    }
    public static void max_elem(Integer matr[][]){
        int max=0;
        int line=0;
        int column=0;
        for(int i=0; i< matr.length; i++){
            if(matr[i][i]>max){
                max=matr[i][i];
                line=i;
                column=i;
            }
        }
        for(int i=matr.length-1;i>=0; i--) {
            for (int j = 0; j < matr.length; j++) {
                if (matr[i][j] > max) {
                    max = matr[i][j];
                    line = i;
                    column = j;
                }
            }
        }
        System.out.println("Maximum element of diagonals: ");
        System.out.println(max);
        if(matr.length %2!=0){
            int t=matr.length/2;
            System.out.println("An element at the intersection of diagonals: ");
            System.out.println(matr[t][t]);
            int num=matr[t][t];
            matr[t][t]= matr[line][column];
            matr[line][column]=num;
        }
        else{
            System.out.println("The matrix does not have an element at the intersection of the diagonals");
        }

    }

    public static void print(Integer matr[][]){
        System.out.println("Matrix:");
        for(int i = 0; i < matr.length; i++) {
            for (int j = 0; j < matr[i].length; j++) {
                System.out.print(matr[i][j] + " ");
            }
            System.out.print('\n');
        }
    }

    public static void main(String[] args) {
        System.out.println("Enter matrix size: ");
        Scanner sc = new Scanner(System.in);
        String numbS = sc.next();
        Integer numb = Integer.parseInt(numbS);
        if(numb > 0) {
            Integer matr[][] = new Integer[numb][numb];
            create_matr(matr);
            print(matr);
            main_simmetric(matr);
            max_elem(matr);
            print(matr);
        }
        else
            System.out.println("Wrong matrix size!");
    }
        //System.out.println("Hello world!");
}