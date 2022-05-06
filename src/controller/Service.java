package controller;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import model.Triqui;
import view.CustomEvent;
import view.CustomEventResponse;
import view.IOManager;

public class Service implements CustomEvent {
	private CustomEventResponse event;
	public void init() {
		IOManager iom = new IOManager();
		iom.setVisible(true);
		
	}
	//M�todo para inciar la conexi�n
	@Override
	public void initServer() {
		//Creaci�n de objeto de tipo Triqui
		Triqui triqui = new Triqui();
		
		try {
			//Exportaci�n de objeto "triqui" como stub en formato de TriquiRemote (Interfaz)
			TriquiRemote stub = (TriquiRemote) UnicastRemoteObject.exportObject(triqui, 1095);
			//Se crea el registro y se define el puerto por el que se env�a
			Registry r = LocateRegistry.createRegistry(1095);
			//Se invoca el m�todo bind de Registry y se env�a el Stub y se define la interfaz que lo define
			r.bind("TriquiRemote", stub);
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (AlreadyBoundException e) {
			e.printStackTrace();
		}
		event.serverState();
		
	}
	

	public CustomEventResponse getEvent() {
		return event;
	}

	public void setEvent(CustomEventResponse event) {
		this.event = event;
	}

}
