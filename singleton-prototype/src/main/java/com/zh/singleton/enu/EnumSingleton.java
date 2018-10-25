package com.zh.singleton.enu;

public enum EnumSingleton {
    SINGLETON(){
        String  name="张三";
        int age=20;
        public    String getName(){
          return name;
        }
        public int getAge(){
            return age;
        }
    };

    public String getName() {
        return SINGLETON.getName();
    }

    public int getAge(){
        return SINGLETON.getAge();
    }
}
