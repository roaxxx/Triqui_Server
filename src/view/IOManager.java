package view;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.Service;

public class IOManager extends JFrame implements CustomEventResponse {
	private JPanel serverInfo;
	private Service c;
	public IOManager() {
		
		c = new Service();
		
		c.setEvent(this);
		
		setSize(490,200);

		setTitle("Triqui RMI");

		setLocationRelativeTo(null);

		setLayout(null);

		setResizable(false);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		serverInfo = new ServerConfig();
		serverInfo.setBounds(5,5,470,155);
		((ServerConfig)serverInfo).setEvent(c);
		add(serverInfo);
	}
	@Override
	public void serverState() {
		((ServerConfig)serverInfo).setInfo();
		
	}
}
