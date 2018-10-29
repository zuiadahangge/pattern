import com.zh.statics.Lawyer;
import com.zh.statics.Person;
import org.junit.Test;

public class LawerTest {
    @Test
    public void test(){
        Lawyer.getInstance(new Person()).askMoney();
    }
}
