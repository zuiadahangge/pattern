import com.zh.singleton.lazy.LazyOne;
import com.zh.singleton.lazy.LazyTwo;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;

public class LazyTwoTest {
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
                System.out.println(LazyTwo.getInstance());
            }).start();
            latch.countDown();
        }
        System.out.println("开始");


    }


    @Test
    public void test2(){
        long start=System.currentTimeMillis();
        for (int i=0;i<100000;i++){
            LazyTwo.getInstance();
        }
        System.out.println("耗时"+(System.currentTimeMillis()-start));
    }
}
