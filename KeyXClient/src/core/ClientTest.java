/******************************************************
 Compagnie :	Transax Technologies
 Projet :		KeyExchangeClient
 Auteurs : 		Jean-Fran�ois Brais-Villemur, Analyste R�seau
 				Marc-Andr� Laporte, Programmeur Analyste
 Superviseur :	Alain Boucher, CTO
 Classe :		ClientTest.java			 
 Cr�ation  :	2010-03-08
 Dern. mod : 	2010-03-23
 *******************************************************
 Historique des modifications
 *******************************************************
 2010-03-08 :	D�but du projet
 
 2010-03-17 :	Ajout d'un TerminalID
 
 2010-03-23 : 	Envoi d'un message d'authentification
 				une fois la connexion �tablie.
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