import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

public class Server {

	public static void main(String[] args) {

		try {
			//10.0.154.243
			ServerSocket serverSocket = new ServerSocket(8000);
			
			System.out.println("Aguardando conexão... ");
			Socket socketClient = serverSocket.accept();
			
			
			ReadClientThread in = new ReadClientThread(socketClient);
			in.start();
			
			DataOutputStream out = new DataOutputStream(socketClient.getOutputStream());
			String mensagem = JOptionPane.showInputDialog("Mensagem:");
			
			while(!socketClient.isClosed()){
				
				out.writeUTF(socketClient.getLocalAddress() + ":" + socketClient.getPort() + " - " + mensagem);
				
				mensagem = JOptionPane.showInputDialog("Mensagem:");

			}
			
			
			socketClient.close();
//			sSocket.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
