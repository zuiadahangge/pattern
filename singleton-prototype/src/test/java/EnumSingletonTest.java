import com.zh.singleton.enu.EnumSingleton;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class EnumSingletonTest {
    @Test
    public void test(){
        System.out.println(EnumSingleton.SINGLETON.getAge());
    }

    @Test
    public void test2(){
        Class<?> clazz = EnumSingleton.class;
        Constructor constructor= null;
        try {
            constructor = clazz.getDeclaredConstructor(null);
            constructor.setAccessible(true);
            Object object=constructor.newInstance();
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
