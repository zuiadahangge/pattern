import com.zh.singleton.register.RegisterMap;
import org.junit.Test;

public class RegisterMapTest {
    @Test
    public void test() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        System.out.println(RegisterMap.getObject("com.zh.singleton.Dog"));
        System.out.println(RegisterMap.getObject("com.zh.singleton.Dog"));

    }
}
