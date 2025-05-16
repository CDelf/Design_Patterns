package fr.diginamic.builder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProduitBuilderTest {

    @Test
    public void buildBasicProduct() {
        Produit p = new ProduitBuilder("p", "test").get();
        assertEquals("p", p.getNom());
        assertEquals("test", p.getGrade());
    }

    @Test
    public void buildCompleteProduct() {
        Produit p = new ProduitBuilder("p", "test")
                .appendCategorie("categ")
                .appendMarque("marque")
                .appendAdditif("add1", 12)
                .appendAdditif("add2", 14)
                .appendAllergene("all", 10)
                .appendIngredient("ing1", 8)
                .appendIngredient("ing2", 7)
                .appendIngredient("ing3", 6)
                .get();

        assertEquals("p", p.getNom());
        assertEquals("test", p.getGrade());
        assertEquals("categ", p.getCategorie().getNom());
        assertEquals("marque", p.getMarque().getNom());
        assertEquals(2, p.getAdditifs().size());
        assertEquals(1, p.getAllergenes().size());
        assertEquals(3, p.getIngredients().size());
    }

    @Test
    public void createProduitNomVide() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> new ProduitBuilder("", "A"));
        assertEquals("Nom de Produit non renseigné", ex.getMessage());
    }

    @Test
    public void createProduitCategorieNomNull() {
        ProduitBuilder pb = new ProduitBuilder("p", "test");
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
            pb.appendCategorie(null)
        );
        assertEquals("Nom de Catégorie non renseigné", exception.getMessage());
    }

    @Test
    public void createProduitMarqueNomVide() {
        ProduitBuilder pb = new ProduitBuilder("p", "test");
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
            pb.appendMarque(" ")
        );
        assertEquals("Nom de Marque non renseigné", exception.getMessage());
    }

    @Test
    public void addIngredientNegativeQte() {
        ProduitBuilder pb = new ProduitBuilder("p", "test");
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
            pb.appendIngredient("i", -5)
        );
        assertEquals("Paramètres ingrédient invalides", exception.getMessage());
    }

    @Test
    public void addAdditifNomNul() {
        ProduitBuilder pb = new ProduitBuilder("p", "test");
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
            pb.appendAdditif(null, 5)
        );
        assertEquals("Paramètres additif invalides", exception.getMessage());
    }

    @Test
    public void addAllergeneNomVide() {
        ProduitBuilder pb = new ProduitBuilder("p", "test");
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
            pb.appendAllergene(" ", 5)
        );
        assertEquals("Paramètres allergène invalides", exception.getMessage());
    }
}
