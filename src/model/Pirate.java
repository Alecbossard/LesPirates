package model;

import java.util.List;
import java.util.ArrayList;

public class Pirate {
    private String nom;
    private int popularite = 0;
    private int pointsDeVie = 5;
    private List<Cartes> main = new ArrayList<>();
    private List<Cartes> zonePopularite = new ArrayList<>();

    public Pirate(String nom) {
        this.nom = nom;
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

    public List<Cartes> getZonePopularite() {
        return zonePopularite;
    }

    public void ajouterPopularite(int points) {
        this.popularite += points;
    }

    public void subirDegats(int points) {
        this.pointsDeVie -= points;
        if (this.pointsDeVie < 0) {
            this.pointsDeVie = 0;
        }
    }

    public void ajouterCarteALaMain(Cartes carte) {
        this.main.add(carte);
    }

    public boolean aGagne() {
        return this.popularite >= 5;
    }

    public boolean estVivant() {
        return this.pointsDeVie > 0;
    }
    public void setMain(List<Cartes> main) {
        this.main = main;
    }
}
