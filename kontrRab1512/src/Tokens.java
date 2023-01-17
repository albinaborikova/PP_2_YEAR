import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;

public class Tokens {
    ArrayList<String> Leks;

    public Tokens(String input) {

        Leks = new ArrayList<>();

        Pattern toFindLong = Pattern.compile("^[1-9][0-9]*$");
        Pattern toFindTime = Pattern.compile("([0-1][0-9])|(2[0-3]):[0-5][0-9]:[0-5][0-9]");
        Pattern toFindDouble = Pattern.compile("[0-9]+[.][0-9]*");
        Pattern toFindWord = Pattern.compile("[a-zA-Z]+");

        String buffer[] = input.split("[;_-]");

        for (int i =0; i< buffer.length; i++){
            Leks.add(buffer[i]);
        }
    }

    @Override
    public String toString() {
        String result="";
        int count=1;
        for(String a : Leks)
        {
            result=result+" " +a;
        }
        return result;
    }

    static class SentenceComparator implements Comparator<Tokens>
    {
        public int compare(Tokens sentence1, Tokens sentence2)
        {
            return sentence1.Leks.get(0).compareTo(sentence2.Leks.get(0));
        }
    }

    public String toXML()
    {
        StringBuilder stBuild = new StringBuilder();
        for (String it: Leks)
        {
            stBuild.append("\t\t<token>").append(it).append("</token>").append("\n");
        }
        return stBuild.toString();
    }
}

