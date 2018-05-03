import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

public class Cliente {

	public static void main(String[] args) {
		try {
			Socket s = new Socket("localhost", 8000);
			System.out.println("Conectando....");

			DataOutputStream out = new DataOutputStream(s.getOutputStream());
			DataInputStream in = new DataInputStream( s.getInputStream());
			String mensagem = "";
			do{
				out.writeUTF(
						s.getLocalAddress() + ":" + s.getPort() + " - " + JOptionPane.showInputDialog("Mensagem:"));
				mensagem = in.readUTF();
				System.out.println(s.getInetAddress() + ":" + s.getPort() + " - " + mensagem);
			} while (mensagem.equalsIgnoreCase("fim"));

			s.close();
			System.out.println("Conexão encerrada.");

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
