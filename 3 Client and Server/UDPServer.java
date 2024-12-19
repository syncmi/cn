import java.io.*;
import java.net.*;

public class UDPServer {
public static void main(String[] args) {
	try(DatagramSocket socket = new DatagramSocket(5000)) {
		byte[] buffer = new byte[1024];

		while(true) {
		DatagramPacket request = new DatagramPacket(buffer, buffer.length);
		socket.receive(request);
		String message = new String(request.getData(), 0, request.getLength());
		System.out.println("Received: " + message);
		String responseMessage = "Echo: " + message;
		byte[] responseBuffer = responseMessage.getBytes();
		DatagramPacket response = new DatagramPacket(responseBuffer, responseBuffer.length, request.getAddress(), request.getPort());
		socket.send(response);
		}	
	
	} catch(IOException e) {
	e.printStackTrace();
	}
}
}
