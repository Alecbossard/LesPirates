package model;

public class CarteSoins extends Cartes {
	
	public CarteSoins(String nom, String description) {
        super(nom, description, CarteType.SPECIAL);
    }


    @Override
    public void appliquerEffet(Pirate joueurActif, Pirate joueurCible) {
    	int pointsDeVieRestores = 3;
        int nouvelleVie = joueurActif.getPointsDeVie() + pointsDeVieRestores;

        if (nouvelleVie > 5) {
            joueurActif.setPointsDeVie(5);
        } else {
            joueurActif.setPointsDeVie(nouvelleVie);
        }
    }
}     
