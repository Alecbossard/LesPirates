package model;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Pioche {
    private List<Cartes> cartes;
    private Random random;

    public Pioche() {
        cartes = new ArrayList<>();
        random = new Random();
        initialiserPioche();
    }

    private void initialiserPioche() {
        cartes.add(new CartePopularite("Discours Inspirant", "Gagne en popularité.", 1));
        cartes.add(new CartePopularite("Révolte Organisée", "Gagne en popularité.", 1));
        cartes.add(new CartePopularite("Abordage Réussi", "Gagne beaucoup de popularité.", 2));
        cartes.add(new CartePopularite("Poing de Fer", "Gagne en popularité.", 2));

        cartes.add(new CarteAttaque("Frappe de Sabre", "Inflige des dégâts à l'adversaire.", 2));
        cartes.add(new CarteAttaque("Explosion de Canon", "Inflige de lourds dégâts à l'adversaire.", 3));

        cartes.add(new CarteSpeciale("Rejouer", "Permet de rejouer immédiatement après avoir joué cette carte.", "rejouer"));
        cartes.add(new CarteSpeciale("Soins", "Soigne le joueur, régénère des points de vie.", "soins"));

        for (int i = 0; i < 4; i++) {
            cartes.add(new CartePopularite("Discours Inspirant", "Gagne en popularité.", 1));
            cartes.add(new CartePopularite("Révolte Organisée", "Gagne en popularité.", 1));
            cartes.add(new CarteAttaque("Frappe de Sabre", "Inflige des dégâts à l'adversaire.", 2));
            cartes.add(new CarteAttaque("Explosion de Canon", "Inflige de lourds dégâts à l'adversaire.", 3));
        }

        Collections.shuffle(cartes, random);
    }

    public Cartes piocherCarte() {
        if (!cartes.isEmpty()) {
            return cartes.remove(0);
        }
        return null;  
    }

    public int nombreDeCartesRestantes() {
        return cartes.size();
    }

    public boolean isEmpty() {
        return cartes.isEmpty();  
    }

	public Cartes remove(int i) {
		// TODO Auto-generated method stub
		return null;
	}
    
}
