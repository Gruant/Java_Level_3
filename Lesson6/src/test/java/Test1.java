import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class Test1 {


    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        return Arrays.asList(new Object[][] {
                {new int[]{1, 4, 3}, new int[]{3}},
                {new int[]{0,1,2,4,3}, new int[]{3}},
                {new int[]{4,1,2,3,5}, new int[]{1,2,3,5}},
                {new int[]{4, 2, 6, 8, 12}, new int[]{2,6,8,12}},
        });
    }

    private int[] actual;
    private int[] expected;
    Testing test;

    public Test1(int[] actual, int[] expected) {
        this.actual = actual;
        this.expected = expected;
    }

    @Before
    public void init(){
        test = new Testing();
    }

    @Test
    public void test1(){
        System.out.println("Ожидаем: " + Arrays.toString(expected));
        System.out.println("Подаем в функцию: " + Arrays.toString(actual));
        System.out.println("Массив из функции: " + Arrays.toString(test.afterFour(actual)));
        System.out.println();
        Assert.assertArrayEquals(expected, test.afterFour(actual));
    }

    @Test(expected = RuntimeException.class)
    public void test2() {
        Assert.assertArrayEquals(new int[]{1}, test.afterFour(new int[]{1, 2, 3}));
    }
}
