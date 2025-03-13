package model;


public class CarteSpeciale extends Cartes {
    private String effetSpecial;

    public CarteSpeciale(String nom, String description, String effetSpecial) {
        super(nom, description, CarteType.SPECIAL);
        this.effetSpecial = effetSpecial;
    }

    public String getEffetSpecial() {
        return effetSpecial;
    }

    @Override
    public void appliquerEffet(Pirate joueurActif, Pirate joueurCible) {
        switch (effetSpecial) {
            case "soins":
                appliquerEffetSoins(joueurActif);
                break;
            case "rejouer":
                appliquerEffetRejouer(joueurActif);
                break;
            default:
                break;
        }
    }



    private void appliquerEffetSoins(Pirate joueurActif) {
        int pointsDeVieRestores = 3;
        int nouvelleVie = joueurActif.getPointsDeVie() + pointsDeVieRestores;

        if (nouvelleVie > 5) {
            joueurActif.setPointsDeVie(5);
        } else {
            joueurActif.setPointsDeVie(nouvelleVie);
        }
    }

    private void appliquerEffetRejouer(Pirate joueurActif) {
        System.out.println(joueurActif.getNom() + " a jouer la carte 'Rejouer' et peut maintenant rejouer son tour.");
    }
}
