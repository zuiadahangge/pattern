package com.zh.cglib;

import com.zh.jdk.Person;

public class ZhangSan implements Person {
    @Override
    public void askMoney() {
        System.out.println("还我血汗钱");
    }

    @Override
    public void litigation() {
        System.out.println("我要告你，你个破公司，骗子");
    }
}
