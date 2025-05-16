package fr.diginamic.builder;

import java.util.ArrayList;
import java.util.List;

public class Produit {

    private String nom;
    private String grade;
    private Categorie categorie;
    private Marque marque;
    private List<Additif> additifs;
    private List<Ingredient> ingredients;
    private List<Allergene> allergenes;

    Produit(String nom, String grade) {
        this.nom = nom;
        this.grade = grade;
        this.ingredients = new ArrayList<>();
        this.additifs = new ArrayList<>();
        this.allergenes = new ArrayList<>();
    }

    public void addAdditif(Additif additif) {
        additifs.add(additif);
    }

    public void addIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
    }

    public void addAllergene(Allergene allergene) {
        allergenes.add(allergene);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public Marque getMarque() {
        return marque;
    }

    public void setMarque(Marque marque) {
        this.marque = marque;
    }

    List<Additif> getAdditifs() {
        return additifs;
    }

    List<Ingredient> getIngredients() {
        return ingredients;
    }

    List<Allergene> getAllergenes() {
        return allergenes;
    }
}
