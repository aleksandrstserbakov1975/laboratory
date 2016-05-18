package ee.test;

import org.junit.Before;
import org.junit.Test;

public class Test1 {

    @Before
    public void init(){
        
    }
    
    @Test
    public void test1(){
        Main m = new Main();
        m.main(new String[] {"Mr X"});
    }
    
}
