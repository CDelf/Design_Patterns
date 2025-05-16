package fr.diginamic.factory;

public class ElementFactory {

    public static Element getInstance(Type type, String nom, double valeur, Unite unite) {
        if(type == null) {
            return null;
        }
        return switch (type) {
            case INGREDIENT -> new Ingredient(nom, valeur, unite);
            case ADDITIF -> new Additif(nom, valeur, unite);
            case ALLERGENE -> new Allergene(nom, valeur, unite);
            default -> null;
        };
    }
}