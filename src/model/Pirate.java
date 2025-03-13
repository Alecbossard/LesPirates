package model;

public class Pirate {
    static final int MAX_MAIN_SIZE = 5;  
    private static final int MAX_POPULARITE_CARDS = 5;  
    private String nom;
    private int popularite = 0;
    private int pointsDeVie = 5;
    private Cartes[] main = new Cartes[MAX_MAIN_SIZE];  
    private Cartes[] zonePopularite = new Cartes[MAX_POPULARITE_CARDS];  
    private int tailleMain = 0;  
    private int tailleZonePopularite = 0;  

    private boolean peutJouer = true;

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

    public Cartes[] getMain() {
        return main;
    }

    public int getTailleMain() {
        return tailleMain;
    }

    public Cartes[] getZonePopularite() {
        return zonePopularite;
    }

    public int getTailleZonePopularite() {
        return tailleZonePopularite;
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
        if (tailleMain < MAX_MAIN_SIZE) {
            main[tailleMain] = carte;
            tailleMain++;
        }
    }

    public void ajouterCarteALaZonePopularite(Cartes carte) {
        if (tailleZonePopularite < zonePopularite.length) {
            zonePopularite[tailleZonePopularite] = carte;
            tailleZonePopularite++;
        }
    }

    public boolean aGagne() {
        return this.popularite >= 5;
    }

    public boolean estVivant() {
        return this.pointsDeVie > 0;
    }

    public boolean peutJouer() {
        return peutJouer;
    }

    public void setPeutJouer(boolean peutJouer) {
        this.peutJouer = peutJouer;
    }

    public void setMain(Cartes[] main) {
        this.main = main;
    }

    public void setPointsDeVie(int i) {
        if (i < 0) {
            this.pointsDeVie = 0;  
        } else {
            this.pointsDeVie = i;
        }
    }
    public Cartes retirerCarteDeLaMain(int index) {
        if (index >= 0 && index < tailleMain) {
            Cartes carteRetiree = main[index];
            for (int i = index; i < tailleMain - 1; i++) {
                main[i] = main[i + 1];
            }
            main[tailleMain - 1] = null;
            tailleMain--;
            return carteRetiree;
        }
        return null;  
    }
}
