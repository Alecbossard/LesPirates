package model;

public class Jeu {
    private Pirate pirate1;
    private Pirate pirate2;
    private Pioche pioche = new Pioche();
    private Pirate pirateActuel;
    private Pirate adversaire;
    private Cartes zoneAttaque;

    public Pirate getPirate1() {
        return pirate1;
    }

    public Pirate getPirate2() {
        return pirate2;
    }

    public Pioche getPioche() {
        return pioche;
    }

    public Pirate getPirateActuel() {
        return pirateActuel;
    }

    public Pirate getAdversaire() {
        return adversaire;
    }

    public Cartes getZoneAttaque() {
        return zoneAttaque;
    }

    public void initialiserJoueurs(String nomPirate1, String nomPirate2) {
        pirate1 = new Pirate(nomPirate1);
        pirate2 = new Pirate(nomPirate2);
        initialiserMain();
        pirateActuel = pirate1;
        adversaire = pirate2;
    }

    private void initialiserMain() {
        for (int i = 0; i < 4; i++) {
            pirate1.ajouterCarteALaMain(pioche.piocherCarte());
            pirate2.ajouterCarteALaMain(pioche.piocherCarte());
        }
    }

    public Cartes piocher() {
        Cartes nouvelleCarte = pioche.piocherCarte();
        pirateActuel.ajouterCarteALaMain(nouvelleCarte);
        return nouvelleCarte;
    }

    public boolean jouerCarte(int index) {
        Cartes carteJouee = pirateActuel.retirerCarteDeLaMain(index);
        carteJouee.appliquerEffet(pirateActuel, adversaire);
        

        if (carteJouee.getType() == CarteType.POPULARITE) {
            pirateActuel.ajouterCarteALaZonePopularite(carteJouee);
        } else if (carteJouee.getType() == CarteType.ATTAQUE) {
            zoneAttaque = carteJouee;
        }
        if (carteJouee.getType() != CarteType.ATTAQUE) {
            zoneAttaque = null;
        }
        if (carteJouee instanceof CarteSpeciale && ((CarteSpeciale) carteJouee).getNom().equals("Rejouer")) {
            return true;  
        }else {
        	return false;
        }
    }

    public void changerDeJoueur(){
        Pirate tmp = pirateActuel;
        pirateActuel = adversaire;
        adversaire = tmp;
    }

    public boolean estTerminee() {
        return pirate1.getPopularite() >= 5 || pirate2.getPopularite() >= 5 || pirate1.getPointsDeVie() <= 0
                || pirate2.getPointsDeVie() <= 0;
    }

    public Pirate getGagnant() {
        if (pirate1.getPopularite() >= 5) {
            return pirate1;
        } else if (pirate2.getPopularite() >= 5) {
            return pirate2;
        }
        if (pirate1.getPointsDeVie() <= 0) {
            return pirate2;
        } else if (pirate2.getPointsDeVie() <= 0) {
            return pirate1;
        }
        return null;
    }
}
