import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tokens {

    ArrayList<String> leks;

   /* public Tokens(String input) {

        leks = new ArrayList<>();

        Pattern toFindLong = Pattern.compile("^[1-9][0-9]*$");
        Pattern toFindTime = Pattern.compile("([0-1][0-9])|(2[0-3]):[0-5][0-9]:[0-5][0-9]");
        Pattern toFindDouble = Pattern.compile("[0-9]+[.][0-9]*");
        Pattern toFindWord = Pattern.compile("[a-zA-Z]+");

        String buffer[] = input.split("[;_-]");

        for (int i =0; i< buffer.length; i++){
            leks.add(buffer[i]);
        }
    }*/

    public Tokens(String input) {

        leks = new ArrayList<>();

        String buffer[] = input.split("[;_-]");

        for (int i =0; i< buffer.length; i++){
            leks.add(buffer[i]);
        }
    }

    public String getKey()
    {
        return leks.get(0);
    }

    public String toString() { // 2
        StringBuilder stBuild = new StringBuilder();
        for (String it: leks)
        {
            stBuild.append(it).append(" ");
        }
        return stBuild.toString();
    }

    static class SentenceComparator implements Comparator<Tokens>
    {
        public int compare(Tokens sentence1, Tokens sentence2)
        {
            return sentence1.leks.get(0).compareTo(sentence2.leks.get(0));
        }
    }

    private static boolean isDigit(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public String toXML()
    {
        StringBuilder stBuild = new StringBuilder();
        for (String it: leks)
        {
            stBuild.append("\t\t<token>").append(it).append("</token>").append("\n");
        }
        return stBuild.toString();
    }
}
