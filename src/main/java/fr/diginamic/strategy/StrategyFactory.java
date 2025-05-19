package fr.diginamic.strategy;

public class StrategyFactory {

    public static Strategy getInstance(TypeTri type) {
        Strategy strategy;
       return switch (type) {
           case BUBBLE ->  strategy = new BubbleSort();
           case INSERTION -> strategy = new InsertionSort();
           case SELECTION -> strategy = new SelectionSort();
        };
    }
}
