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