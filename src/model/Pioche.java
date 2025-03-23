package model;

import java.util.Random;

public class Pioche {
    private Cartes[] cartes = new Cartes[40];
    private int indexCarte = 0;
    private Random random = new Random();

    public Random getRandom() {
        return random;
    }

    public Pioche() {
        initialiserPioche();
    }

    private void initialiserPioche() {
        cartes = new Cartes[40];
        int idx = 0;

        cartes[idx++] = new CartePopularite("Discours Inspirant", "Gagne en popularite.", 1);
        cartes[idx++] = new CartePopularite("Eclipse", 
                "Vous utilisez le bateau Eclipse et naviguez sur des eaux calmes, gagnez 3 de popularite.", 3);
        for (int i = 0; i < 10; i++) {
            cartes[idx++] = new CartePopularite("Repere Outils", 
                    "Vous reperez votre adversaire sans vous faire reperer, et gagnez 1 de popularite.", 1);
        }

        cartes[idx++] = new CarteAttaquePopu("Coup de Yaskawa", 
                "Inflige des degats a l'adversaire egaux a la popularite du joueur.");
        cartes[idx++] = new CarteAttaquePopu("Coup de Yaskawa", 
                "Inflige des degats a l'adversaire egaux a la popularite du joueur.");
        cartes[idx++] = new CarteAttaquePopu("Coup de Yaskawa", 
                "Inflige des degats a l'adversaire egaux a la popularite du joueur.");
        cartes[idx++] = new CarteAttaquePopu("Coup de Yaskawa", 
                "Inflige des degats a l'adversaire egaux a la popularite du joueur.");
        cartes[idx++] = new CarteAttaquePopu("Coup de Yaskawa", 
                "Inflige des degats a l'adversaire egaux a la popularite du joueur.");
        for (int i = 0; i < 7; i++) {
            cartes[idx++] = new CarteAttaque("Coup de Kuka", 
                    "Inflige 1 degat a l'adversaire avec son bras robotique obsolete.", 1);
            cartes[idx++] = new CarteAttaque("Coup de Staubli", 
                    "Inflige 2 degats a l'adversaire grace a son bras robotique de nouvelle technologie.", 2);
        }

        for (int i = 0; i < 3; i++) {
            cartes[idx++] = new CarteRejouer("Rejouer", 
                    "Cycle ton deck ( comme le 2.6 ) ");
            cartes[idx++] = new CarteSoins("Soins", 
                    "Soigne le joueur, regenere des points de vie.");
        }
        cartes[idx++] = new CarteEchangeMain("Echange de main", "Echange les mains des deux pirates.");
        cartes[idx++] = new CarteNouvelMain("Random.Shuffle", "Pioche 5 nouvelles cartes.");
        cartes[idx++] = new CarteNouvelMain("Random.Shuffle", "Pioche 5 nouvelles cartes.");

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
