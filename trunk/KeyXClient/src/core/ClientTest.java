package core;

public class ClientTest {
	
	public static void main(String[] args) {
		Client client = new Client("40Q10600");
		MessageParser msg = new MessageParser();
		
		client.connect(client.getIP(), client.getPort());
		
		msg.sendMessage(client.getTerminalID(), client.getOutputStream());
		msg.sendMessage("KEYX", client.getOutputStream());
		msg.sendMessage("QUIT", client.getOutputStream());
	}
}