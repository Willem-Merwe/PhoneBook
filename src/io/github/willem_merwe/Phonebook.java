package io.github.willem_merwe;

import java.util.ArrayList;

class Phonebook {
    String owner;
    String password;

    private ArrayList<PhonebookEntry> phoneBookEntries = new ArrayList<PhonebookEntry>(0);

    Phonebook(String owner, String password) {
        this.owner = owner;
        this.password = password;
    }

    protected String getOwner() {
        return this.owner;
    }

    protected boolean authorize(String password) {
        return this.password.equals(password);
    }

    protected void mainMenu() {
        System.out.println("\n\nMain Menu: (Please Select your option" +
                "\n1.) Add new Entry" +
                "\n2.) Delete an Entry" +
                "\n3.) Edit an Entry" +
                "\n4.) Lookup an Entry" +
                "\n5.) Logout");

        switch (PhonebookTools.userInputInteger()) {
            case 1:
                addEntry();
                break;
            case 2:
                deleteEntry();
                break;
            case 3:
                editEntry();
                break;
            case 4:
                lookupEntry();
                break;
            case 5:
                Main.start();
                break;
            default:
                System.out.println("\nIt seems you've entered the incorrect" +
                        " input. Please use 1-4 to select your menu item. Reloading Main Menu");
                mainMenu();
                break;
        }
    }

    private void addEntry() {
        String[] entryDetails = PhonebookTools.userInputAddEntry();

        if(entryExistByName(entryDetails[0])){
            PhonebookEntry entry = new PhonebookEntry(entryDetails[0], entryDetails[1], entryDetails[2], entryDetails[3]);
            phoneBookEntries.add(entry);
            System.out.println("Successfully added a new Entry. Moving to Main Menu");
        } else {
            System.out.println("Entry with name " + entryDetails[0] + " already exists.");
        }
        mainMenu();
    }

    private void deleteEntry() {
        phoneBookEntries.remove(phoneBookEntries.indexOf(findEntryByName()));
        mainMenu();
    }

    private void editEntry() {
        PhonebookEntry entry = findEntryByName();
        mainMenu();
    }

    private void lookupEntry() {
        System.out.println(findEntryByName().toString());
        mainMenu();
    }

    private PhonebookEntry findEntryByName(){
        for(PhonebookEntry entry: phoneBookEntries){
            if(entry.getName().equals(PhonebookTools.userInputEntryName())){
                return entry;
            }
        }
        System.out.println("Entry was not found.");

        mainMenu();
        return null;
    }

    private boolean entryExistByName(String entryName){
        for(PhonebookEntry entry: phoneBookEntries){
            if(entry.getName().equals(PhonebookTools.userInputEntryName())){
                return true;
            }
        }
        return false;
    }
}