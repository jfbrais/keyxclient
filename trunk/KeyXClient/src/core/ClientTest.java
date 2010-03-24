/******************************************************
 Compagnie :	Transax Technologies
 Projet :		KeyExchangeClient
 Auteurs : 		Jean-François Brais-Villemur, Analyste Réseau
 				Marc-André Laporte, Programmeur Analyste
 Superviseur :	Alain Boucher, CTO
 Classe :		ClientTest.java			 
 Création  :	2010-03-08
 Dern. mod : 	2010-03-23
 *******************************************************
 Historique des modifications
 *******************************************************
 2010-03-08 :	Début du projet
 
 2010-03-17 :	Ajout d'un TerminalID
 
 2010-03-23 : 	Envoi d'un message d'authentification
 				une fois la connexion établie.
 *******************************************************/

package core;

public class ClientTest {
	
	public static void main(String[] args) {
		Client client = new Client("40Q10600");
		MessageParser msg = new MessageParser();
		
		client.connect(client.getIP(), client.getPort());
		
		msg.sendMessage(client.getTerminalID(), client.getOutputStream());
//		msg.sendMessage("KEYX", client.getOutputStream());
//		msg.sendMessage("QUIT", client.getOutputStream());
	}
}