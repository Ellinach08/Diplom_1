import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTest {

    private final IngredientType type;
    private final String name;
    private final float price;
    private Ingredient ingredient;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Before
    public void setUp(){
        ingredient = new Ingredient(type, name, price);
    }

    @Parameterized.Parameters(name = "Ингридиент {1} типа {0} за цену {2}" )
    public static Object[][] getParameters() {
        return new Object[][] {
                {IngredientType.SAUCE, "hot sauce", 100.0F},
                {IngredientType.SAUCE, "sour cream", 200.0F},
                {IngredientType.SAUCE, "chili sauce", 300.0F},
                {IngredientType.FILLING, "cutlet", 100.0F},
                {IngredientType.FILLING, "dinosaur", 200.0F},
                {IngredientType.FILLING, "sausage", 300.0F},
        };
    }

    @Test
    public void getPriceTest() {
        float actualPrice = ingredient.getPrice();
        assertEquals(price, actualPrice, 0);
    }

    @Test
    public void getNameTest() {
        String actualName = ingredient.getName();
        assertEquals(name, actualName);
    }

    @Test
    public void getIngredientTypeTest() {
        IngredientType actualType = ingredient.getType();
        assertEquals(type, actualType);
    }
}
