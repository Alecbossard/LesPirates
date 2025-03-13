package model;

public class CarteNouvelMain extends Cartes {

    public CarteNouvelMain(String nom, String description) {
        super(nom, description, CarteType.SPECIAL);
    }

    @Override
    public void appliquerEffet(Pirate pirateActuel, Pirate adversaire) {
        for (int i = 0; i < pirateActuel.getTailleMain(); i++) {
            pirateActuel.retirerCarteDeLaMain(0);  
        }      
    }
}
