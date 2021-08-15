package com.senla.tasks.task4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int  number;
        int divisor = 2;
        try{
            number = scanner.nextInt();
            while (divisor * divisor <= number)
            {
                if (number % divisor == 0)
                {
                    System.out.println(divisor);
                    number /= divisor;
                }
                else if (divisor == 2){
                    divisor = 3;
                }
                else {
                    divisor += 2;
                }
            }
            System.out.println(number);
        }catch (InputMismatchException e){
            System.out.println("Entered value is not a valid integer!!!");
            System.out.println("Enter a positive integer more than one!");
        }
    }
}
