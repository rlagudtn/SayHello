package com.example.myapplication;

import java.io.Serializable;

public class Person implements Serializable {
    String name;
    String phoneNumber;
    String group;
    String birth;
    String memo;

    public Person() {
    }

    public Person(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.group = "기타";
    }

    public Person(String name, String phoneNumber, String group, String birth) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.group = group;
        this.birth = birth;
        this.memo = "";
    }
}
