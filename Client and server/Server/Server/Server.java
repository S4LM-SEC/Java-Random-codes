import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	 public static void main(String[] args) {
	        int messageCount = 0;

	        try {
	        	int port = 5050;
	            ServerSocket serverSocket = new ServerSocket(port);
	            System.out.println("--------------- SERVER STARTED ---------------");

	            Socket socket = serverSocket.accept();
	            System.out.println("--------------- CLIENT CONNECTED TO SERVER ON PORT " + port + " ---------------");

	            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

	            String clientMessage;

	            while ((clientMessage = in.readLine()) != null) {
		            System.out.println("-> recieved a new message from client: " + clientMessage);

	            	messageCount++;
	                boolean wantsToExit = clientMessage.equalsIgnoreCase("goodbye");

	                if (wantsToExit) {
	                    out.println("goodbye");
	                    break;
	                } else {
	                    out.println("OK");
	                }
	            }

	            System.out.println("Total messages received: " + messageCount);

	            in.close();
	            out.close();
	            socket.close();
	            serverSocket.close();
	            System.out.println("--------------- SERVER SHUT DOWN ---------------");

	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

}