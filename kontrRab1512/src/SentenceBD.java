import java.util.*;
import java.io.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class SentenceBD {
    ArrayList<Tokens> SentensList;

    /*public SentenceBD(BufferedReader reader) {

        SentensList = new ArrayList<>();

        StringBuilder stBuild = new StringBuilder();
        Stream<String> stream1 = reader.lines();
        stream1.forEach(s -> stBuild.append(s));

        String in = stBuild.toString();
        String splice[] = in.split("[!?]");

        for (int i = 0; i < splice.length; i++) {
            {
                SentensList.add(new Tokens(splice[i]));
            }
        }
    }*/


    public SentenceBD(BufferedReader reader) {
        SentensList = new ArrayList<>();

        StringBuilder stBuild = new StringBuilder();
        Stream<String> stream1 = reader.lines();
        stream1.forEach(s -> stBuild.append(s));

        String in = stBuild.toString();
        String splice[] = in.split("[!?]");

        for (int i = 0; i < splice.length; i++) {
            {
                SentensList.add(new Tokens(splice[i]));
            }
        }
    }

    public void writeBigDigits(BufferedWriter writer, ArrayList<String> digits) throws IOException {

            for (String num : digits) {
                writer.write(num);
                writer.write(" ");
            }
            writer.newLine();
    }

    private static boolean isDigit(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static ArrayList<String> findBigDigits( ArrayList <Tokens> list) throws IOException {
        ArrayList<String> result = new ArrayList<>();
        for (Tokens a : list) {
            for (String b : a.Leks) {
                //За большие числа примем числа больше 10000
                if (isDigit(b) == true) {
                    int c = Integer.parseInt(b);
                    if (c > 10000) {
                        result.add(b);
                    }
                }
            }
        }
        return result;
    }


    public int Compare(Tokens sentence1, Tokens sentence2)
    {
        return sentence1.Leks.get(0).compareTo(sentence2.Leks.get(0));
    }

    public void sentensSort(BufferedWriter writer) throws IOException {
        Comparator<Tokens> compare;
        compare = new Tokens.SentenceComparator();
        SentensList.sort(compare);

        for (Tokens it : SentensList) {
            writer.write(it.toString());
            writer.newLine();
        }
    }

    public void writeMap(BufferedWriter writer) throws IOException {
        HashMap<String, Tokens> map = new HashMap<>();
        for (Tokens it : SentensList) {
            map.put(it.Leks.get(0), it);
        }

        Collection<Tokens> res = map.values();

        for (Tokens it : res) {
            writer.write(it.toString());
            writer.newLine();
        }
    }

    public void fileToXML(BufferedWriter writer) throws IOException {
            writer.write("<SentenceBD>");
            writer.newLine();

            for (Tokens token : SentensList) {
                writer.write("\t<Tokens>");
                writer.newLine();

                writer.write(token.toXML());

                writer.write("\t</Tokens>");
                writer.newLine();
            }

            writer.write("</SentenceBD>");
            writer.newLine();

    }


    
}
