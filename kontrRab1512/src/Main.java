import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {

        FileReader modelIn = new FileReader("input.txt");
        BufferedReader input = new BufferedReader(modelIn);

        FileWriter modelOut1 = new FileWriter("result1.txt ");
        BufferedWriter output1 = new BufferedWriter(modelOut1);

        FileWriter modelOut2 = new FileWriter("result2.txt ");
        BufferedWriter output2 = new BufferedWriter(modelOut2);
        //SentenceBD newText=new SentenceBD(input);

        FileWriter modelOut3 = new FileWriter("result3.txt ");
        BufferedWriter output3 = new BufferedWriter(modelOut3);

        FileWriter modelOutXML = new FileWriter("result.xml");
        BufferedWriter outputXML = new BufferedWriter(modelOutXML);

        try {
            SentenceBD text=new SentenceBD(input);
            if(text.SentensList.isEmpty())
                System.out.println("Error");
            ArrayList<String> bigDigits=text.findBigDigits( text.SentensList);
            text.writeBigDigits(output1, bigDigits);
            text.sentensSort(output3);
            text.writeMap(output2);
            output3.close();
            text.fileToXML(outputXML);
        } catch (IOException e) {
            System.out.println(e.getLocalizedMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getLocalizedMessage());
        } finally {
            input.close();
            output1.close();
            output2.close();
            output3.close();
            outputXML.close();
        }

    }
}