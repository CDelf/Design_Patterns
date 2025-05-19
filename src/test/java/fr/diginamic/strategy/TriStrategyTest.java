package fr.diginamic.strategy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TriStrategyTest {

    private Integer[] originalArr1;
    private Integer[] originalArr2;
    private Tri tri;

    @BeforeEach
    public void setUp() {
        originalArr1 = new Integer[]{9, 1, 4, 15};
        originalArr2 = new Integer[]{0, -10, 5, -2};
        tri = new Tri();
    }

    @Test
    public void testBubbleTri() {
        Integer[] arr1 = originalArr1.clone();
        Integer[] arr2 = originalArr2.clone();
        tri.exec(arr1);
        tri.exec(arr2);

        assertArrayEquals(new Integer[]{1, 4, 9, 15}, arr1);
        assertArrayEquals(new Integer[]{-10, -2, 0, 5}, arr2);
    }

    @Test
    public void testInsertionTri() {
        Integer[] arr1 = originalArr1.clone();
        Integer[] arr2 = originalArr2.clone();

        tri.modifierStrategie(TypeTri.INSERTION);
        tri.exec(arr1);
        tri.exec(arr2);

        assertArrayEquals(new Integer[]{1, 4, 9, 15}, arr1);
        assertArrayEquals(new Integer[]{-10, -2, 0, 5}, arr2);
    }

    @Test
    public void testSelectionTri() {
        Integer[] arr1 = originalArr1.clone();
        Integer[] arr2 = originalArr2.clone();

        tri.modifierStrategie(TypeTri.SELECTION);
        tri.exec(arr1);
        tri.exec(arr2);

        assertArrayEquals(new Integer[]{1, 4, 9, 15}, arr1);
        assertArrayEquals(new Integer[]{-10, -2, 0, 5}, arr2);
    }
}
