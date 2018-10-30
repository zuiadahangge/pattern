package com.zh.myjdk;

import java.lang.reflect.Method;

public interface ZhInvocationHandler {
    Object invoke(Object o, Method method, Object[] objects) throws Throwable;
}
