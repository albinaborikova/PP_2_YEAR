/*Борикова Альбина 7 группа
2.	За один просмотр символов строки найти все слова,
содержащие наибольшее количество различных символов,
и занести их в новую строку. Слова в исходной строке
разделяются некоторым множеством разделителей. Слова
в новой строке должны разделяться ровно одним пробелом.

Enter some text here:
 rrrr fdgtyh fffff hgt bnk
Enter delimeter here:

The word with the most distinct letters
fdgtyh
The largest number of different letters
6
*/
import java.util.Scanner;



public class Main {

    public static void split(String str, String[] substr, String delimeter) {
        substr = str.split(delimeter);
    }

    public static long count_symbols(String s) {
        long t = s.chars().distinct().count();
        return t;
    }

    public void printRes(String res) {
        System.out.println(res);
    }

    public static void main(String[] args) {
        System.out.println("Enter some text here:");
        Scanner sc = new Scanner(System.in);
        String str;
        str = sc.nextLine();
        String delimeter;
        System.out.println("Enter delimeter here:");
        delimeter=sc.nextLine();
        String[] substr=str.split(delimeter);
        long max=count_symbols(substr[0]);
        int index=0;
        for(int i=1; i< substr.length; i++){
            long tmp=count_symbols(substr[i]);
            if(tmp>max) {
                max = tmp;
                index=i;
            }
        }
        System.out.println("The word with the most distinct letters");
        System.out.println(substr[index]);
        System.out.println("The largest number of different letters");
        System.out.println(max);
    }

}