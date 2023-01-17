
import java.util.Iterator;
import java.util.Scanner;

// Борикова Альбина
// Модифицировать условие задачи учитывая свои пожелания
//        Возможно  авторское условие задачи
//        Использовать контейнеры:
//        Vector, ArrayList, LinkedList, HashSet, TreeSet, HashMap, TreeMap.)
//
//        1) Задача "контакты"
//        а) разработать класс Контакт, определяющий запись в электронной книге мобильного
//        телефона и содержащий по меньшей мере следующие поля:
//        - *Наименование (имя человека или организации)
//        - *Номер телефона мобильного
//        - Номер телефона рабочего
//        - Номер телефона (домашнего)
//        - Адрес электронной почты
//        - Адрес веб-страницы
//        - Адрес
//
//        Обязательными является поля помеченные *, остальные поля могут быть пустыми- не реализованно
//
//        б) класс Контакт должен реализовать:
//        -интерфейс Comparable и Comparator с возможностью выбора одного из полей для сравнения
//        -интерфейс Iterator - индексатор по всем полям объекта Контакт
//        -метод для сохранения значений всех полей в строке текста (переопределить toString())
//        -конструктор или метод для инициализации объекта из строки текста
//
//        в) Для тестирования класса Контакт, создать консольное приложение позволяющее
//        создать небольшой массив контактов и напечатать отсортированными по
//        выбранному полю.
public class Contact implements Comparable<Contact>{
    private final String name;
    private final String mobile;
    private String workMobile = "unknown";
    private String homeMobile = "unknown";
    private String email = "unknown";
    private String web = "unknown";
    private String home = "unknown";

    @Override
    public String toString() {
        return  "name= " + name +
                ", mobile= " + mobile +
                ", work mobile= " + workMobile +
                ", home mobile= " + homeMobile +
                ", email= " + email +
                ", web= " + web +
                ", home= " + home;
    }

    public Contact(String name, String mobile, String workMobile , String homeMobile, String email, String web, String home){
        this(name, mobile);
        this.workMobile = workMobile;
        this.homeMobile = homeMobile;
        this.email = email;
        this.web = web;
        this.home = home;
    }

    public Contact(String data) {
        Scanner scanner = new Scanner(data);
        name = scanner.next();
        mobile = scanner.next();
        workMobile = scanner.next();
        homeMobile = scanner.next();
        email = scanner.next();
        web = scanner.next();
        home = scanner.next();
    }

    public Contact(String name, String mobile) {
        this.name = name;
        this.mobile = mobile;
    }

    @Override
    public int compareTo(Contact o) {
        return name.compareTo(o.name);
    }

    public int compareName(Contact o) {
        return name.compareTo(o.name);
    }

    public int compareMobile(Contact o) {
        return mobile.compareTo(o.mobile);
    }

    public int compareWorkMobile(Contact o) {
        return workMobile.compareTo(o.workMobile);
    }

    public int compareHomeMobile(Contact o) {
        return homeMobile.compareTo(o.homeMobile);
    }

    public int compareEmail(Contact o) {
        return email.compareTo(o.email);
    }

    public int compareWeb(Contact o) {
        return web.compareTo(o.web);
    }

    public int compareHome(Contact o) {
        return home.compareTo(o.home);
    }

    public MyIterator createIterator() {
        return new MyIterator();
    }
    private class MyIterator implements Iterator<String>{
        int index = 0;
        @Override
        public boolean hasNext() {
            return index <= 6;
        }



        @Override
        public String next() {
            index++;
            return switch (index){
                case 1 -> name;
                case 2 -> mobile;
                case 3 -> workMobile;
                case 4 -> homeMobile;
                case 5 -> email;
                case 6 -> web;
                case 7 -> home;
                default -> throw new IllegalStateException("Unexpected value:" + index);
            };
        }
    }


}

