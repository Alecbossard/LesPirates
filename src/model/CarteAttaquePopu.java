package model;

public class CarteAttaquePopu extends Cartes {

    public CarteAttaquePopu(String nom, String description) {
        super(nom, description, CarteType.SPECIAL);
    }

    @Override
    public void appliquerEffet(Pirate pirateActuel, Pirate adversaire) {
        int degats = pirateActuel.getPopularite();
        adversaire.subirDegats(degats);
    }
}