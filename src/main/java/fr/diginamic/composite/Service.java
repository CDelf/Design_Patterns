package fr.diginamic.composite;

import java.util.ArrayList;
import java.util.List;

public class Service implements IElement{
    private String nom;
    private List<IElement> composants;

    public Service(String nom) {
        this.nom = nom;
        this.composants = new ArrayList<>();
    }

    @Override
    public double calculerSalaire() {
        double total = 0;
        for (IElement c : composants) {
            total += c.calculerSalaire();
        }
        return total;
    }

    public void addComposant(IElement composant) {
        composants.add(composant);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<IElement> getComposants() {
        return composants;
    }

    public void setComposants(List<IElement> composants) {
        this.composants = composants;
    }
}
