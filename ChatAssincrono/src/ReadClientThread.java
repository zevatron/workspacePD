import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class ReadClientThread extends Thread{
	
	private Socket clientSocket;

	public ReadClientThread(Socket clientSocket) {
		super();
		this.clientSocket = clientSocket;
	}
	
	
	@Override
	public void run() {
		try {
			
			DataInputStream in = new DataInputStream(clientSocket.getInputStream());
			String msg = in.readUTF();;
			
			while(!msg.equalsIgnoreCase("fim") || !clientSocket.isClosed()){
				System.out.println(msg);
				msg = in.readUTF();
			}
			
			clientSocket.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
