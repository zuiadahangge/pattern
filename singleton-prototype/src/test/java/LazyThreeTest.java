import com.zh.singleton.lazy.LazyThree;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.concurrent.CountDownLatch;

public class LazyThreeTest {
    @Test
    public void test(){
        int count=100;
        CountDownLatch latch=new CountDownLatch(count);
        long start=System.currentTimeMillis();
        for (int i=0;i<count;i++){
            new Thread(()->{
                try {
                    latch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println( LazyThree .getInstance());
            }).start();
            latch.countDown();
        }
        System.out.println("开始");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void test2(){
        Class<?> clazz = LazyThree.class;
        try {
            Constructor constructor= clazz.getDeclaredConstructor(null);
            constructor.setAccessible(true);
            Object object=constructor.newInstance();
            System.out.println(object);
            Field[] fields = clazz.getDeclaredFields();
            Arrays.stream(fields).forEach(field -> {
                field.setAccessible(true);
                try {
                    field.setBoolean(object,false);
                    System.out.println(constructor.newInstance());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                }
            });


        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }



}
