package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter password: ");
        String str = s.nextLine();
        String[] array = str.split("");
        PasswordCheck passwordCheck = new PasswordCheck();
        passwordCheck.CheckPassword(array);
    }
}
