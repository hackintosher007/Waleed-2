package com.example.adhfixer.waleed;

public class User {
    private String Name;
    private String Age;
    private String Number;
    private String Language;

    public User(){
        super();
    }
    public User(String name, String age, String number, String language) {

        Name = name;
        Age = age;
        Number = number;
        Language = language;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }

    public String getLanguage() {
        return Language;
    }

    public void setLanguage(String language) {
        Language = language;
    }


}
