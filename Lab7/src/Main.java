import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.stream.Stream;

public class Main {

    public static int GetByShortTitle(String request, @NotNull ArrayList <Company> comp) throws IOException {
        int tmp=0;
        Readers.jsonWrite.write("//short title");
        Readers.jsonWrite.newLine();
        Readers.jsonWrite.write(" ");
        Readers.jsonWrite.newLine();
        Readers.xmlWrite.write("<!--short title-->");
        Readers.xmlWrite.newLine();
        Readers.xmlWrite.write(" ");
        Readers.xmlWrite.newLine();
        for(Company c : comp)
        {
            if(c.getShortTitle().equalsIgnoreCase(request))
            {
                Readers.souTCompany(c);
                tmp++;
            }
        }
        return tmp;
    }

    public static int GetByBranch(String request, @NotNull ArrayList <Company> comp) throws IOException {
        int tmp=0;
        Readers.jsonWrite.write("//branch");
        Readers.jsonWrite.newLine();
        Readers.jsonWrite.write(" ");
        Readers.jsonWrite.newLine();
        Readers.xmlWrite.write("<!--branch-->");
        Readers.xmlWrite.newLine();
        Readers.xmlWrite.write(" ");
        Readers.xmlWrite.newLine();
        for(Company c : comp)
        {
            if(c.getBranch().equalsIgnoreCase(request))
            {
                Readers.souTCompany(c);
                tmp++;
            }
        }
        return tmp;
    }

    public static int GetByActivity(String request, @NotNull ArrayList <Company> comp) throws IOException {
        int tmp=0;
        Readers.jsonWrite.write("//activity");
        Readers.jsonWrite.newLine();
        Readers.jsonWrite.write(" ");
        Readers.jsonWrite.newLine();
        Readers.xmlWrite.write("<!--activity-->");
        Readers.xmlWrite.newLine();
        Readers.xmlWrite.write(" ");
        Readers.xmlWrite.newLine();
        for(Company c : comp)
        {
            if(c.getActivity().equalsIgnoreCase(request))
            {
                Readers.souTCompany(c);
                tmp++;
            }
        }
        return tmp;
    }

    public static int GetByDateFoundation(String request, @NotNull ArrayList <Company> comp) throws IOException {
        int tmp=0;
        Readers.jsonWrite.write("//date of foundation");
        Readers.jsonWrite.newLine();
        Readers.jsonWrite.write(" ");
        Readers.jsonWrite.newLine();
        Readers.xmlWrite.write("<!--date of foundation-->");
        Readers.xmlWrite.newLine();
        Readers.xmlWrite.write(" ");
        Readers.xmlWrite.newLine();
        String[] str = request.split("-");
        int min=Integer.parseInt (str[0]);
        int max=Integer.parseInt (str[1]);
        for( Company c : comp)
        {
            int date=Integer.parseInt (c.getDateFoundation());
            if(date<=max && date>=min)
            {
                Readers.souTCompany(c);
                tmp++;
            }
        }
        return tmp;
    }

    public static int GetByCountEmployees(String request, @NotNull ArrayList <Company> comp) throws IOException {
        int tmp=0;
        Readers.jsonWrite.write("//employees");
        Readers.jsonWrite.newLine();
        Readers.jsonWrite.write(" ");
        Readers.jsonWrite.newLine();
        Readers.xmlWrite.write("<!--employees-->");
        Readers.xmlWrite.newLine();
        Readers.xmlWrite.write(" ");
        Readers.xmlWrite.newLine();
        String[] str = request.split("-");
        int min=Integer.parseInt (str[0]);
        int max=Integer.parseInt (str[1]);
        for( Company c : comp)
        {
            int date=Integer.parseInt (c.getCountEmployees());
            if(date<=max && date>=min)
            {
                Readers.souTCompany(c);
                tmp++;
            }
        }
        return tmp;
    }

    public static void main(String[] args) throws IOException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-dd-MM 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());

        ArrayList<Company> companiesFile = new ArrayList<>();
        Stream<String> inputs = Readers.fileIn.lines();
        try {
            inputs.forEach(s -> companiesFile.add(new Company(s)));
        } finally {
            inputs.close();
        }


        Readers.loggerTxt.write("Запуск произошел: <" + formatter.format(date) + ">");
        Readers.loggerTxt.newLine();

        int counter = 0;

        System.out.println("Введите имя компании для поиска: ");
        String shortname =  Readers.sysIn.readLine().toLowerCase();
        System.out.println("Результаты");
        counter=GetByShortTitle(shortname, companiesFile);
        System.out.println();

        Readers.loggerTxt.write("Искалось по имени: <" + shortname + ">, найдено: " + counter);
        Readers.loggerTxt.newLine();

        System.out.println("Введите отрасль компании для поиска: ");
        String branch =  Readers.sysIn.readLine().toLowerCase();
        System.out.println("Результаты");
        counter=GetByBranch(branch, companiesFile);
        System.out.println();

        Readers.loggerTxt.write("Искалось по отрасли: <" + branch + ">, найдено: " + counter);
        Readers.loggerTxt.newLine();


        System.out.println("Введите вид деятельности компании для поиска: ");
        String activity =  Readers.sysIn.readLine().toLowerCase();
        System.out.println("Результаты");
        counter=GetByActivity(activity, companiesFile);
        System.out.println();

        Readers.loggerTxt.write("Искалось по роду деятельности: <" + activity + ">, найдено: " + counter);
        Readers.loggerTxt.newLine();


        System.out.println("Введите дату основания компании для поиска, введя даты через дефис': ");
        String datereq =  Readers.sysIn.readLine().toLowerCase();
        System.out.println("Результаты");
        counter =GetByDateFoundation(datereq, companiesFile);
        System.out.println();

        Readers.loggerTxt.write("Искалось по дате основания в диапазоне [" + datereq + "], найдено: " + counter);
        Readers.loggerTxt.newLine();

        System.out.println("Введите численности сотрудников компании для поиска, введя промежуток через дефис: ");
        String employees=  Readers.sysIn.readLine().toLowerCase();
        System.out.println("Результаты");
        counter=GetByCountEmployees(employees, companiesFile);
        System.out.println();

        Readers.loggerTxt.write("Искалось по численности сотрудников в диапазоне [" + employees + "], найдено: " + counter);
        Readers.loggerTxt.newLine();

        Readers.loggerTxt.close();
        Readers.xmlWrite.close();
        Readers.jsonWrite.close();
    }
}