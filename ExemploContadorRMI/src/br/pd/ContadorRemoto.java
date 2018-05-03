package br.pd;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Logger;

public class ContadorRemoto extends UnicastRemoteObject implements ContadorIF{
	
	
	private static final long serialVersionUID = 1L;
	private int cont;

	public ContadorRemoto() throws RemoteException {
		
		cont = 0;
		
	}

	@Override
	public void inc() throws RemoteException {

		cont++;
		
	}

	@Override
	public int get() throws RemoteException {
		return cont;
	}
	
	public static void main(String[] args) throws MalformedURLException{
		try {
			
			ContadorIF contador = new ContadorRemoto();
			LocateRegistry.createRegistry(1099);
			Naming.bind("contador", contador);
			
		} catch (Exception e) {
			
			Logger.getLogger(ContadorRemoto.class.getName());
			
		}
	}

}
