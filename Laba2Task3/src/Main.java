//Борикова Альбина
//30.	Упорядочить ее столбцы по  возрастанию их наименьших элементов.
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
public class Main {
    private static Integer numb;
    private static ArrayList<ArrayList<Integer>> matr;

    //Заполнение матрицы
    public static void create_matr(ArrayList<ArrayList<Integer>> matr){
        Random number = new Random();
        for(int i = 0; i < numb.intValue(); i++) {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            for (int j = 0; j < numb.intValue(); j++) {
                temp.add(number.nextInt() % 100);
            }
            matr.add(temp);
        }
    }

    //Вывод матрицы
    public static void print(ArrayList<ArrayList<Integer>> matr){
        System.out.println("Matrix:");
        for(int i = 0; i < numb.intValue(); i++){
            for (int j = 0; j < numb.intValue(); j++) {

                System.out.print(matr.get(i).get(j) + " ");
            }
            System.out.print('\n');
        }
    }

    public static void min_elements(ArrayList<ArrayList<Integer>> matr){
        ArrayList<ArrayList<Integer>> temp1= new ArrayList<ArrayList<Integer>>();
        for(Integer j=0; j<numb.intValue(); ++j){
            ArrayList<Integer> temp = new ArrayList<Integer>();
            temp.add(j);
            Integer min=matr.get(0).get(0);
            for(int i=0; i<numb.intValue(); ++i){
                if(min>matr.get(i).get(j)){
                    min=matr.get(i).get(j);
                }
            }
            temp.add(min);
            temp1.add(temp);
        }

        for(int i=0; i< temp1.size(); i++){

        }
    }



    public static void main(String[] args) {
        System.out.println("Enter matrix size: ");
        Scanner sc = new Scanner(System.in);
        String numbS = sc.next();
        numb = Integer.parseInt(numbS);
        if(numb > 0) {
            matr = new ArrayList<ArrayList<Integer>>();
            create_matr(matr);
            print(matr);
            min_elements(matr);
            //matr = change_matr(matr);
            //print(matr);
        }
        else
            System.out.println("Wrong matrix size!");
    }

}