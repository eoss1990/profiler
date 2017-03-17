import org.objectweb.asm.util.ASMifier;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by yangyu on 2017/3/16.
 */
public class Test {

    public static void main(String[] args) throws Exception {
        String[] strings = {"/Users/yangyu/Downloads/flowcompare/Flow.class"};
        ASMifier.main(strings);
    }

    @org.junit.Test
    public void date(){
        SimpleDateFormat time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(time.format(new Date()));
    }
}
