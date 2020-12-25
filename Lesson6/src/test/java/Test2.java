import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class Test2 {
    Testing test;


    @Before
    public void init(){
        test = new Testing();
    }

    @Test
    public void test1(){
        Assert.assertTrue(test.hasOnAndFour(new int[]{1, 1, 1, 4, 4, 1, 4, 4}));
    }

    @Test
    public void test2(){
        Assert.assertFalse(test.hasOnAndFour(new int[]{1, 1, 1, 1}));
    }

    @Test
    public void test3(){
        Assert.assertFalse(test.hasOnAndFour(new int[]{1, 4, 4, 1, 1, 4, 3}));
    }
}
