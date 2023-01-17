//Борикова Альбина 7 группа
//Условие: 1/(1+x)^3= 1 -2*3/2+3*4/2+...+;
//Вывод:
//Введите x ∈ (-1,+1):
//    0.5
//Введите натуральное число k:
// 5
//Результат через стандартные функции:
//0,296
//Мой результат:
//0,296
import java.util.Scanner;
import java.lang.Math;
import java.math.BigDecimal;
import java.io.IOException;
import java.io.*;
import java.text.*;

public class Main {
    public  static double myPow(double x, double y) {
        double result=1;
        if(y>0){
            for(int i=1; i<=y; i++){
                result*=x;
            }
        }
        else if(y<0){
            for(int i=0; i<=(-y); i++) {
                x /= 10;
            }
            result=x;
        }
        else {
            result=1;
        }
        return result;
    }

    public static double myFunction(double x, double e){
        double y=1;
        double p=2;
        double t=1;
        double f=-1 ;
        double k=3;
        while(Math.abs(t)>e)
        {
            t=(p*k*myPow(x,p-1))/2;
            y+=t*f;
            p++;
            k++;
            f*=-1;
        }
        return y;
    }

    public static void main(String[] args) {
        InputStreamReader isr=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(isr);
        try {
            System.out.println("Введите x ∈ (-1,+1): ");
            String line=br.readLine();
            double ourNumber = Double.parseDouble(line);
            System.out.println("Введите натуральное число k: ");
            String secondLine=br.readLine();
            int ourDegree = Integer.parseInt(secondLine);
            ourDegree = -ourDegree;
            double e = myPow(10, ourDegree);
            System.out.println("Результат через стандартные функции: ");
            double result = 1 / Math.pow(ourNumber + 1,3);
            NumberFormat formatter=NumberFormat.getNumberInstance();
            formatter.setMaximumFractionDigits(3);
            System.out.println(formatter.format(result));
            System.out.println("Мой результат: ");
            double myResult = myFunction(ourNumber, e);
            System.out.println(formatter.format(myResult));
        }
        catch (NumberFormatException e) {
            System.out.println("Не число");
        }
        catch (IOException e) {
            System.out.println("Ошибка чтения с клавиатуры");
        }
    }
}