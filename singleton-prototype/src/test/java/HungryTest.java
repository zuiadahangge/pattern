import com.zh.singleton.hungry.Hungry;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;


public class HungryTest {
    @Test
    public void test(){
        int count=100;
        CountDownLatch latch=new CountDownLatch(count);
        long start=System.currentTimeMillis();
        for (int i=0;i<count;i++){
            new Thread(() -> {
                try {
                    latch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Hungry.instance());

            }).start();
            latch.countDown();
        }
        System.out.println("开始");

    }




}
