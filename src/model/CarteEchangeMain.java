package model;

public class CarteEchangeMain extends Cartes {

    public CarteEchangeMain(String nom, String description) {
        super(nom, description, CarteType.SPECIAL);  
    }

    @Override
    public void appliquerEffet(Pirate joueurActif, Pirate joueurCible) {
        
        System.out.println("Carte sp�ciale utilis�e : �change des mains des joueurs !");

        var mainJoueurActif = joueurActif.getMain();
        var mainJoueurCible = joueurCible.getMain();

       
        joueurActif.setMain(mainJoueurCible);
        joueurCible.setMain(mainJoueurActif);
    }
}
