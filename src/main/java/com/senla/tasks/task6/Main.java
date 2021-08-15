package com.senla.tasks.task6;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static String[] zero =
                   {"  ***  ",
                    " *   * ",
                    "*     *",
                    "*     *",
                    "*     *",
                    " *   * ",
                    "  ***  "};

    static String[] one =
                   {"  *  ",
                    " **  ",
                    "  *  ",
                    "  *  ",
                    "  *  ",
                    "  *  ",
                    " *** "};

    static String[] two = {
            " *** ",
            "*   *",
            "*   *",
            "   * ",
            "  *  ",
            " *   ",
            "*****"};

    static String[] three = {
            " *****",
            "*    *",
            "    * ",
            "   *  ",
            "    * ",
            "*    *",
            "******"};

    static String[] four = {
            "   *  ",
            "  **  ",
            " * *  ",
            "*  *  ",
            "******",
            "    * ",
            "    * "};

    static String[] five = {
            " *****",
            " *    ",
            "*     ",
            " **** ",
            "     *",
            "*    *",
            " **** "};

    static String[] six = {
            "*****",
            "*   *",
            "*    ",
            "*****",
            "*   *",
            "*   *",
            "*****"};

    static String[] seven = {
            "*****",
            "    *",
            "   * ",
            "  *  ",
            " *   ",
            " *   ",
            " *   "};

    static String[] eight = {
            " *** ",
            "*   *",
            "*   *",
            " *** ",
            "*   *",
            "*   *",
            " *** "};

    static String[] nine = {
            " ****",
            "*   *",
            "*   *",
            " ****",
            "    *",
            "    *",
            "    *"};

    static void printNumberGraphically (int number){
        Map<String, String[]> map = new HashMap<>();
        map.put("0",zero);
        map.put("1",one);
        map.put("2",two);
        map.put("3",three);
        map.put("4",four);
        map.put("5",five);
        map.put("6",six);
        map.put("7",seven);
        map.put("8",eight);
        map.put("9",nine);

        String numberInStringFormat = String.valueOf(number);
        String[] listOfNumbers = numberInStringFormat.split("");

        int row = 0;
        while (row < 7) {
            for (String separatedNumber : listOfNumbers) {
                String[] graphicNumber = map.get(separatedNumber);
                System.out.print(graphicNumber[row].replace("*", separatedNumber) + "  ");
            }
            System.out.println();
            row++;
        }
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        printNumberGraphically(number);
    }
}
