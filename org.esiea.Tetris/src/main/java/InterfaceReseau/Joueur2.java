package InterfaceReseau;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

import DeroulementJeu.Perdu;
import DeroulementJeu.Score;

public class Joueur2 extends Joueur {
	
	static Socket socket=null;
	static BufferedReader in;
	static PrintWriter out;
public static void launch() throws InterruptedException, UnknownHostException, IOException {
		

		
		try {
			// Creation de la socket
			// Mettre l'adresse de l'autre machine
			// ATTENTION IL FAUT REMPLACER LADRESSE IP
			 
			socket = new Socket("192.168.1.10",2015);	
			// Demande � se connecter au serveur
		        System.out.println("Demande de connexion");

		        // Creation du buffer et du "print"
		        in = new BufferedReader (new InputStreamReader (socket.getInputStream()));
		        out = new PrintWriter(socket.getOutputStream());
		        
		        ///// Initialisation termin�e////////////
		        
		        
		        ///// Thread recup�ration des malus envoy�s par le J1 ////////////
		        Runnable clientrecoitenboucle= new Runnable () {
		        	
		        	public void run() {
		        		System.out.print("thread recuperation client: ");
		        	     String retour= new String();
		     
		        	  // ATTENTION LA CONDITION DARRET EST A CHANGE
		        	  ///////////////////////////////////
		        	     while (Perdu.isItLoose()==false) {

					        try {
								retour=recievemessage(in);
								if (retour!=null ) {
									// ATTENTION RECUPERE LE MOT MALUS
									if (retour.equals("malus")) {
							        	//System.out.println("CLIENT: etat socket: " + socket.isClosed() +" MALUS ENVOYE PAR J1!");
							        	
	
									}
								}
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
		        	     }
		        	     if (Perdu.isItLoose()==true) {
		        	    	 try {
								socket.close();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
		        	     }
		        	}
				   
		        };
		        
		        Runnable clientenvoiemalus= new Runnable () {
		        	public void run() {
		        		 while (Perdu.isItLoose()==false) {
				        		if (Score.getMalus()==true) {
					        		System.out.println("joueur 1 envoie un malus");
					        		 sendmessage("malus",socket, out);
					        		 Score.setMalus(false);
					        		}
					        		}
					        	     if (Perdu.isItLoose()==true) {
					        	    	 try {
					        	    		 socket.close();
										} catch (IOException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
					        	     }
		        	}
		        };
		        
		        
		        
		        
		        // Appel des 2 Thread (emition et reception)
			       Thread client_recoit= new Thread (clientrecoitenboucle);
			       client_recoit.start();
		        
			       Thread envoiemalus = new Thread (clientenvoiemalus);
			       envoiemalus.start();
			       
			    // A SUPPRIMER QUAND ON A LA CONDITION DARRET
		        // PERMET DE SIMULER UN ARRET POUR LES TESTS 
			       /////
			    // RAJOUTER UNE CONDITION DARRET
			       while (Perdu.isItLoose()==false) {
			    	  //Thread.sleep(1000);
			       }
	        	     if (Perdu.isItLoose()==true) {
	        	    	 try {
							socket.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	        	     }
		   
		        
		       
		}catch (ConnectException e) {
			
			System.out.println("Il faut un joueur 1 avant!" );
		}catch (IOException e) {
			
			e.printStackTrace();
		} finally {
			
			// Ferme la connexion
			if (socket!= null) {
	        socket.close();
			}


		}
	}
}
