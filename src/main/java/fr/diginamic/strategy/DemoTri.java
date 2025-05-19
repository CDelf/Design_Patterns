package fr.diginamic.strategy;

import java.util.List;

public class DemoTri {

    public static void main(String[] args) {
        Tri tri = new Tri();
        Integer[] array = {12, -5, 7, 0, 8, 4, -3, 9, 15};
        tri.exec(array);
        List.of(array).forEach(i -> System.out.print(i + " "));
    }
}

