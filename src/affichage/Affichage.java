package affichage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Affichage {

    private Scanner scanner;
    private List<String[]> pioche;

    public Affichage() {
        scanner = new Scanner(System.in);
        initialiserPioche();
    }

    public void afficherBienvenue() {
        System.out.println("Bienvenue dans le jeu des pirates");
    }

    public String demanderNomJoueur(String numeroJoueur) {
        System.out.print("Entrez le nom du joueur " + numeroJoueur + " : ");
        return scanner.next();
    }

    public void distribuerCartes() {
        System.out.println("\nDistribution des cartes...");
    }

    public void initialiserPioche() {
        pioche = new ArrayList<>();
        pioche.add(new String[]{"Attaque", "Attaque du bateau ennemi, +2 pop, -2 pv", "2", "-2"});
        pioche.add(new String[]{"Mutinerie", "Une révolte éclate à bord ! -3 pop, -4 pv", "-3", "-4"});
        pioche.add(new String[]{"Défense", "Renforce le navire, +1 pop, +3 pv", "1", "3"});
        pioche.add(new String[]{"Fête", "Les marins célèbrent une victoire, +4 pop, +2 pv", "4", "2"});
        pioche.add(new String[]{"Pillage", "Vol d'un navire ennemi, +5 pop, -3 pv", "5", "-3"});
        pioche.add(new String[]{"Tempête", "Une énorme tempête frappe, -3 pop, -5 pv", "-3", "-5"});
        pioche.add(new String[]{"Trésor", "Vous trouvez un trésor caché, +6 pop, +2 pv", "6", "2"});
        pioche.add(new String[]{"Sabotage", "Un espion sabote votre navire, -4 pop, -3 pv", "-4", "-3"});
        pioche.add(new String[]{"Renforts", "Des alliés viennent vous aider, +3 pop, +4 pv", "3", "4"});
        pioche.add(new String[]{"Ravitaillement", "Vous recevez des provisions, +2 pop, +3 pv", "2", "3"});
        pioche.add(new String[]{"Ravitaillement", "Vous recevez des provisions 5, +2 pop, +3 pv", "2", "3"});
        pioche.add(new String[]{"Ravitaillement", "Vous recevez des provisions 9, +2 pop, +3 pv", "2", "3"});
        pioche.add(new String[]{"Ravitaillement", "Vous recevez des provisions 0, +2 pop, +3 pv", "2", "3"});
        pioche.add(new String[]{"Ravitaillement", "Vous recevez des provisions 4, +2 pop, +3 pv", "2", "3"});
        pioche.add(new String[]{"Ravitaillement", "Vous recevez des provisions 3, +2 pop, +3 pv", "2", "3"});
        pioche.add(new String[]{"Ravitaillement", "Vous recevez des provisions 8, +2 pop, +3 pv", "2", "3"});
        Collections.shuffle(pioche);
    }

    public String[][] creerMainJoueur() {
        String[][] main = new String[5][4];
        for (int i = 0; i < 5; i++) {
            main[i] = piocherCarte();
        }
        return main;
    }

    public void afficherMainJoueur(String joueur, String[][] main) {
        System.out.println("\nMain de " + joueur + " :");
        for (int i = 0; i < main.length; i++) {
            if (main[i] != null) {
                System.out.println("Carte " + (i + 1) + " : " + main[i][0]);
                System.out.println("   Description : " + main[i][1]);
                System.out.println("   Popularité : " + main[i][2]);
                System.out.println("   Points de vie : " + main[i][3]);
            }
        }
    }

    public int choisirCarte() {
        int choix = -1;
        while (choix < 1 || choix > 5) {
            System.out.print("Choisissez une carte (1-5) : ");
            if (scanner.hasNextInt()) {
                choix = scanner.nextInt();
                if (choix < 1 || choix > 5) {
                    System.out.println("Choix invalide, veuillez entrer un nombre entre 1 et 5.");
                }
            } else {
                System.out.println("Entrée invalide, veuillez entrer un nombre.");
                scanner.next();
            }
        }
        return choix - 1;
    }

    public void retirerCarte(String[][] main, int index) {
        if (index >= 0 && index < main.length) {
            main[index] = null;
        }
    }

    public String[] piocherCarte() {
        if (!pioche.isEmpty()) {
            return pioche.remove((int) (Math.random() * pioche.size()));
        } else {
            return new String[]{"Aucune carte", "La pioche est vide", "0", "0"};
        }
    }

    public void ajouterCarteDansMain(String[][] main) {
        for (int i = 0; i < main.length; i++) {
            if (main[i] == null) {
                System.out.println("Vous allez piocher une nouvelle carte !");
                main[i] = piocherCarte();
                break;
            }
        }
    }

    public static void main(String[] args) {
        Affichage view = new Affichage();

        view.afficherBienvenue();
        String joueur1 = view.demanderNomJoueur("1");
        String joueur2 = view.demanderNomJoueur("2");

        view.distribuerCartes();

        String[][] mainJoueur1 = view.creerMainJoueur();
        String[][] mainJoueur2 = view.creerMainJoueur();

        view.afficherMainJoueur(joueur1, mainJoueur1);
        view.afficherMainJoueur(joueur2, mainJoueur2);

        for (int tour = 0; tour < 5; tour++) {
            System.out.println("\n" + joueur1 + ", c'est à toi de jouer !");
            int choix1 = view.choisirCarte();
            System.out.println("Tu as choisi la carte : " + mainJoueur1[choix1][0]);
            view.retirerCarte(mainJoueur1, choix1);
            view.ajouterCarteDansMain(mainJoueur1);
            view.afficherMainJoueur(joueur1, mainJoueur1);

            System.out.println("\n" + joueur2 + ", c'est à toi de jouer !");
            int choix2 = view.choisirCarte();
            System.out.println("Tu as choisi la carte : " + mainJoueur2[choix2][0]);
            view.retirerCarte(mainJoueur2, choix2);
            view.ajouterCarteDansMain(mainJoueur2);
            view.afficherMainJoueur(joueur2, mainJoueur2);
        }
        System.out.println("Tu es juste le boss mec ???????????");
        System.out.println("Tu es juste le boss mec ???????????");
        System.out.println("Tu es juste le boss mec ???????????");

        
    }
}