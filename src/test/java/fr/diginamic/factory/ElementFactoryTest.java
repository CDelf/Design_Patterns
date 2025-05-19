package fr.diginamic.factory;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ElementFactoryTest {

    @Test
    public void createIngredientTest() {
        Element e1 = ElementFactory.getInstance(Type.INGREDIENT, "ing", 12, Unite.MICRO_GRAMMES);
        assertInstanceOf(Ingredient.class, e1);
        assertEquals("ing", e1.getNom());
        assertEquals(12, e1.getValeur());
        assertEquals(Unite.MICRO_GRAMMES, e1.getUnite());
    }

    @Test
    public void createAdditifTest() {
        Element e2 = ElementFactory.getInstance(Type.ADDITIF, "add", 20, Unite.MILLI_GRAMMES);
        assertInstanceOf(Additif.class, e2);
        assertEquals("add", e2.getNom());
        assertEquals(20, e2.getValeur());
        assertEquals(Unite.MILLI_GRAMMES, e2.getUnite());
    }

    @Test
    public void createAllergeneTest() {
        Element e3 = ElementFactory.getInstance(Type.ALLERGENE, "all", 8, Unite.MICRO_GRAMMES);
        assertInstanceOf(Allergene.class, e3);
        assertEquals("all", e3.getNom());
        assertEquals(8, e3.getValeur());
        assertEquals(Unite.MICRO_GRAMMES, e3.getUnite());
    }

    @Test
    public void testNullTypeThrowsException() {
        Element e4 = ElementFactory.getInstance(null, "nom", 1, Unite.MILLI_GRAMMES);
        assertNull(e4);
    }
}

