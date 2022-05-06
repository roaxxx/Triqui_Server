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
	//Método para inciar la conexión
	@Override
	public void initServer() {
		//Creación de objeto de tipo Triqui
		Triqui triqui = new Triqui();
		
		try {
			//Exportación de objeto "triqui" como stub en formato de TriquiRemote (Interfaz)
			TriquiRemote stub = (TriquiRemote) UnicastRemoteObject.exportObject(triqui, 1095);
			//Se crea el registro y se define el puerto por el que se envía
			Registry r = LocateRegistry.createRegistry(1095);
			//Se invoca el método bind de Registry y se envía el Stub y se define la interfaz que lo define
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
