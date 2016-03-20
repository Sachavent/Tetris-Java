package DeroulementJeu;

import GestionFichier.Pieces;
import InterfaceGraphique.Fenetre;

public class BlocagePieces {
	
	
	// Regarde si y a un contact entre la piece courante et le board si l'utillisateur d�place sa piece vers la droite
	public static boolean bloquedroite() {
		int compteur=0;
		for (int i=Pieces.position_piececourante[0]; i < Pieces.position_piececourante[0]+4; i++) {
			for (int j=Pieces.position_piececourante[1]+1; j < Pieces.position_piececourante[1]+5; j++) {
				if (Deroulement.piece_courante[Pieces.rotation_piececourante][compteur]>0 && Deroulement.Board[Pieces.position_piececourante[0]+(compteur/4)][Pieces.position_piececourante[1]+(compteur%4)+1] > 0) {
					return true; 
				}
				compteur++;
			}
		
		}	
		return false;
	}
	
	// Regarde si y a un contact entre la piece courante et le board si l'utillisateur d�place sa piece vers la gauche
	public static boolean bloquegauche() {
		int compteur=0;
		for (int i=Pieces.position_piececourante[0]; i < Pieces.position_piececourante[0]+4; i++) {
			for (int j=Pieces.position_piececourante[1]-1; j < Pieces.position_piececourante[1]+3; j++) {
				
				if (Deroulement.piece_courante[Pieces.rotation_piececourante][compteur]>0 && Deroulement.Board[Pieces.position_piececourante[0]+(compteur/4)][Pieces.position_piececourante[1]-1+(compteur%4)] > 0) {
					return true; 
				}
				compteur++;
			}
		
		}	
		return false;
	}
	
	
	// Retourne l'index de la colonne la plus � droite de la piece
	
	public static int indexmaxcol() {
	  	int compteur=0;
	  	int maxcol=0;
		for (int i=Pieces.position_piececourante[0]; i < Pieces.position_piececourante[0]+4; i++) {
			for (int j=Pieces.position_piececourante[1]; j < Pieces.position_piececourante[1]+4; j++) {
				if (compteur < 16) {
					if (Deroulement.piece_courante[Pieces.rotation_piececourante][compteur]>0 && compteur%4>maxcol) {
						// Le max corresponds � l'indice de la colonne le plus � droite de la piece courante
						maxcol=compteur%4;
					}
				}
				compteur++;
				
				}
		}
		return maxcol;
	}
	
	// Retourne l'index de la colonne le plus � gauche de la piece
	public static int indexmincol() {
	  	int compteur=0;
	  	/// ATTENTION NE PAS INITIALISER MINCOL A 0 !!
	  	int mincol=3;
		for (int i=Pieces.position_piececourante[0]; i < Pieces.position_piececourante[0]+4; i++) {
			for (int j=Pieces.position_piececourante[1]; j < Pieces.position_piececourante[1]+4; j++) {
				if (compteur < 16) {
					if (Deroulement.piece_courante[Pieces.rotation_piececourante][compteur]>0 && compteur%4<mincol) {
						// Le min corresponds � l'indice de la colonne le plus � gauche de la piece courante
						mincol=compteur%4;
						
					}
				}
				compteur++;
				
				}
		}
	
		return mincol;
	}
	
	public static boolean rotationblocked(int rotation) {
		if (rotation+1 > 3) {
			rotation=0;
		} else { rotation++;}
			
		int compteur=0; 
		// On ne bouge pas la piece courante, on regarde juste si on peut la faire tourner
		for (int i=Pieces.position_piececourante[0]; i < Pieces.position_piececourante[0]+4; i++) {
			for (int j=Pieces.position_piececourante[1]; j < Pieces.position_piececourante[1]+4; j++) {
				// S'assure que la piece ne sort pas du board quand on fait une rotation
				
				if (Deroulement.piece_courante[rotation][compteur]>0 
						&& Pieces.position_piececourante[1]+compteur%4+1 > Fenetre.NUM_COL_TETRIS) {
				
					return true;
				}
				
				if (Deroulement.piece_courante[rotation][compteur]>0 
						&& Pieces.position_piececourante[1]+compteur%4 < 0) {

							return true;
				}
				
				
				// Test contact en les pieces du board et la piece courante
				if (Deroulement.piece_courante[rotation][compteur]>0 && 
						Deroulement.Board[Pieces.position_piececourante[0]+(compteur/4)]
								[Pieces.position_piececourante[1]+(compteur%4)] > 0) {
					return true; 
				}
				
				compteur++;
			}
		
		}
		
		return false;
		
	}
	

}