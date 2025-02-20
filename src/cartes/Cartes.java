package cartes;

import pirate.Pirate;

public  class Cartes {
    private String nom;
    private int pointvie ;
    private int popu ;
    private boolean me;


    public Cartes(String nom, int pointvie, int popu, boolean me) {
        this.nom = nom;
        this.pointvie = pointvie;
        this.popu = popu;
        this.me = me;
    }
    public String getNom() {
        return nom;
    }
    public int getPointvie() {
        return pointvie;
    }
    public int getPopu() {
        return popu;
    }
    public boolean isMe() {
        return me;
    }
    
    public void appliquerEffet(Pirate joueurCible, Pirate joueurActif) {
     if (me) {
    	 joueurActif.subirDegats(pointvie); 
    	 joueurActif.ajouterPopularite(popu);
     }else {
    	 joueurCible.subirDegats(pointvie); 
    	 joueurCible.ajouterPopularite(popu);
     	}
     }
}
