package view;

import java.util.Scanner;

import model.Cartes;
import model.Pirate;

public class Affichage implements IAffichage {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void afficherAccueil() {
        System.out.println("Bienvenue dans le jeu des Pirates !");
        System.out.println("Deux pirates s'affrontent pour atteindre une popularité de 5 !");
    }

    @Override
    public String[] obtenirNomsJoueurs() {
        String[] noms = new String[2];
        noms[0] = "Pirate1";  
        noms[1] = "Pirate2"; 
        return noms;
    }

    @Override
    public void afficherDebutJeu(String[] nomsJoueurs) {
        System.out.println("Le jeu commence !");
        System.out.println("Joueur 1 : " + nomsJoueurs[0]);
        System.out.println("Joueur 2 : " + nomsJoueurs[1]);
    }

    @Override
    public void afficherEtatJeu(String[] etatJoueur1, String[] etatJoueur2, String[][] zonePopulariteJoueur1,
            String[][] zonePopulariteJoueur2, String[] zoneAttaque) {
       
        System.out.println("État actuel du jeu :");
        System.out.println("Joueur 1 : " + etatJoueur1[0] + " PV, Popularité : " + etatJoueur1[1]);
        System.out.println("Joueur 2 : " + etatJoueur2[0] + " PV, Popularité : " + etatJoueur2[1]);

       
        System.out.println("Cartes de popularité de Joueur 1 : ");
        for (String[] carte : zonePopulariteJoueur1) {
            System.out.println(carte[0]);
        }

        System.out.println("Cartes de popularité de Joueur 2 : ");
        for (String[] carte : zonePopulariteJoueur2) {
            System.out.println(carte[0]);
        }

        System.out.println("Cartes d'attaque : ");
        for (String carte : zoneAttaque) {
            System.out.println(carte);
        }
    }

    @Override
    public void afficherTourActuel(String nomJoueur) {
        System.out.println("C'est le tour de " + nomJoueur);
    }

    @Override
    public void afficherCartePiocheePopularite(String[] carte) {
        System.out.println("Carte de popularité piochée : " + carte[0]);
    }

    @Override
    public void afficherCartePiocheeAttaque(String[] carte) {
        System.out.println("Carte d'attaque piochée : " + carte[0]);
    }

    @Override
    public void afficherCarteMainPopularite(String[] carte, int index) {
        System.out.println("Carte de popularité dans la main (index " + index + ") : " + carte[0]);
    }

    @Override
    public void afficherCarteMainAttaque(String[] carte, int index) {
        System.out.println("Carte d'attaque dans la main (index " + index + ") : " + carte[0]);
    }

    @Override
    public int obtenirChoixCarte() {
        System.out.printf("%nChoisissez une carte (1-5) : ");
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    @Override
    public void afficherErreurChoix() {
        System.out.println("Choix invalide. Veuillez essayer à nouveau.");
    }

    @Override
    public void afficherVainqueur(String nom) {
        System.out.println("Le gagnant est : " + nom);
    }
    @Override
    public void afficherCartePiocheeSpecial(String[] carteDTO) {
        System.out.println("Carte Spéciale Piochée : " + carteDTO[0]);
        System.out.println("Description : " + carteDTO[1]);
        System.out.println("Effet : Cette carte permet d'échanger les mains des joueurs !");
    }
    
    @Override
    public void afficherCarteMainSpecial(String[] carteDTO, int index) {
        System.out.println("Carte Spéciale dans la main (Index " + index + ") : " + carteDTO[0]);
        System.out.println("Description : " + carteDTO[1]);
        System.out.println("Effet : Cette carte permet d'échanger les mains des joueurs !");
    }
}
