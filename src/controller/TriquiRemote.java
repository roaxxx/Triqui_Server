package controller;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface TriquiRemote extends Remote{
	
	 String isWinner(String [] triqui, int k) throws RemoteException;
	 
	 int [] getWinOption(String [] triqui, String resultString) throws RemoteException;
}
