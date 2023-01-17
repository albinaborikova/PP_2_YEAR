package com.company;
import java.util.*;
import java.util.Scanner;

public class Array {
    private int dim_1;
    private int dim_2;
    private ArrayList<ArrayList<Integer>> matrix;
    private ArrayList<Integer> tmp;

    public int getDim_1() {
        return dim_1;
    }

    public ArrayList<Integer> getString(int index) {
        return matrix.get(index);

    }

    public int getDim_2() {
        return dim_2;
    }

    public void goRand() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строки:");
        dim_1 = scanner.nextInt();
        System.out.println("Введите столбцы:");
        dim_2 = scanner.nextInt();
        Random rnd = new Random();
        matrix = new ArrayList<>();
        tmp = new ArrayList<>();
        for (int i = 0; i < dim_1; i++) {
            for (int j = 0; j < dim_2; j++) {
                tmp.add(rnd.nextInt(10));
            }
            matrix.add(tmp);
            tmp = new ArrayList<>();
        }
    }

    public void output() {
        for (int i = 0; i < dim_1; i++) {
            for (int j = 0; j < dim_2; j++) {
                System.out.printf("%4d\t", matrix.get(i).get(j));
                System.out.print(" ");
            }
            System.out.println("");
        }
        System.out.println("");
    }

    public void multiply(Array right) {
        int maxInString = 0;
        for (int i = 0; i < dim_1; i++) {

            ArrayList<Integer> str = new ArrayList<>();
            str.addAll(right.getString(i));
            Collections.sort(str);

            maxInString = str.get(right.getDim_2() - 1);
            for (int j = 0; j < dim_2; j++) {
                matrix.get(i).set(j, matrix.get(i).get(j) * maxInString);
            }
            maxInString = 0;

        }
    }
}
