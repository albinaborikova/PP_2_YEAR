import java.util.Vector;
import com.company.Array;
//Борикова Альбина
//Даны две квадратные матрицы порядка n.
//Получить новую  матрицу умножением  элементов каждой строки первой матрицы
// на наибольшее из значений элементов соответствующей строки  второй матрицы.


public class Main {

    public static void main(String[] args) {
        try {


            System.out.println(" ");

            Array matrix_1 = new Array();
            Array matrix_2 = new Array();



            matrix_1.goRand();
            System.out.println("matrix 1");
            matrix_1.output();


            matrix_2.goRand();
            if(matrix_1.getDim_1()!=matrix_2.getDim_1())
                throw new Exception("ERROR");
            System.out.println("matrix 2");
            matrix_2.output();
            matrix_1.multiply(matrix_2);
            System.out.println("Результат:4");
            matrix_1.output();
        }
        catch (Exception ex){
            System.out.println("Неправильный размер");
        }

    }
}