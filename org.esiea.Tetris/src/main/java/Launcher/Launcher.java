package Launcher;


import java.util.Scanner;

import DeroulementJeu.Deroulement;
import InterfaceGraphique.Fenetre;
import junit.framework.Assert;

public class Launcher {
	private static boolean flag=true;
	
	public static void main (String[] args) {
		System.out.println("Lancement du Tetris");
		
		// Lance le jeu
		Deroulement deroulement = new Deroulement();
		
		// Initialisation du plateau de jeu
		deroulement.initialise();
		
		//Lance le jeu
		while (flag==true) {
		deroulement.run();
		}
		
	}
}
