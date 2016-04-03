package GestionFichier;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.NoSuchElementException;
import java.util.Scanner;


// Classe qui permet l'�criture et la lecture de fichier
public class ScoreFile {
	
	static final String chemin ="src/main/Scores.txt";
	
    static File file = new File(chemin);
    
    static FileWriter fw;
    static FileReader fr;
    // Indique le nombre de score pr�sent dans le fichier
    public final static int NOMBRE_SCORE_STOCKE = 5;
    static int[] valeursrecuperees;
	
	public static int[] lectureFichierScore() throws IOException {
        //Lecture des scores
        fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr); 
        // On cr�e un scanner qui va r�cup�rer les int
        Scanner scanner = new Scanner(file);
        int scorerecupere;
        String entre;
        int nombreligne=0;
        int[] valeursrecuperees= new int [NOMBRE_SCORE_STOCKE ];
        //Lecture des donn�es
        // On lit les lignes une part une tant qu'il y en a encore
        while((entre = br.readLine()) != null) {
        	// NextInt permet de recup�rer le prochain integer
	        scorerecupere=scanner.nextInt();
	        // On stocke la valeur recup�r�e dans un tableau
	        valeursrecuperees[nombreligne]=scorerecupere;
	        nombreligne++;
        	
        
        }
        br.close();
        fr.close();
        
        
        // Retourne un talbeau contenaent l'ensemble des scores r�cup�r�s
        return valeursrecuperees;
	}
	
	public static void ecritureFichierScore(int score, int positionscore) throws IOException {
		   // Ecriture dans le fichier
	 	   fw = new FileWriter(file);
	 	   String str="";
	 	   
	 	   	
	        for (int compteur = 0; compteur < positionscore ; compteur++) {
		 	      //On �crit la cha�ne
		 	      fw.write(new Integer(score).toString());
		 	     fw.write("\n");
	        }

	 	      //On ferme le flux
	 	      fw.close();
		
	}
}
