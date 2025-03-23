package view;

import java.util.Scanner;



public class Affichage implements IAffichage {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void afficherAccueil() {
        System.out.println("Bienvenue dans le jeu des Pirates !");
        System.out.println("Deux pirates s'affrontent dans une lutte sans merci.");
        System.out.println("L'objectif ? Atteindre une popularite de 5 ou reduire la vie de l'adversaire a 0 !");
        System.out.println("Chaque pirate commence avec 5 points de vie. Le premier a atteindre l'un de ces objectifs gagne !");
        System.out.println("Que le meilleur pirate l'emporte !");
        System.out.println();
    }

    @Override
    public String[] obtenirNomsJoueurs() {
        String[] noms = new String[2];
        for (int i=0; i<2; i++) {
            System.out.println("Entrer le nom du Joueur " + (i +1) + " : ");
            noms[i]= scanner.nextLine().trim();
        } 
        return noms;
    }

    @Override
    public void afficherDebutJeu(String[] nomsJoueurs) {
        System.out.println("Le jeu commence !");
        System.out.println();
        System.out.println("Joueur 1 : " + nomsJoueurs[0]);
        System.out.println("Joueur 2 : " + nomsJoueurs[1]);
        System.out.println();
    }

    @Override
    public void afficherEtatJeu(String[] etatJoueur1, String[] etatJoueur2, String[][] zonePopulariteJoueur1,
            String[][] zonePopulariteJoueur2, String[] zoneAttaque) {
       
        System.out.println("Etat actuel du jeu :");
        System.out.println();
        System.out.println("Joueur 1 : " + etatJoueur1[0] + " | PV : " + etatJoueur1[1] + " | Popularite : " + etatJoueur1[2]);
        System.out.println("Joueur 2 : " + etatJoueur2[0] + " | PV : " + etatJoueur2[1] + " | Popularite : " + etatJoueur2[2]);
        System.out.println();
    }

    @Override
    public void afficherTourActuel(String nomJoueur) {
        System.out.println("C'est le tour de " + nomJoueur);
        System.out.println();
    }

    @Override
    public void afficherCartePiocheePopularite(String[] carte) {
        System.out.println("Carte de popularite piochee : " + carte[0]);
        System.out.println();
    }

    @Override
    public void afficherCartePiocheeAttaque(String[] carte) {
        System.out.println("Carte d'attaque piochee : " + carte[0]);
        System.out.println();
    }

    @Override
    public void afficherCarteMainPopularite(String[] carte, int index) {
        System.out.println("Carte de popularite dans la main (index " + index + ") : " + carte[0]);
    }

    @Override
    public void afficherCarteMainAttaque(String[] carte, int index) {
        System.out.println("Carte d'attaque dans la main (index " + index + ") : " + carte[0]);
    }

    @Override
    public int obtenirChoixCarte() {
        System.out.printf("%nChoisissez une carte (1-5) : ");
        System.out.println();
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    @Override
    public void afficherErreurChoix() {
        System.out.println("Choix invalide. Veuillez essayer a nouveau.");
    }

    @Override
    public void afficherVainqueur(String nom) {
        System.out.println("Le gagnant est : " + nom);
    }
    
    @Override
    public void afficherCartePiocheeSpecial(String[] carteDTO) {
        System.out.println("Carte Speciale Piochee : " + carteDTO[0]);
        System.out.println("Description : " + carteDTO[1]);
        System.out.println();
    }

    @Override
    public void afficherCarteMainSpecial(String[] carteDTO, int index) {
        System.out.println("Carte Speciale dans la main (Index " + index + ") : " + carteDTO[0]);
        System.out.println("Description : " + carteDTO[1]);
    }
}
