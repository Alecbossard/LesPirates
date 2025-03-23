package model;

public class CarteEchangeMain extends Cartes {

    public CarteEchangeMain(String nom, String description) {
        super(nom, description, CarteType.SPECIAL);
    }

    @Override
    public void appliquerEffet(Pirate pirateActuel, Pirate adversaire) {
        Cartes[] tempMain = pirateActuel.getMain();
        pirateActuel.setMain(adversaire.getMain());
        adversaire.setMain(tempMain);
    }
}