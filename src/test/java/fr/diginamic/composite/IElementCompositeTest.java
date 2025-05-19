package fr.diginamic.composite;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class IElementCompositeTest {

    private Service dsin;
    private Service javaDev;
    private Service bigData;

    private Employe e1;
    private Employe e2;
    private Employe e3;
    private Employe e4;
    private Employe e5;
    private Employe e6;

    @BeforeEach
    public void setUp() {
        // Création du modèle de test
        dsin = new Service("DSIN");
        e1 = new Employe("Raspey", "Céline", 10000);
        e2 = new Employe("Bechkar", "Bilel", 8000);
        dsin.addComposant(e1);
        dsin.addComposant(e2);

        javaDev = new Service("Java Dev");
        e3 = new Employe("Guineau", "Kevin", 7500);
        e4 = new Employe("Martin", "Paul", 3500);
        javaDev.addComposant(e3);
        javaDev.addComposant(e4);

        bigData = new Service("Big Data");
        e5 = new Employe("Ranmey", "JB", 7500);
        e6 = new Employe("Doe", "Jane", 3500);
        bigData.addComposant(e5);
        bigData.addComposant(e6);

        dsin.addComposant(javaDev);
        dsin.addComposant(bigData);
    }

    @Test
    public void calculSalaireEmploye() {
        assertEquals(10000, e1.calculerSalaire());
        assertEquals(8000, e2.calculerSalaire());
        assertEquals(7500, e3.calculerSalaire());
        assertEquals(3500, e4.calculerSalaire());
        assertEquals(7500, e5.calculerSalaire());
        assertEquals(3500, e6.calculerSalaire());
    }

    @Test
    public void calculSalaireService() {
        assertEquals(11000, javaDev.calculerSalaire());
        assertEquals(11000, bigData.calculerSalaire());
        assertEquals(40000, dsin.calculerSalaire());
    }

    @Test
    public void calculSalaireServiceVide() {
        Service vide = new Service("Service Vide");
        assertEquals(0, vide.calculerSalaire());
    }

    @Test
    public void testSalaireNegatifNonAutorise() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Employe("Hack", "Zero", -500);
        });
    }

}
