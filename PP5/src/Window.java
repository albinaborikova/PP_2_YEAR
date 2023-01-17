import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.util.*;

public class Window extends JFrame {

    private final JTextArea inputArea;
    private final ArrayList<Contact> contacts = new ArrayList<>();;
    private Comparator<Contact> comparator;
    private final ButtonGroup group = new ButtonGroup();

    JRadioButton rName = new JRadioButton("Name");
    JRadioButton rMobile = new JRadioButton("Mobile");
    JRadioButton rWorkMobile = new JRadioButton("Work Mobile");
    JRadioButton rHomeMobile = new JRadioButton("HomeMobile");
    JRadioButton rEmail = new JRadioButton("Email");
    JRadioButton rWeb = new JRadioButton("Web");
    JRadioButton rHome = new JRadioButton("Home");

    Window(String name){
        super(name);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        inputArea = new JTextArea();
        add(inputArea);

        JButton add = new JButton("Add");
        add(add);
        JButton open = new JButton("Open");
        add(open);
        JButton sort = new JButton("Sort");
        add(sort);

        JTextArea outputArea = new JTextArea();
        add(outputArea);

        addRadioButtons();
        addToGroup();

        add.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Scanner scanner = new Scanner(JOptionPane.showInputDialog(null, "Enter name, mobile, work mobile, home mobile, email, web and home using space."));
                try {
                    contacts.add(new Contact(scanner.next(), scanner.next(), scanner.next(), scanner.next(), scanner.next(), scanner.next(), scanner.next()));
                }catch (IllegalArgumentException | NoSuchElementException ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
                showInput();
            }
        });

        open.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JFileChooser fileChooser = new JFileChooser(".");
                if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    try {
                        Scanner scanner = new Scanner(fileChooser.getSelectedFile());
                        contacts.clear();
                        while (scanner.hasNext()){
                            contacts.add(new Contact(scanner.next(), scanner.next(), scanner.next(), scanner.next(), scanner.next(), scanner.next(), scanner.next()));
                        }
                        showInput();
                    } catch (IllegalArgumentException | FileNotFoundException | InputMismatchException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        sort.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setComparator(getSelectedComparator());
                StringBuilder stringBuilder = new StringBuilder();
                contacts.stream().sorted(comparator).forEach(med -> stringBuilder.append(med).append("\n"));
                outputArea.setText(stringBuilder.toString());
            }
        });

    }


    public static void main(String[] args){
        Window chooser = new Window("Main");
        chooser.setSize(1200, 500);
        chooser.setLocation(0, 50);
        chooser.setVisible(true);
    }

    private void showInput(){
        StringBuilder stringBuilder = new StringBuilder();
        for (Contact contact: contacts){
            stringBuilder.append(contact.toString()).append("\n");
        }
        inputArea.setText(stringBuilder.toString());
    }

    public void setComparator(String string) {
        this.comparator = new MyComparator(string);
    }

    private void addRadioButtons(){
        add(rName);
        rName.setSelected(true);
        add(rMobile);
        add(rWorkMobile);
        add(rHomeMobile);
        add(rEmail);
        add(rWeb);
        add(rHome);
    }

    private void addToGroup(){
        group.add(rName);
        group.add(rMobile);
        group.add(rWorkMobile);
        group.add(rHomeMobile);
        group.add(rEmail);
        group.add(rWeb);
        group.add(rHome);
    }

    private String getSelectedComparator() {
        if (rName.isSelected()) return "name";
        else if (rMobile.isSelected()) return "mobile";
        else if (rWorkMobile.isSelected()) return "work mobile";
        else if (rHomeMobile.isSelected()) return "home mobile";
        else if (rEmail.isSelected()) return "email";
        else if (rWeb.isSelected()) return "web";
        else if (rHome.isSelected()) return "home";
        return null;
    }
}
