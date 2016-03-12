package GestionFichier;

import DeroulementJeu.Deroulement;

// Cest la classe qui s'occupe des pieces
// Elle est appel� dans la classe D�roulement

public class Pieces {
	// Constante correspondant au nombre de piece, utile pour g�n�rer un random
	public final static int NOMBRE_PIECE=2;
	public static int[] position_piececourante= {0,3};
	public static int rotation_piececourante=0;
	// Cr�ation des pieces, cod� sur des cases 4x4
	// Chaque piece poss�de d�j� les "valeurs" de sa rotation donc pas besoin de g�rer les rotations de fa�on manuelle
	int[][] Piece1 = { {0,1,0,0,0,1,1,0,0,1,0,0,0,0,0,0},{0,0,0,0,0,0,1,0,0,1,1,1,0,0,0,0},{0,0,0,1,0,0,1,1,0,0,0,1,0,0,0,0},{0,1,1,1,0,0,1,0,0,0,0,0,0,0,0,0} };
	int[][] Piece2 = { {0,2,0,0,0,2,0,0,0,2,0,0,0,2,0,0},{2,2,2,2,0,0,0,0,0,0,0,0,0,0,0,0},{0,2,0,0,0,2,0,0,0,2,0,0,0,2,0,0},{2,2,2,2,0,0,0,0,0,0,0,0,0,0,0,0} };
	
	// Fonction appel� dans la classe Deroulement afin de cr�er une nouvelle piece
	public int[][] create_piece(int numberpiece) {

		switch (numberpiece) {
		case 1:
			return Piece1;
		case 2:
			return Piece2;
		default: return null;
		}
	}
	
	/*
	// Fonction qui change les valeurs du board afin de cr�er la piece 2
	public void setPiece2() {
		
		int compteur=0;
		
		for (int i=0; i < 4; i++) {
			for (int j=3; j < 7; j++) {
				Deroulement.Board[i][j]=Piece2[0][compteur];
				compteur++;
				}
		
		}
	}
	
	
	// Fonction qui change les valeurs du board afin de cr�er la piece 1
	public void setPiece1() {
		
		int compteur=0;
		
		for (int i=0; i < 4; i++) {
			for (int j=3; j < 7; j++) {
				Deroulement.Board[i][j]=Piece1[0][compteur];
				compteur++;
				}
		
	}
		
	}*/
	
	
	// Get avec le num�ro de la piece qu'on souhaite afficher
	public int[][] get_piece (int numberpiece){
		switch (numberpiece) {
		case 1:
			return Piece1;
		case 2:
			return Piece2;
		default: return null;
		}
		
	}

	
}
