package fr.diginamic.builder;

public class ProduitBuilder {

    private Produit produit;

    public ProduitBuilder(String nom, String grade) {
        if (nom.isBlank() || grade.isBlank()) {
            throw new IllegalArgumentException("Nom de Produit non renseigné");
        }
        this.produit = new Produit(nom, grade);
    }

    public ProduitBuilder appendCategorie(String nom) {
        if (nom == null || nom.isBlank()) {
            throw new IllegalArgumentException("Nom de Catégorie non renseigné");
        }
        produit.setCategorie(new Categorie(nom));
        return this;
    }

    public ProduitBuilder appendMarque(String nom) {
        if (nom == null || nom.isBlank()) {
            throw new IllegalArgumentException("Nom de Marque non renseigné");
        }
        produit.setMarque(new Marque(nom));
        return this;
    }

    public ProduitBuilder appendAllergene(String nom, double qteMilligrammes) {
        if (nom == null || nom.isBlank() || qteMilligrammes < 0) {
            throw new IllegalArgumentException("Paramètres allergène invalides");
        }
        produit.addAllergene(new Allergene(nom, qteMilligrammes));
        return this;
    }

    public ProduitBuilder appendIngredient(String nom, double qteMilligrammes) {
        if (nom == null || nom.isBlank() || qteMilligrammes < 0) {
            throw new IllegalArgumentException("Paramètres ingrédient invalides");
        }
        produit.addIngredient(new Ingredient(nom, qteMilligrammes));
        return this;
    }

    public ProduitBuilder appendAdditif(String nom, double qteMilligrammes) {
        if (nom == null || nom.isBlank() || qteMilligrammes < 0) {
            throw new IllegalArgumentException("Paramètres additif invalides");
        }
        produit.addAdditif(new Additif(nom, qteMilligrammes));
        return this;
    }

    public Produit get() {
        return produit;
    }
}
