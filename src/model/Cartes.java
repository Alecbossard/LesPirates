package model;

public abstract class Cartes {
    private String nom;
    private String description;
    protected CarteType type;

    public Cartes(String nom, String description, CarteType type) {
        this.nom = nom;
        this.description = description;
        this.type=type;
    }
    public CarteType getType() {
    	return type;
    }

    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

    public abstract void appliquerEffet(Pirate joueurActif, Pirate joueurCible);
}
