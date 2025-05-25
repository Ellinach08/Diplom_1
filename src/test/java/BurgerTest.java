import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    public Burger burger;
    @Mock
    private Bun bun;
    @Mock
    private Ingredient ingredient0, ingredient1, ingredient2;

    @Before
    public void createBurger() {
        burger = new Burger();
    }

    @Test
    public void setBunTest() {
        burger.setBuns(bun);
        assertEquals(bun.getName(), burger.bun.getName());
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredient0);
        assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void removeIngredientTest() {
        burger.ingredients.add(ingredient0);
        burger.ingredients.add(ingredient1);
        burger.ingredients.add(ingredient2);
        assertEquals(3, burger.ingredients.size());
        burger.removeIngredient(1);
        assertEquals(2, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest() {
        burger.ingredients.add(ingredient0);
        burger.ingredients.add(ingredient1);
        burger.ingredients.add(ingredient2);
        burger.moveIngredient(1, 0);
        assertEquals(3, burger.ingredients.size());
        assertEquals(ingredient1, burger.ingredients.get(0));
        assertEquals(ingredient0, burger.ingredients.get(1));
    }

    @Test
    public void getPriceTest() {
        burger.bun = bun;
        burger.ingredients.add(ingredient0);
        burger.ingredients.add(ingredient1);
        burger.ingredients.add(ingredient2);
        when(bun.getPrice()).thenReturn(20.0F);
        when(ingredient0.getPrice()).thenReturn(15.0F);
        when(ingredient1.getPrice()).thenReturn(10.0F);
        when(ingredient2.getPrice()).thenReturn(5.0F);
        float expectedPrice = (20.0F * 2) + 15.0F + 10.0F + 5.0F;
        assertEquals(expectedPrice, burger.getPrice(), 0);
    }

    @Test
    public void getReceiptTest() {
        burger.bun = bun;
        burger.ingredients.add(ingredient0);
        burger.ingredients.add(ingredient1);
        burger.ingredients.add(ingredient2);
        when(bun.getName()).thenReturn("bun");
        when(ingredient0.getType()).thenReturn(IngredientType.FILLING);
        when(ingredient1.getType()).thenReturn(IngredientType.FILLING);
        when(ingredient2.getType()).thenReturn(IngredientType.SAUCE);
        when(ingredient0.getName()).thenReturn("ingredient0");
        when(ingredient1.getName()).thenReturn("ingredient1");
        when(ingredient2.getName()).thenReturn("ingredient2");
        when(bun.getPrice()).thenReturn(20.0F);
        when(ingredient0.getPrice()).thenReturn(15.0F);
        when(ingredient1.getPrice()).thenReturn(10.0F);
        when(ingredient2.getPrice()).thenReturn(5.0F);
        String expectedReceipt = "(==== bun ====)\r\n" +
                "= filling ingredient0 =\r\n" +
                "= filling ingredient1 =\r\n"    +
                "= sauce ingredient2 =\r\n" +
                "(==== bun ====)\r\n" +
                "\r\n" +
                "Price: 70,000000\r\n";
        assertEquals(expectedReceipt, burger.getReceipt());
    }
}
