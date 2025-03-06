package model;

public class CartePopularite extends Cartes {
    private int popularite;
    private int coutHp;

    public CartePopularite(String nom, String description, int popularite, int coutHp) {
        super(nom, description, CarteType.POPULARITE);
        this.popularite = popularite;
        this.coutHp=coutHp;
    }

    public int getPopularite() {
        return popularite;
    }
    public int getCoutHp() {
    	return coutHp;
    }

    @Override
    public void appliquerEffet(Pirate joueurActif, Pirate joueurCible) {
        joueurActif.ajouterPopularite(popularite);  
    }
}
