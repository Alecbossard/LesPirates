package jeu;
import java.util.ArrayList;
import java.util.List;

import cartes.Cartes;
import pirate.Pirate;



/**
 */
public class Jeu {
    private Pirate joueur1;
    private Pirate joueur2;
    private List<Cartes> deck;
    private int indexCarteProchaine;
    
    public Jeu(Pirate joueur1, Pirate joueur2, List<Cartes> deck) {
        this.joueur1 = joueur1;
        this.joueur2 = joueur2;
        this.deck = new ArrayList<>(deck);
        this.indexCarteProchaine = 0;

        for (int i = 0; i < 4; i++) {
            joueur1.ajouterCarteALaMain(piocherCarte());
            joueur2.ajouterCarteALaMain(piocherCarte());
        }
    }
    
    public Cartes piocherCarte() {
        if (indexCarteProchaine < deck.size()) {
            return deck.get(indexCarteProchaine++);
        }
        return null;
    }
    
}