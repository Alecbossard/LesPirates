package model;

public class CarteRejouer extends Cartes {
	
	public CarteRejouer(String nom, String description) {
        super(nom, description, CarteType.SPECIAL);
    }


    @Override
    public void appliquerEffet(Pirate joueurActif, Pirate joueurCible) {
    }

}