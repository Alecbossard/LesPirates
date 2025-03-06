package model;

public class CarteAttaque extends Cartes {
    private int degats;

    public CarteAttaque(String nom, String description, int degats) {
        super(nom, description, CarteType.ATTAQUE);
        this.degats = degats;
    }

    public int getDegats() {
        return degats;
    }

    @Override
    public void appliquerEffet(Pirate joueurActif, Pirate joueurCible) {
        joueurCible.subirDegats(degats);  
    }
}
