package br.cliente;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import br.pd.ContadorIF;

public class Main {

	public static void main(String[] args) {
		
		try {
			ContadorIF contador = (ContadorIF) Naming.lookup("rmi://localhost:1099/contador");
			System.out.println(contador.get());
			contador.inc();
			System.out.println(contador.get());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
