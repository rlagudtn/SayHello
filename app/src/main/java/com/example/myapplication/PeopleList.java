package com.example.myapplication;

import java.util.Vector;

public class PeopleList {
    private Vector<Person> persons;

    //생성자
    public PeopleList(){
        this.persons=new Vector<Person>();
    }
    public PeopleList(Vector<Person> persons){
        this.persons=persons;
    }
    //getPersonSize
    public  int getSize(){
        return this.persons.size();
    }
    //getAt
    public Person getPerson(int i){
        return this.persons.get(i);
    }

    //삽입
    public void addPerson(Person person){
        this.persons.add(person);
    }
    //삭제
    public void delete(int i){
        this.persons.remove(i);
    }
    //수정
    public void modify(int i,Person person){
        this.persons.set(i,person);
    }

    //검색
    public Vector<Person> searchPerson(String name) {
        Vector<Person> found=new Vector<Person>();
        for (int i=0;i<this.persons.size();i++){
            Person person=this.persons.get(i);
            if(person.name ==name) found.add(person);
        }

        return found;
    }



}
