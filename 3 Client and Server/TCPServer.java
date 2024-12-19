import java.io.*;
import java.net.*;

public class TCPServer {
public static void main(String[] args) {

try(ServerSocket serverSocket = new ServerSocket(5000)){
	System.out.println("Server listening on port 5000");
	Socket socket = serverSocket.accept();
	BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
	String message;
	while((message = in.readLine())!= null){
	System.out.println("Receive: " + message);
	out.println("Echo: "+message);
	}
	socket.close();	
	
} catch (IOException e) {
e.printStackTrace();
}
}
}
