package model;

public abstract class CarteSpeciale extends Cartes {
    private String effetSpecial;

    public CarteSpeciale(String nom, String description, String effetSpecial) {
        super(nom, description, CarteType.SPECIAL);
        this.effetSpecial = effetSpecial;
    }

    public String getEffetSpecial() {
        return effetSpecial;
    }

    
    @Override
    public abstract void appliquerEffet(Pirate joueurActif, Pirate joueurCible);
}
