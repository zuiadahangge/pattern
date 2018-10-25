package com.zh.singleton.register;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RegisterMap {
    private static final Map<String,Object> map=new ConcurrentHashMap<>();
    public static Object getObject(String className) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        if (map.containsKey(className))return map.get(className);
        Object o=Class.forName(className).newInstance();
        map.put(className,o);
        return o;
    }

}
