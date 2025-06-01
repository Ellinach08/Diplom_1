import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {

    private final String name;
    private final float price;
    private Bun bun;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Булка {0} за цену {1}" )
    public static Object[][] getParameters() {
        return new Object[][] {
                {"black bun", 100.0F},
                {"white bun", 200.0F},
                {"red bun", 300.0F}
        };
    }

    @Before
    public void setUp(){
        bun = new Bun(name, price);
    }

    @Test
    public void getNameTest() {
        String actualName = bun.getName();
        assertEquals(name, actualName);
    }
    @Test
    public void getPriceTest() {
        float actualPrice = bun.getPrice();
        assertEquals(price, actualPrice, 0);
    }
}
