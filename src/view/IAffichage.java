package view;

public interface IAffichage {
    void afficherAccueil();

    String[] obtenirNomsJoueurs();

    void afficherDebutJeu(String[] nomsJoueurs);

    void afficherEtatJeu(String[] etatJoueur1, String[] etatJoueur2, String[][] zonePopulariteJoueur1,
            String[][] zonePopulariteJoueur2, String[] zoneAttaque);

    void afficherTourActuel(String nomJoueur);

    void afficherCartePiocheePopularite(String[] carte);

    void afficherCartePiocheeAttaque(String[] carte);

    void afficherCarteMainPopularite(String[] carte, int index);

    void afficherCarteMainAttaque(String[] carte, int index);

    int obtenirChoixCarte();

    void afficherErreurChoix();

    void afficherVainqueur(String nom);
    
    void afficherCartePiocheeSpecial(String[] carteDTO);
    
    void afficherCarteMainSpecial(String[] carteDTO, int index);
}
