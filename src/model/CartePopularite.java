package model;

public class CartePopularite extends Cartes {
    private int popularite;

    public CartePopularite(String nom, String description, int popularite) {
        super(nom, description, CarteType.POPULARITE);
        this.popularite = popularite;
    }

    public int getPopularite() {
        return popularite;
    }
    @Override
    
    public void appliquerEffet(Pirate lanceur, Pirate cible) {
        lanceur.ajouterPopularite(popularite);
    }

}