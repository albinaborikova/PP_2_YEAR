
import java.math.BigInteger;
import java.util.Scanner;
import java.lang.Math;
import java.io.IOException;
import java.io.*;
import java.text.*;
import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        InputStreamReader isr=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(isr);
        try {
            System.out.println("Введите x ∈ (-1,+1): ");
            String line=br.readLine();
            BigDecimal ourNumber = new BigDecimal(line);
            System.out.println("Введите натуральное число k: ");
            String secondLine=br.readLine();
            BigDecimal ourDegree = new BigDecimal(secondLine);
            BigDecimal first= new BigDecimal(1);
            BigDecimal ten= new BigDecimal(10.0);
            ourDegree = ourDegree.negate();
            BigDecimal newDegree=new BigDecimal(ourDegree.doubleValue());
            BigDecimal e=new BigDecimal(1.0);
            for(int i=0; i<=newDegree.doubleValue(); i++) {
                e.divide(ten);
            }
            System.out.println("Мой результат: ");
            BigDecimal result = new BigDecimal(1.0);
            BigDecimal newOurNumber=new BigDecimal(ourNumber.doubleValue()+1);
            result=new BigDecimal(1 / Math.sqrt(newOurNumber.doubleValue()));
            NumberFormat formatter=NumberFormat.getNumberInstance();
            formatter.setMaximumFractionDigits(3);
            System.out.println(formatter.format(1 / Math.sqrt(newOurNumber.doubleValue())));
        }
        catch (NumberFormatException e) {
            System.out.println("Не число");
        }
        catch (IOException e) {
            System.out.println("Ошибка чтения с клавиатуры");
        }
    }
}