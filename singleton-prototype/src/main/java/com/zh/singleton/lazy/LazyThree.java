package com.zh.singleton.lazy;

public class LazyThree {
    private static boolean init=false;
    private LazyThree(){
        synchronized (LazyThree.class){
            if (init){
                throw new RuntimeException("已经初始化了");
            }else {
                init=true;
            }
        }
    }
    public static LazyThree getInstance(){
        return LazyHolder.lazyThree;
    }

    private static class LazyHolder{
        private static final LazyThree lazyThree=new LazyThree();
    }
}
