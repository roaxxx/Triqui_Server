package model;

import java.rmi.RemoteException;

import controller.TriquiRemote;

public class Triqui implements TriquiRemote {	
	private int [][] winCond= {
			{0,1,2},
			{3,4,5},
			{6,7,8},
			{0,3,6},
			{1,4,7},
			{2,5,8},
			{0,4,8},
			{2,4,6},
	};
	
	public Triqui() {
		
	}
	
	//Retorna si hay un ganador y si lo hay que ficha utilizó para ganar
	@Override
	public String isWinner(String[] triqui, int k) throws RemoteException {
		for(int i =0; i< winCond.length;i++) {
			if(triqui[winCond[i][0]].equals("X") &&
					triqui[winCond[i][1]].equals("X")&&
					triqui[winCond[i][2]].equals("X")) {
					return "X";
			}else if(triqui[winCond[i][0]].equals("O") &&
					triqui[winCond[i][1]].equals("O")&&
					triqui[winCond[i][2]].equals("O")) {
					return "O";
			}
		}
		return "-";
	}
    //Devuelve las posiciones de las fichas que han hecho la raya de tres
	@Override
	public int[] getWinOption(String[] triqui, String resultString) throws RemoteException {
		int [] a  = new int [3];
		for(int i =0; i< winCond.length;i++) {
			if(triqui[winCond[i][0]].equals(resultString) &&
					triqui[winCond[i][1]].equals(resultString)&&
					triqui[winCond[i][2]].equals(resultString)) {
                    a[0]=winCond[i][0];
                    a[1]=winCond[i][1];
                    a[2]=winCond[i][2];
			}
		}
		return a;
	}

}
