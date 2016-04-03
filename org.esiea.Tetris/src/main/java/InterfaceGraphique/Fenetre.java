package InterfaceGraphique;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import DeroulementJeu.Deroulement;
import DeroulementJeu.Score;
import InteractionClavier.GestionClavier;


// Est appel� dans la classe D�roulement pour l'initialisation du jeu
public class Fenetre {
	
	// DEFINIT NOMBRE LIGNE ET COLONNE DU TETRIS
	public static int NUM_COL_TETRIS=10;
	public static int NUM_LIGNE_TETRIS=20;
	private static JFrame fenetretetris;
	private static JFrame fenetreaccueil;
	private static JFrame fenetrechoixjoueur;
	private static int[] tableauscore;
	private static boolean canstart=false; 
	private static int currentplayer;
	
	// Permet de choisir entre le mode multijoueur et le mode singlejoueur
	public void creationfenetreaccueuil() {
		 fenetreaccueil = new JFrame();
		 
		 // Cr�ation du pannel o� l'ont ajoutera les bouttons
		 JPanel pannel= new JPanel();
		 
		 JButton bouttonsolo= new JButton ("SoloPlayer");
		 // Ajoute l'action au boutton
		 bouttonsolo.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				
				// CHARGE LE TETRIS SOLO
				System.out.println("Joueur solitaire");
				setCurrentPlayer(0);
				fenetreaccueil.setVisible(false);
				creationfenetretetris();
			}
			 
		 });
		 pannel.add (bouttonsolo);
		 
		 JButton buttonmulti = new JButton ("Multiplayer");
		 buttonmulti.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				// Charge multijoueur tetris
				fenetreaccueil.setVisible(false);
				creationfenetreMulti ();
			}
			 
		 });
		
		 pannel.add(buttonmulti);
		 
		 fenetreaccueil.add(pannel);
		    //Affiche la fenetre
		 fenetreaccueil.setSize(800,500);
		 fenetreaccueil.setVisible(true);
		
	}
	
	public void creationfenetreMulti () {

		fenetrechoixjoueur = new JFrame();
		
		// Cr�ation du pannel o� l'ont ajoutera les bouttons
				 JPanel pannel= new JPanel();
				 
				 JButton bouttonJ1= new JButton ("Joueur 1");
				 // Ajoute l'action au boutton
				 bouttonJ1.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent arg0) {
						
						// CHARGE LE TETRIS SOLO
						System.out.println("joueur 1 choisis");
						setCurrentPlayer(1);
						fenetrechoixjoueur.setVisible(false);
						creationfenetretetris();
						
					}
					 
				 });
				 pannel.add (bouttonJ1);
				 
				 JButton bouttonJ2 = new JButton ("Joueur 2");
				 bouttonJ2.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent arg0) {
						// Charge multijoueur tetris
						System.out.println("joueur2 choisis");
						setCurrentPlayer(2);
						fenetrechoixjoueur.setVisible(false);
						creationfenetretetris();
					
					}
					 
				 });
				
				 pannel.add(bouttonJ2);
				 
				 fenetrechoixjoueur.add(pannel);
		
		
		
		  //Affiche la fenetre
		fenetrechoixjoueur.setSize(800,500);
		fenetrechoixjoueur.setVisible(true);
		
	}
	
	
	
	public void creationfenetretetris() {
	
		//Cr�ation fenetre
		fenetretetris = new JFrame();
		
		///////////////////////////////////////////// AJOUTE LINTERACTION CLAVIER //////////////////////
		// On ajoute un Keylistener 
		fenetretetris.addKeyListener(new GestionClavier());
		
		// On cr�e un nouveau Board
		// Affiche le tableau pour les test
		fenetretetris.getContentPane().add(new RenderBoard());
	    
	    //Affiche la fenetre
		fenetretetris.setSize(800,500);
		fenetretetris.setVisible(true);
		
		// Indique que le Tetris est pr�t � utilisation
		setStart(true);
		
		
	}
	
	public void afficheFinPartie() {
		tableauscore=Score.getTableauScore();
		
		JOptionPane.showMessageDialog(fenetretetris, "Game Over \nVotre score: "+ Score.getScore()+ "\nMeilleurs Scores:\n" +Arrays.toString(tableauscore));
	}
	
	
	////// Indique que le Tetris est pr�t � ex�cution
	public static void setStart(boolean etatstart) {
		canstart=etatstart;
	}
	
	public static boolean getStart() {
		return canstart;
	}
	
	// Indique quel est le joueur actuellement
	
	public static int getCurrentPlayer() {
		return currentplayer;
	}
	
	public static void setCurrentPlayer(int number) {
		currentplayer=number;
	}
	
	
}
