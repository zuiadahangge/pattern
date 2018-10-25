package com.zh.singleton.lazy;

public class LazyFour {
    private static final LazyFour lazyFour=new LazyFour();
    private LazyFour(){

    }
    public static LazyFour getInstance(){
        return lazyFour;
    }
}
