package DeroulementJeu;

import GestionFichier.Pieces;
import InterfaceGraphique.Fenetre;
import Launcher.Launcher;

public class DescendrePieces {
	
	// Classe qui g�re la descente des pieces
	
	private static boolean flag_onemorezero=false;
	public static boolean create_new_piece;
	
	
	// Valeur qui indique de combien de ligne max on peut augmenter sans quitter le plateau
	public static void launch() {
		while (Perdu.isItLoose()==false) {
		try {
			// Descend le plateau toute les seconde
			// 1000 == 1 seconde
			Thread.sleep(500);
			
			// On appelle la fonction qui supprime les lignes en cas de besoin
			SuppressionLigne.suppressionLignePlateau();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		// Permet de conna�tre l'indice de la piece la plus en bas.
	  	int compteur=0;
	  	int maxligne=0;
		for (int i=Pieces.position_piececourante[0]; i < Pieces.position_piececourante[0]+4; i++) {
			for (int j=Pieces.position_piececourante[1]; j < Pieces.position_piececourante[1]+4; j++) {
				if (compteur < 16) {
					if (Deroulement.piece_courante[Pieces.rotation_piececourante][compteur]>0 && compteur/4>maxligne) {
						// Le min corresponds � l'indice de la colonne le plus en bas de la piece courante
						maxligne=compteur/4;
					}
				}
				compteur++;
				
				}
		}

		
		// On regarde si  la piece sort du plateau quand elle avance
		// Si oui, alors on l'int�gre au board et on cr�e une nouvelle piece
		if (Pieces.position_piececourante[0]+maxligne+2 > Fenetre.NUM_LIGNE_TETRIS ) {
		  	compteur=0;		
			for (int i=Pieces.position_piececourante[0]; i < Pieces.position_piececourante[0]+4; i++) {
				for (int j=Pieces.position_piececourante[1]; j < Pieces.position_piececourante[1]+4; j++) {
					if (compteur < 16) {
					if (Deroulement.piece_courante[Pieces.rotation_piececourante][compteur]>0) {
						Deroulement.Board[i][j]=Deroulement.piece_courante[Pieces.rotation_piececourante][compteur];
					}
					}
					compteur++;
					}
			}
			// Flag pour indiquer qu'il faut cr�er une nouvelle piece
			// Cr�er une nouvelle piece correspond � "supprimer" la piece courante
			synchronized (Deroulement.lock) {
			create_new_piece=true;
			}
			// On incr�mente la position s'il n'y a pas de probl�me...
		} else {
			// Retour false, indique que la piece n'est pas bloqu�
			if (BlocagePieces.bloqueparboard()==false) {
				 Pieces.position_piececourante[0]+=1;
				
			} else {
				// alors la piece est bloqu�! Il faut donc cr�er une nouvelle piece!
				// Il faut �galement int�grer la pi�ce courante au board.
			  	compteur=0;		
				for (int i=Pieces.position_piececourante[0]; i < Pieces.position_piececourante[0]+4; i++) {
					for (int j=Pieces.position_piececourante[1]; j < Pieces.position_piececourante[1]+4; j++) {
						if (compteur < 16) {
						if (Deroulement.piece_courante[Pieces.rotation_piececourante][compteur]>0) {
							Deroulement.Board[i][j]=Deroulement.piece_courante[Pieces.rotation_piececourante][compteur];
						}
						}
						compteur++;
						}
				}
				// Flag pour indiquer qu'il faut cr�er une nouvelle piece
				synchronized (Deroulement.lock) {
				create_new_piece=true;
				}
			}
			
		}				

	}
	}
	
	
}
