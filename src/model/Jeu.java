package model;

import java.util.Random;

public class Jeu {
    private Pirate joueur1;
    private Pirate joueur2;
    private Pioche pioche = new Pioche();
    private Pirate joueurActuel;
    private Pirate adversaire;
    private Cartes zoneAttaque;

    public Pirate getJoueur1() {
        return joueur1;
    }

    public Pirate getJoueur2() {
        return joueur2;
    }

    public Pirate getJoueurActuel() {
        return joueurActuel;
    }

    public Pirate getAdversaire() {
        return adversaire;
    }

    public Cartes getZoneAttaque() {
        return zoneAttaque;
    }

    public void initialiserJoueurs(String nomJoueur1, String nomJoueur2) {
        joueur1 = new Pirate(nomJoueur1);
        joueur2 = new Pirate(nomJoueur2);
        initialiserMains();
        joueurActuel = joueur1;
        adversaire = joueur2;
    }

    private void initialiserMains() {
        for (int i = 0; i < 4; i++) {
            joueur1.ajouterCarteALaMain(pioche.piocherCarte());
            joueur2.ajouterCarteALaMain(pioche.piocherCarte());
        }
    }

    public Cartes piocher() {
        Cartes nouvelleCarte = pioche.piocherCarte();
        joueurActuel.ajouterCarteALaMain(nouvelleCarte);
        return nouvelleCarte;
    }

    public boolean jouerCarte(int index) {
        Cartes carteJouee = joueurActuel.getMain().get(index);
        carteJouee.appliquerEffet(joueurActuel, adversaire);
        joueurActuel.getMain().remove(index);

        if (carteJouee instanceof CartePopularite) {
            joueurActuel.getZonePopularite().add(carteJouee);
            zoneAttaque = null;
        } else if (carteJouee instanceof CarteAttaque) {
            zoneAttaque = carteJouee;
        } else if (carteJouee instanceof CarteSpeciale) {
            CarteSpeciale carteSpeciale = (CarteSpeciale) carteJouee;
            switch (carteSpeciale.getEffetSpecial()) {
                case "rejouer":
                    return true; 
                case "soins":
                    appliquerSoins(joueurActuel); 
                    break;
                default:
                    break;
            }
        }
        return false;
    }

    private void appliquerSoins(Pirate joueurActif) {
        int pointsDeVie = joueurActif.getPointsDeVie();
        if (pointsDeVie < 5) {
            joueurActif.setPointsDeVie(Math.min(5, pointsDeVie + 2)); 
        }
    }



    public void changerDeJoueur() {
        if (joueurActuel == joueur1) {
            joueurActuel = joueur2;
            adversaire = joueur1;
        } else {
            joueurActuel = joueur1;
            adversaire = joueur2;
        }
    }

    public boolean estTerminee() {
        return joueur1.getPopularite() >= 5 || joueur2.getPopularite() >= 5 || joueur1.getPointsDeVie() <= 0
                || joueur2.getPointsDeVie() <= 0;
    }

    public Pirate getGagnant() {
        if (joueur1.getPopularite() >= 5) {
            return joueur1;
        } else if (joueur2.getPopularite() >= 5) {
            return joueur2;
        }
        if (joueur1.getPointsDeVie() <= 0) {
            return joueur2;
        } else if (joueur2.getPointsDeVie() <= 0) {
            return joueur1;
        }
        return null;
    }


    public Pirate getJoueurCible() {
        return adversaire; 
    }
    public Cartes piocherCarte() {
        if (!pioche.isEmpty()) {
            return pioche.piocherCarte();
        }
        return null;  
    }

	public Pioche getPioche() {
		return pioche;
	}
}
