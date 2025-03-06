package main;
import view.IAffichage;
import view.Affichage;
import controller.Controller;
import model.Jeu;

public class Main {
	public static void main(String[] args) {
		IAffichage view = new Affichage();
		Jeu model = new Jeu();
		Controller controller = new Controller(view, model);
		controller.demarrer();
	}
}