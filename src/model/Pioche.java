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

        cartes[idx++] = new CartePopularite("Discours Inspirant", "Gagne en popularit�.", 1);
        cartes[idx++] = new CartePopularite("Eclipse", 
                "Vous utilisez le bateau Eclipse et naviguez sur des eaux calmes, gagnez 3 de popularit�.", 3);
        for (int i = 0; i < 10; i++) {
            cartes[idx++] = new CartePopularite("Rep�re Outils", 
                    "Vous rep�rez votre adversaire sans vous faire rep�rer, et gagnez 1 de popularit�.", 1);
        }

        cartes[idx++] = new CarteAttaquePopu("Coup de Yaskawa", 
                "Inflige des d�g�ts � l'adversaire �gaux � la popularit� du joueur.");
        cartes[idx++] = new CarteAttaquePopu("Coup de Yaskawa", 
                "Inflige des d�g�ts � l'adversaire �gaux � la popularit� du joueur.");
        cartes[idx++] = new CarteAttaquePopu("Coup de Yaskawa", 
                "Inflige des d�g�ts � l'adversaire �gaux � la popularit� du joueur.");
        cartes[idx++] = new CarteAttaquePopu("Coup de Yaskawa", 
                "Inflige des d�g�ts � l'adversaire �gaux � la popularit� du joueur.");
        cartes[idx++] = new CarteAttaquePopu("Coup de Yaskawa", 
                "Inflige des d�g�ts � l'adversaire �gaux � la popularit� du joueur.");
        for (int i = 0; i < 7; i++) {
            cartes[idx++] = new CarteAttaque("Coup de Kuka", 
                    "Inflige 1 d�g�t � l'adversaire avec son bras robotique obsol�te.", 1);
            cartes[idx++] = new CarteAttaque("Coup de Staubli", 
                    "Inflige 2 d�g�ts � l'adversaire gr�ce � son bras robotique de nouvelle technologie.", 2);
        }

        for (int i = 0; i < 3; i++) {
            cartes[idx++] = new CarteRejouer("Rejouer", 
                    "Cycle ton deck ( comme le 2.6 ) ", "rejouer");
            cartes[idx++] = new CarteSoins("Soins", 
                    "Soigne le joueur, r�g�n�re des points de vie.", "soins");
        }
        cartes[idx++] = new CarteEchangeMain("�change de main", "�change les mains des deux pirates.");
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
