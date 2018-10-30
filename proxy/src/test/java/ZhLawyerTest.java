import com.zh.jdk.Person;
import com.zh.jdk.ZhangSan;
import com.zh.myjdk.ZhLawyer;
import org.junit.Test;

public class ZhLawyerTest {
    @Test
    public void test(){
        ZhLawyer zhLawyer=new ZhLawyer();
        Person person=(Person)zhLawyer.getInstance(new ZhangSan());
        person.litigation();
        person.askMoney();
    }
}
