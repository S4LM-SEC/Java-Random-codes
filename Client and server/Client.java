
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
  public static void main(String[] args) {
  try {
   int port = 5050;
   Socket socket = new Socket("localhost", port);
            System.out.println("+++++++++++++++ CLIENT STARTED +++++++++++++++");

         BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
         BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
         PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
 
         String message;
         while (true) {
             System.out.print("-> Please enter your new message: ");
             message = userInput.readLine(); 
 
             out.println(message);
 
             String response = in.readLine();
             System.out.println("Server's reply: " + response);
             System.out.println("");
 
             
                boolean wantsToExit = message.equalsIgnoreCase("Ma Salama");
                boolean correctExitReply = response.equals("ما سلامة");

             if (wantsToExit && correctExitReply) {
                 break;
             }
             
         }
 
         userInput.close();
         in.close();
         out.close();
         socket.close();
            System.out.println("+++++++++++++++ CLIENT SHUT DOWN +++++++++++++++");
 
     } catch (IOException e) {
         e.printStackTrace();
     }
  }
}