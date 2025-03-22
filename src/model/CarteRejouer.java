package model;

public class CarteRejouer extends Cartes {
	private String effetSpecial;
	
	public CarteRejouer(String nom, String description, String effetSpecial) {
        super(nom, description, CarteType.SPECIAL);
        this.effetSpecial = effetSpecial;
    }


    @Override
    public void appliquerEffet(Pirate joueurActif, Pirate joueurCible) {
        appliquerEffetRejouer(joueurActif);
    }

    private void appliquerEffetRejouer(Pirate joueurActif) {
        System.out.println(joueurActif.getNom() + " a joué la carte 'Rejouer' et peut maintenant rejouer son tour.");
    }
}