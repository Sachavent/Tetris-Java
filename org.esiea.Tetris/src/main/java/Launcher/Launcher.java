package Launcher;


import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Scanner;

import DeroulementJeu.Deroulement;
import DeroulementJeu.Perdu;
import InterfaceGraphique.Fenetre;
import InterfaceReseau.Joueur1;
import InterfaceReseau.Joueur2;
import junit.framework.Assert;

public class Launcher {
	
	public static void main (String[] args) throws IOException, InterruptedException  {

			
////////////////////CEST ICI QUON LANCE LE TETRIS DU JOUEUR 1 ///////////
			
			System.out.println("Lancement du Tetris");
			
			// Lance le jeu
			Deroulement deroulement = new Deroulement();
			
			// Initialisation du plateau de jeu
			deroulement.initialise();
			InitialisationJoueur.initialisationJoueur(Fenetre.getCurrentPlayer());
			
			//Tant qu'on a pas perdu, le jeu continu
			while (Perdu.isItLoose()==false) {
			deroulement.run();
			}		
			// On arrete bien le programme � la fin
			System.exit(0);
		
	}
}
