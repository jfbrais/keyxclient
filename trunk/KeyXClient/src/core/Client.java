/******************************************************
 Compagnie :	Transax Technologies
 Projet :		KeyExchangeClient
 Programmeur :	Jean-François Brais-Villemur, Analyste Réseau
 Superviseur :	Alain Boucher, CTO
 Classe :		Client.java			 
 Création  :	2010-03-08
 Dern. mod : 	2010-03-17
 *******************************************************
 Historique des modifications
 *******************************************************
 2010-03-08 :	Début du projet
 
 2010-03-17 :	Ajout d'un TerminalID
 *******************************************************/

package core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

public class Client {

	private Socket socketClient;
	
	private final String DEFAULT_IP = "127.0.0.1";
	private final int DEFAULT_PORT = 10000;
	
	private String IP;
	private int port;
	
	private PrintWriter out;
	private BufferedReader in;
	
	private String terminalID;
	
	public Client(String aID)
	{
		terminalID = aID;
		
		IP = DEFAULT_IP;
		port = DEFAULT_PORT;
		
		System.out.println("Client initialized..");
	}
	
	public Client(String aID, String aIP, int aPort)
	{
		terminalID = aID;
		IP = aIP;
		port = aPort;
		
		System.out.println("Client initialized..");
	}
	
	public String getTerminalID() {
		return terminalID;
	}
	
	public String getIP() {
		return IP;
	}
	
	public int getPort() {
		return port;
	}
	
	public PrintWriter getOutputStream() {
		return out;
	}
	
	public BufferedReader getInputStream() {
		return in;
	}
	
	public Socket getSocket() {
		return socketClient;
	}
	
	public void connect(String IP, int portNumber){
		try {
			MessageParser msg = new MessageParser();
			
			socketClient = new Socket(IP, portNumber);
			System.out.println("Succesful connection to host : " + IP + ":" + port);
			
			out = new PrintWriter(socketClient.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socketClient.getInputStream()));
            
	        String fromServer;
	        
	        while ((fromServer = in.readLine()) != null) {
	        	JOptionPane.showMessageDialog(null, "Message received from server : " + fromServer, "Message received!", JOptionPane.INFORMATION_MESSAGE);
	            System.out.println("Server: " + fromServer);
	            if (fromServer.equals("Welcome."))
	            	msg.sendMessage(terminalID, out);
	            	break;
		    }
	        
	        JOptionPane.showMessageDialog(null, "Closing connection to host "  + IP + ":" + port, "Connection closed", JOptionPane.INFORMATION_MESSAGE);
	        System.out.println("Closing connection to host "  + IP + ":" + port);
	        
	        out.close();
	        in.close();
	    }
		catch (UnknownHostException e) {
            System.err.println("Couldn't resolve host " + IP + ":" + port);
            System.exit(1);
	    }
	    catch (IOException e) {
	        System.out.println("Couldn't get I/O for connection to host " + IP + ":" + port);
	        System.exit(1);
	    }
	}
}
