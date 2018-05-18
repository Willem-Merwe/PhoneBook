package io.github.willem_merwe;

class PhonebookEntry {
    private String name;
    private String email;
    private String address;
    private String phoneNumber;

    PhonebookEntry(String name, String email, String address, String phoneNumber){
        this.name = name;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    String getName(){
        return this.name;
    }

    String getEmail(){
        return this.email;
    }

    String getAddress(){
        return this.address;
    }

    String getPhoneNumber(){
        return this.phoneNumber;
    }

    void setName(String name){
        this.name = name;
    }

    void setEmail(String email){
        this.email = email;
    }

    void setAddress(String address){
        this.address = address;
    }

    void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "PhonebookEntry:" +
                "\nname='" + name +
                "\nemail='" + email+
                "\naddress='" + address +
                "\nphoneNumber='" + phoneNumber;
    }
}
