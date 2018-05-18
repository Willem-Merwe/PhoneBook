package io.github.willem_merwe;

import java.util.Scanner;

class PhonebookTools {
    protected static Integer userInputInteger() {
        System.out.print("\nSelect Option: ");
        return Integer.parseInt(new Scanner(System.in).nextLine());
    }

    protected static String userInputString() {
        return new Scanner(System.in).nextLine();
    }

    protected static String userInputEntryName(){
        System.out.println("Enter the entry's name: ");
        return userInputString();
    }

    protected static String[] userInputAddEntry() {
        String[] entry = new String[4];

        System.out.print("Enter Name of Entry: ");
        entry[0] = userInputString();

        System.out.print("Enter E-mail of Entry: ");
        entry[1] = userInputString();

        System.out.print("Enter Address of Entry: ");
        entry[2] = userInputString();

        System.out.print("Enter Phone Number of Entry: ");
        entry[3] = userInputString();

        return entry;
    }

}
