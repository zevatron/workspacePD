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
			ServerSocket sSocket = new ServerSocket(8000);
			System.out.println(sSocket.getInetAddress());
			
			System.out.println("Aguardando conexão...");
			Socket s = sSocket.accept();
			
			
			DataInputStream in = new DataInputStream( s.getInputStream());
			DataOutputStream out = new DataOutputStream(s.getOutputStream());
			String mensagem = "";
			do{
				mensagem = in.readUTF();
				System.out.println(s.getInetAddress() + ":" + s.getPort() + " - " + mensagem);

				out.writeUTF(
						s.getLocalAddress() + ":" + s.getPort() + " - " + JOptionPane.showInputDialog("Mensagem:"));
			}while( mensagem.equalsIgnoreCase("fim"));
			
			
			s.close();
			sSocket.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
