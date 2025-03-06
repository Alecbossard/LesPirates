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
        cartes.add(new CartePopularite("Discours Inspirant", "Gagne en popularité, ne coûte pas de hp.", 1, 0));
        cartes.add(new CartePopularite("Révolte Organisée", "Gagne en popularité, ne coûte pas de hp.", 1, 0));
        cartes.add(new CartePopularite("Abordage Réussi", "Gagne beaucoup de popularité.", 2, 0));
        cartes.add(new CartePopularite("Poing de Fer", "Gagne en popularité mais coûte un peu de hp.", 2, 1));
        cartes.add(new CartePopularite("Repère outil", "Le pirate repère son adversaire sans se faire repérer.", 2, 0));
        cartes.add(new CartePopularite("Repère outil", "Le pirate repère son adversaire sans se faire repérer.", 2, 0));
        for (int i = 0; i < 3; i++) {
            cartes.add(new CartePopularite("Discours Inspirant", "Gagne en popularité, ne coûte pas de hp.", 1, 0));
            cartes.add(new CartePopularite("Révolte Organisée", "Gagne en popularité, ne coûte pas de hp.", 1, 0));
            cartes.add(new CartePopularite("Abordage Réussi", "Gagne beaucoup de popularité.", 2, 0));
            cartes.add(new CartePopularite("Poing de Fer", "Gagne en popularité mais coûte un peu de hp.", 2, 1));
        }

        cartes.add(new CarteAttaque("Frappe de Sabre", "Inflige des dégâts à l'adversaire.", 2));
        cartes.add(new CarteAttaque("Explosion de Canon", "Inflige de lourds dégâts à l'adversaire.", 3));
        for (int i = 0; i < 2; i++) {
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
}
