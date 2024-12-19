import java.io.*;
import java.net.*;

public class UDPClient {
	public static void main(String[] args) {
	try(DatagramSocket socket = new DatagramSocket()) {
	InetAddress address = InetAddress.getByName("localhost");

	byte[] buffer;
	BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));
	String message;
	while((message=consoleInput.readLine())!=null) {
	buffer = message.getBytes();
	DatagramPacket request = new DatagramPacket(buffer, buffer.length, address, 5000);
	socket.send(request);
	byte[] responseBuffer = new byte[1024];
	DatagramPacket response = new DatagramPacket(responseBuffer, responseBuffer.length);
	socket.receive(response);
	String responseMessage = new String(response.getData(), 0, response.getLength());
	System.out.println("Server replied: " + responseMessage);
	}	
	
	} catch(IOException e) {
	e.printStackTrace();
	}
	}
}
