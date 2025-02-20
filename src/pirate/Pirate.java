package pirate;

import java.util.ArrayList;
import java.util.List;

import cartes.Cartes;


public class Pirate {
    private String nom;
    private int pointsDeVie;
    private int popularite;
    private List<Cartes> main;

    public static int MAX_VIE = 5;	
    public static int OBJECTIF_POPULARITE = 5;

    public Pirate(String nom) {
        this.nom = nom;
        this.pointsDeVie = MAX_VIE;
        this.popularite = 0;
        this.main = new ArrayList<>();
    }

    public String getNom() {
        return nom;
    }

    public int getPointsDeVie() {
        return pointsDeVie;
    }

    public int getPopularite() {
        return popularite;
    }

    public List<Cartes> getMain() {
        return main;
    }


    public void ajouterCarteALaMain(Cartes carte) {
        main.add(carte);
    }

    public void jouerCarte(Cartes carte, Pirate adversaire) {
        carte.appliquerEffet(adversaire, this);
        main.remove(carte);
    }


    public void ajouterPopularite(int points) {
        popularite += points;
    }

    public void subirDegats(int degats) {
        pointsDeVie -= degats;
        if(pointsDeVie < 0)
            pointsDeVie = 0;
    }

    public boolean aGagne() {
        return popularite >= OBJECTIF_POPULARITE;
    }

    public boolean estVivant() {
        return pointsDeVie > 0;
    }
}