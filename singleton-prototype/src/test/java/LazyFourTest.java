import com.zh.singleton.lazy.LazyFour;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class LazyFourTest {
    @Test
    public void test(){
        Class<?> clazz = LazyFour.class;
        try {
            Constructor constructor= clazz.getDeclaredConstructor(null);
            constructor.setAccessible(true);
            Object object=constructor.newInstance();
            System.out.println(object);

            System.out.println(constructor.newInstance());

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
