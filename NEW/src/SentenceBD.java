import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class SentenceBD {
    ArrayList<Tokens> sentenceList;

   public SentenceBD(BufferedReader reader) {
        sentenceList = new ArrayList<>();

        StringBuilder stBuild = new StringBuilder();
        Stream<String> stream1 = reader.lines();
        stream1.forEach(s -> stBuild.append(s));

        String in = stBuild.toString();
        String splice[] = in.split("[!?]");

        for (int i = 0; i < splice.length; i++) {
            {
                sentenceList.add(new Tokens(splice[i]));
            }
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
    public void writeLongNumbers(BufferedWriter writer) throws IOException // 4
    {
        ArrayList<String> result = new ArrayList<>();
        for (Tokens it : sentenceList) {
            for (String b : it.leks) {
                //За большие числа примем числа больше 10000
                if (isDigit(b) == true) {
                    int c = Integer.parseInt(b);
                    if (c > 10000) {
                        result.add(b);
                    }
                }
            }
        }
           // ArrayList<String> numbers = it.getLongNumbers();
            for (String num : result) {
                writer.write(num);
                writer.write(" ");
            }
            writer.newLine();
    }


    public void writeMap(BufferedWriter writer) throws IOException {
        HashMap<String, Tokens> map = new HashMap<>();
        for (Tokens it : sentenceList) {
            map.put(it.getKey(), it);
        }

        Collection<Tokens> res = map.values();

        for (Tokens it : res) {
            writer.write(it.toString());
            writer.newLine();
        }
    }

    public void outSortFirst(BufferedWriter writer) throws IOException {
        /*sentenceList.sort(new Tokens.CompareFirst());
        for (Tokens it : sentenceList) {
            writer.write(it.toString());
            writer.newLine();
        }*/
        Comparator<Tokens> compare;
        compare = new Tokens.SentenceComparator();
        sentenceList.sort(compare);

        for (Tokens it : sentenceList) {
            writer.write(it.toString());
            writer.newLine();
        }
    }

    public void serializeToXML(BufferedWriter writer) throws IOException {
        writer.write("<SentenceBD>");
        writer.newLine();

        for (Tokens token : sentenceList) {
            writer.write("\t<Tokens>");
            writer.newLine();

            writer.write(token.toXML());

            writer.write("\t</Tokens>");
            writer.newLine();
        }

        writer.write("</SentenceBD>");
        writer.newLine();
    }

    public void outDeleteSubstrings(BufferedWriter writer) throws IOException {

        for (Tokens token : sentenceList) {
            String sentence = token.toString();

            Pattern pattern1 = Pattern.compile("((?: )[0-9]+(?: ))|(^[0-9]+(?: ))");
            Matcher matcher1 = pattern1.matcher(sentence);

            while (matcher1.find()) {
                String substring = sentence.substring(matcher1.start(), matcher1.end());
                int index = matcher1.end();

                Pattern pattern2 = Pattern.compile(substring);
                Matcher matcher2 = pattern2.matcher(sentence);
                matcher2.find();

                if (matcher2.find()) {
                    int index2 = matcher2.start();
                    sentence = sentence.substring(0, index) + sentence.substring(index2);
                }
            }
            writer.write(sentence);
            writer.newLine();
        }
    }
}

