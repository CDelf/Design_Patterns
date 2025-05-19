package fr.diginamic.composite;

public class Employe implements IElement {

    private String nom;
    private String prenom;
    private double salaire;

    public Employe(String nom, String prenom, double salaire) {
        if (salaire < 0) {
            throw new IllegalArgumentException("Le salaire ne peut pas être négatif.");
        }
        this.nom = nom;
        this.prenom = prenom;
        this.salaire = salaire;
    }

    @Override
    public double calculerSalaire() {
        return salaire;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public double getSalaire() {
        return salaire;
    }

    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }
}
