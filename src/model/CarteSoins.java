package model;

public class CarteSoins extends Cartes {
	private String effetSpecial;
	
	public CarteSoins(String nom, String description, String effetSpecial) {
        super(nom, description, CarteType.SPECIAL);
        this.effetSpecial = effetSpecial;
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
