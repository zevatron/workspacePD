package br.pd;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ContadorIF extends Remote{
	public void inc() throws RemoteException;
	public int get() throws RemoteException;

}
