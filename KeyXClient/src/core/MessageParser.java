/******************************************************
 Compagnie :	Transax Technologies
 Projet :		KeyExchangeClient
 Auteurs : 		Jean-François Brais-Villemur, Analyste Réseau
 				Marc-André Laporte, Programmeur Analyste
 Superviseur :	Alain Boucher, CTO
 Classe :		MessageParser.java			 
 Création  :	2010-03-08
 Dern. mod : 	2010-03-08
 *******************************************************
 Historique des modifications
 *******************************************************
 2010-03-08 : 	Début du projet
 
 2010-03-08 : 	Classe pour envoyer/recevoir des données.
 *******************************************************/

package core;

import java.io.PrintWriter;

public class MessageParser {
	private String lastMessage = null;
	
	public MessageParser() {
		System.out.println("MessageParser created..");
	}

	public void sendMessage(String message, PrintWriter out) {
		out.println(message);
		out.close();
	}
	
	public String parseMessage() {
		return lastMessage;
	}
}