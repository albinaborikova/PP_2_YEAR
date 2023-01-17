import java.util.Comparator;

public class MyComparator implements Comparator<Contact> {
    String parameter;
    MyComparator(String parameter){
        this.parameter = parameter;
    }

    @Override
    public int compare(Contact o1, Contact o2) {
        return switch (parameter) {
            case "name" -> o1.compareName(o2);
            case "mobile" -> o1.compareMobile(o2);
            case "work mobile" -> o1.compareWorkMobile(o2);
            case "home mobile" -> o1.compareHomeMobile(o2);
            case "email" -> o1.compareEmail(o2);
            case "web" -> o1.compareWeb(o2);
            case "home" -> o1.compareHome(o2);
            default -> 0;
        };
    }
}
