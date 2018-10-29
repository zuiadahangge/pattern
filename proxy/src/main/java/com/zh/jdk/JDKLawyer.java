package com.zh.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKLawyer implements InvocationHandler {
    private Person person;

    public Object getInstance(Person person){
        this.person=person;
        Class<?> clzz=person.getClass();
        return Proxy.newProxyInstance(clzz.getClassLoader(),clzz.getInterfaces(),this);
    }

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {

        System.out.println("我是代理律师-----");
        method.invoke(this.person,objects);
        System.out.println("好了，所有事情都交给我吧");
        return this;
    }
}
