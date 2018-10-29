import com.zh.cglib.CglibLawyer;
import com.zh.cglib.ZhangSan;
import org.junit.Test;

public class CglibLawyerTest {
    @Test
    public void test(){
        CglibLawyer cglibLawyer=new CglibLawyer();
        ZhangSan zhangSan=(ZhangSan)cglibLawyer.getInstance(ZhangSan.class);
        zhangSan.askMoney();
        System.out.println("--------------------------");
        zhangSan.litigation();
    }
}
