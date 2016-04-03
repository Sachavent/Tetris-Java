package InterfaceReseau;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import DeroulementJeu.Perdu;
import DeroulementJeu.Score;

public class Joueur1 extends Joueur {
	
	
	static ServerSocket socketserver ;
	
	
public static void launch() throws IOException, InterruptedException {
		
	
		final Socket socketduserveur ;
		final BufferedReader in;
		final PrintWriter out;

	
		
		// Creation du Serveur
		socketserver = new ServerSocket(2015);
		try {

			System.out.println("Port utilis� par le serveur: "+socketserver.getLocalPort());
			// Quand un client se connecte au serveur
			// En resume la connexion entre le serveur et le client est OKAY
			// Dit autrement : Le joueur 1 et 2 sont connect�
			socketduserveur = socketserver.accept(); 
			
				
		        System.out.println("Connexion entre J1 et J2 etablit");
		        
		        // Initiliase le print et le buffer
		        out = new PrintWriter(socketduserveur.getOutputStream());
		        in = new BufferedReader (new InputStreamReader (socketduserveur.getInputStream()));
		       		        
		        //On appelle les fonctions pour envoyer ou recevoir

		        /////////////////////////////////////////////////////////////// THREAD RECEVOIR MALUS //////////////////
		        Runnable serveurrecoitenboucle = new Runnable () {
		        	public void run () {
		        		// Tant que le jeu n'est pas termin�
		        		System.out.print("thread recuperation serveur: ");
		        			
		        		while (Perdu.isItLoose()==false) {

		        			String retour= new String();
		    		        try {
		    		        	
								retour=recievemessage(in);
								if (retour!=null ) {
									
								// ATTENTION ICI ON ATTENDS MALUS
								if (retour.equals("malus")) {
						        	//System.out.println("SERVEUR: etat socket: " + socketserver.isClosed() +" MALUS ENVOYE PAR J2!");
						        	
						        
								}
								}
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
		        		;
		        		}
		        	}
		        };
		        

		       
/////////////////////////////////////////////////////////////// THREAD ENVOYER MALUS A JOUEUR 2 //////////////////
		        
		        Runnable serveurenvoiemalus = new Runnable () {
		        	//  AJOUTER LA GESTION DES MALUS!!!!!!!!!!
		        	public void run() {
		        		boolean envoie=false;
		        		while (Perdu.isItLoose()==false) {
		        		
		        		if (Score.getScore()==1 && envoie==false) {
		        		System.out.println("joueur 1 envoie un malus");
		        		 sendmessage("malus",socketduserveur, out);
		        		envoie=true;
		        		}
		        		}
		        		 
		        	     
		        	}
		        };
		        
		      //Lancement des Thread (Emition et Reception)
		       Thread serveur_recevoir = new Thread (serveurrecoitenboucle);
		        serveur_recevoir.start();
		        
		        Thread serveur_envoie= new Thread (serveurenvoiemalus);
		        serveur_envoie.start();
		        
		        // A SUPPRIMER QUAND ON A LA CONDITION DARRET
		        // PERMET DE SIMULER UN ARRET POUR LES TESTS (SERT POUR LA RECEPTION)
		     // RAJOUTER UNE CONDITION DARRET
		        while (Perdu.isItLoose()==false) {
		        	 //Thread.sleep(1000);
		        }
		       
		        
		        
		}catch (IOException e) {
			
			System.out.println("erreur!!! Sans doute le port ....");
		} finally {
			
			socketserver.close();
			
			System.out.println("Fermeture de la connexion");
		}
		
	}

	public boolean getetatserveur () {
		if (socketserver!= null) {
		if (socketserver.isClosed() == false) {
			System.out.println("le serveur n'est pas connect�");
			return false;
		} else { System.out.println("le serveur est connect�");
			return true;}
		}
		return false;
	}
}

