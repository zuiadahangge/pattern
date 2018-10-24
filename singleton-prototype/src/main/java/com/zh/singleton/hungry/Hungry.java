package com.zh.singleton.hungry;

public class Hungry {
    private static Hungry hungry=new Hungry();
    private Hungry(){
    }
    public static Hungry instance(){
        return hungry;
    }

}
