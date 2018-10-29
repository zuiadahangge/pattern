package com.zh.statics;

public class Lawyer {
    private Person person;
    public static Lawyer getInstance(Person person){
        Lawyer lawyer=new Lawyer();
        lawyer.person=person;
        return lawyer;
    }

    public void askMoney(){
        System.out.println("律师：你违法了");
        this.person.askMoney();
        System.out.println("律师：对还他钱，抓紧");

    }

}
