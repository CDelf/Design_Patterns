package fr.diginamic.composite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Service implements IElement{
    private String nom;
    private List<IElement> elements;

    public Service(String nom) {
        this.nom = nom;
        this.elements = new ArrayList<>();
    }

    @Override
    public double calculerSalaire() {
        return elements.stream().mapToDouble(e -> e.calculerSalaire()).sum();
    }

    public void addElement(IElement element) {
        elements.add(element);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<IElement> getElements() {
        return Collections.unmodifiableList(elements);
    }
}
