package io.github.willem_merwe;

import java.util.ArrayList;

public class Main {

    private static ArrayList<Phonebook> phonebookList = new ArrayList<Phonebook>(0);

    public static void main(String[] args) {
        start();
    }

    public static void start(){
        while(true){
            System.out.print("Welcome to your PhoneBook Application!" +
                    "\n1.) Login" +
                    "\n2.) Quit");

            int input = PhonebookTools.userInputInteger();

            switch(input){
                case 1:
                    login();
                    break;
                case 2:
                    System.exit(1);
                    break;
                default:
                    System.out.println("\nIt seems you've entered the incorrect" +
                        " input. Please use 1-2 to select your menu item.");
                    start();
                    break;
            }
        }
    }

    private static void login(){
        System.out.print("\nPlease enter your Username: ");
        String username = PhonebookTools.userInputString();

        if(!userAuth(username)){
            System.out.print(username + " doesn't exist, would you like to create a new Phonebook for this user? (Y/N)" +
                    "\nOption: ");
            String answer = PhonebookTools.userInputString();
            switch(answer.toUpperCase()){
                case "Y": addPhonebook(username); break;
                case "N": login(); break;
                default: System.out.println("Your input was invalid. Please try again!");
            }
        } else {
            System.out.print("Please enter your password: ");
            String password = PhonebookTools.userInputString();
            if(loginAuth(username, password)){
                for(Phonebook i: phonebookList){
                    if (i.getOwner().equals(username)){
                        i.mainMenu();
                    }
                }
            } else {
                System.out.println("The login details you've entered are invalid. Please try again!");
            }
        }
    }

    private static boolean loginAuth(String username, String password){
        for(Phonebook i: phonebookList){
            if (i.getOwner().equals(username) && i.authorize(password)){
                return true;
            }
        }
        return false;
    }

    private static boolean userAuth(String username){
        for(Phonebook i : phonebookList){
            if (i.getOwner().equals(username)){
                return true;
            }
        }
        return false;
    }

    private static void addPhonebook(String username){
        System.out.print("\nPlease enter a password for " + username + ": ");
        String password = PhonebookTools.userInputString();
        System.out.print("Please enter your password again to verify: ");
        String passwordVerify = PhonebookTools.userInputString();

        if(password.equals(passwordVerify)){
            phonebookList.add(new Phonebook(username, password));
            login();
        } else {
            System.out.println("Your passwords did not match. Please try again!");
            addPhonebook(username);
        }
    }
}