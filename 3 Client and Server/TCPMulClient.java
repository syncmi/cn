import java.io.*;
import java.net.*;

public class TCPMulClient {
	public static void main (String[] args) {
	try(Socket socket = new Socket("localhost",5000)) {
	BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

	PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
	BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));
	String message;
	while((message = consoleInput.readLine())!=null) {
	out.println(message);
	System.out.println("Server replied: " + in.readLine());
	}
	
	} catch(IOException e) {
	
	e.printStackTrace();
	}
	}

}
