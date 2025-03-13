package model;

import java.util.Random;

public class Pioche {
    private Cartes[] cartes = new Cartes[33];
    private int indexCarte = 0;
    private Random random = new Random();

    public Random getRandom() {
        return random;
    }

    public Pioche() {
        initialiserPioche();
    }

    private void initialiserPioche() {
        cartes = new Cartes[33];
        int idx = 0;
        
        cartes[idx++] = (new CartePopularite("Discours Inspirant", "Gagne en popularité.", 1));
        cartes[idx++] = new CartePopularite("Eclipse", 
                "Vous utilisez le bateau Eclipse et naviguez sur des eaux calmes, gagnez 3 de popularité.", 3);
        for (int i = 0; i < 10; i++) {
            cartes[idx++] = new CartePopularite("Repère Outils", 
                    "Vous repérez votre adversaire sans vous faire repérer, et gagnez 1 de popularité.", 1);
        }
        
        cartes[idx++] = new CarteAttaque("Coup de Yaskawa", 
                "Inflige 3 dégâts à l'adversaire à l'aide de son bras robotique industriel à haute précision.", 2);
        for (int i = 0; i < 7; i++) {
            cartes[idx++] = new CarteAttaque("Coup de Kuka", 
                    "Inflige 1 dégât à l'adversaire avec son bras robotique obsolète.", 1);
            cartes[idx++] = new CarteAttaque("Coup de Staubli", 
                    "Inflige 2 dégâts à l'adversaire grâce à son bras robotique de nouvelle technologie.", 2);
        }

        for (int i = 0; i < 3; i++) {
        	cartes[idx++] = new CarteSpeciale("Rejouer", 
        	        "Permet de rejouer immédiatement après avoir joué cette carte.", "rejouer");
        	cartes[idx++] = new CarteSpeciale("Soins", 
        	        "Soigne le joueur, régénère des points de vie.", "soins");

        }
        
        for (int i = cartes.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            Cartes temp = cartes[i];
            cartes[i] = cartes[j];
            cartes[j] = temp;
        }
    }

    public Cartes piocherCarte() {
        if (indexCarte < cartes.length) {
            return cartes[indexCarte++];
        }
        return null;
    }
}
