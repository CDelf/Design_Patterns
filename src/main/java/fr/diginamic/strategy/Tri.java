package fr.diginamic.strategy;

public class Tri {

    // Définir une stratégie par défaut
    Strategy strategy = StrategyFactory.getInstance(TypeTri.BUBBLE);
    public void exec(Integer[] arr) {
        strategy.trier(arr);
    }

    public void modifierStrategie(TypeTri type) {
        if (type != null) {
            strategy = StrategyFactory.getInstance(type);
        } else {
            throw new IllegalArgumentException("Type de tri inconnu : " + type);
        }
    }
}


