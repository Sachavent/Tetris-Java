package InterfaceGraphique;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import DeroulementJeu.Deroulement;
import InteractionClavier.GestionClavier;


// Est appel� dans la classe D�roulement pour l'initialisation du jeu
public class Fenetre {
	
	// DEFINIT NOMBRE LIGNE ET COLONNE DU TETRIS
	public static int NUM_COL_TETRIS=10;
	public static int NUM_LIGNE_TETRIS=20;
	
	public void creationfenetre() {
		
		//Cr�ation fenetre
		JFrame fenetre = new JFrame();
		
		///////////////////////////////////////////// AJOUTE LINTERACTION CLAVIER //////////////////////
		// On ajoute un Keylistener 
		fenetre.addKeyListener(new GestionClavier());
		
		// On cr�e un nouveau Board
		// Affiche le tableau pour les test
	    fenetre.getContentPane().add(new RenderBoard());
	    
	    //Affiche la fenetre
	    fenetre.setSize(800,500);
		fenetre.setVisible(true);
	
		
	}
	
	
	
}
