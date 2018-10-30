package com.zh.myjdk;

import com.zh.jdk.Person;

import java.lang.reflect.Method;

public class ZhLawyer implements ZhInvocationHandler {
    private Person person;
    public Object getInstance(Person person){
        this.person=person;
        Class<?>clazz=person.getClass();
        return ZhProxy.newProxyInstance(new ZhClassLoader(),clazz.getInterfaces(),this);
    }

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        System.out.println("我是代理律师-----");
        method.invoke(this.person,objects);
        System.out.println("好了，所有事情都交给我吧");
        return this;
    }
}
