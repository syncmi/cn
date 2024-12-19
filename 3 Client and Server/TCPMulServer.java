import java.io.*;
import java.net.*;
public class TCPMulServer {
public static void main(String[] args) {

try(ServerSocket serverSocket = new ServerSocket(5000)){
        System.out.println("Server listening on port 5000");
	while(true) {
	Socket socket = serverSocket.accept();
	System.out.println("New client connected");
	new ClientHandler(socket).start();
	}
       
} catch (IOException e) {

e.printStackTrace();
}
}
}
class ClientHandler extends Thread {
private Socket socket;
public ClientHandler(Socket socket) {
this.socket = socket;
}
public void run() {
	try {
	
		BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
		String message;
		while((message=in.readLine())!=null) {
		System.out.println("Received: "+message);
		out.println("Echo: " + message);
		} socket.close();
	
	} catch (IOException e) {
	e.printStackTrace();
	}
}
}
