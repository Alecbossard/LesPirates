package controller;

import model.*;
import view.IAffichage;


public class Controller {
    private final IAffichage vue;
    private final Jeu modele;

    public Controller(IAffichage vue, Jeu modele) {
        this.vue = vue;
        this.modele = modele;
    }

    public void demarrer() {
        vue.afficherAccueil();
        String[] nomsJoueurs = vue.obtenirNomsJoueurs();
        modele.initialiserJoueurs(nomsJoueurs[0], nomsJoueurs[1]);
        vue.afficherDebutJeu(nomsJoueurs);

        while (!modele.estTerminee()) {
            String[] zoneAttaqueDTO;
            if (modele.getZoneAttaque() == null) {
                zoneAttaqueDTO = new String[] { "" };
            } else {
                zoneAttaqueDTO = creerCarteDTO(modele.getZoneAttaque());
            }

            vue.afficherEtatJeu(creerEtatJoueurDTO(modele.getPirate1()), creerEtatJoueurDTO(modele.getPirate2()),
                    creerCartesDTO(modele.getPirate1().getZonePopularite()),
                    creerCartesDTO(modele.getPirate2().getZonePopularite()), zoneAttaqueDTO);

            Pirate joueurActuel = modele.getPirateActuel();
            vue.afficherTourActuel(joueurActuel.getNom());
            Cartes cartePiochee = modele.piocher();
            String[] cartePiocheeDTO = creerCarteDTO(cartePiochee);
            switch (cartePiochee.getType()) {
                case POPULARITE:
                    vue.afficherCartePiocheePopularite(cartePiocheeDTO);
                    break;
                case ATTAQUE:
                    vue.afficherCartePiocheeAttaque(cartePiocheeDTO);
                    break;
                case SPECIAL:
                    vue.afficherCartePiocheeSpecial(cartePiocheeDTO);
            }
            for (int i = 0; i < joueurActuel.getTailleMain(); i++) {  
                Cartes carteMain = joueurActuel.getMain()[i];  
                String[] carteMainDTO = creerCarteDTO(carteMain);
                switch (carteMain.getType()) {
                    case POPULARITE:
                        vue.afficherCarteMainPopularite(carteMainDTO, i + 1);
                        break;
                    case ATTAQUE:
                        vue.afficherCarteMainAttaque(carteMainDTO, i + 1);
                        break;
                    case SPECIAL:
                        vue.afficherCarteMainSpecial(carteMainDTO, i + 1);
                        break;
                    default:
                        break;
                }
            }
            

            int choixCarte = vue.obtenirChoixCarte();
            while (choixCarte < 0 || choixCarte > joueurActuel.getTailleMain()) {
                vue.afficherErreurChoix();
                choixCarte = vue.obtenirChoixCarte();
            }
            
            
            
            boolean doitRejouer = modele.jouerCarte(choixCarte - 1);
            if (!doitRejouer) {
                modele.changerDeJoueur();
            }
            
        }

        Pirate gagnant = modele.getGagnant();
        vue.afficherVainqueur(gagnant.getNom());
    }

    private String[][] creerCartesDTO(Cartes[] cartes) {  
        String[][] cartesDTO = new String[cartes.length][4];  
        for (int i = 0; i < cartes.length; i++) {
            cartesDTO[i] = creerCarteDTO(cartes[i]);
        }
        return cartesDTO;
    }

    private String[] creerCarteDTO(Cartes carte) {
        if (carte == null) {
            return new String[] { "Carte invalide", "Cette carte n'est pas valide", "", "" };
        }

        String[] carteDTO = new String[4];
        carteDTO[0] = carte.getNom();
        carteDTO[1] = carte.getDescription();

        if (carte.getType() == CarteType.POPULARITE) {
            CartePopularite cartePopularite = (CartePopularite) carte;
            carteDTO[2] = String.valueOf(cartePopularite.getPopularite());
        } else if (carte.getType() == CarteType.ATTAQUE) {
            CarteAttaque carteAttaque = (CarteAttaque) carte;
            carteDTO[2] = String.valueOf(carteAttaque.getDegats());
            carteDTO[3] = "";
        } else if (carte.getType() == CarteType.SPECIAL) {
            carteDTO[2] = carte.getDescription();
            carteDTO[3] = "Effet spécial activé";
        }

        return carteDTO;
    }

    private String[] creerEtatJoueurDTO(Pirate joueur) {
        String[] etatDTO = new String[3];
        etatDTO[0] = joueur.getNom();
        etatDTO[1] = String.valueOf(joueur.getPointsDeVie());
        etatDTO[2] = String.valueOf(joueur.getPopularite());
        return etatDTO;
    }
}