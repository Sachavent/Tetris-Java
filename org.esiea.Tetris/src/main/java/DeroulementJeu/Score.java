package DeroulementJeu;

import java.io.IOException;

import GestionFichier.ScoreFile;

// Score h�rite de ScoreFile afin de pouvoir lire / �crire dans le fichier "Scores.txt"
public class Score extends ScoreFile{
	private static int score;
	private static int[] tableauscore;
	private static boolean malus;
	public static final Object lock = new Object();
	public static boolean test;
	
	public static void augmenteScore() {
		score++;
		
		// Permet d'indiquer qu'il y a un malus
		// On envoie un malus si le score attends 10
		if (score%10==0 && score != 0) {
		synchronized (lock) {
			setMalus(true);
		}
	}
	}
	// Fonction qui retourne le score actuel
	public static int getScore() {
		return score;
	}
	
	public static void setScore(int newscore) {
		score=newscore;
	}
	
	public static void setScoreFinPartie() throws IOException {
		tableauscore=lectureFichierScore();
		for (int i=0; i < tableauscore.length; i++) {
			if (score > tableauscore[i]) {
				System.out.println(tableauscore[i]);
				tableauscore[i]=score;
				ecritureFichierScore(score, i+1);
			}
		}
	}
	public static int[] getTableauScore() {
		
		return tableauscore;
	}
	
	public static void setMalus(boolean etatmalus) {
		malus=etatmalus;
	}
	
	// Indique si l'autre joueur doit avoir un malus ou pas (sert dans l'interface r�seau)
	public static boolean getMalus() {
		return malus;
	}
}
