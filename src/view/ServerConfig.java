package view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServerConfig extends JPanel implements ActionListener{
	private JLabel info;
	private CustomEvent event;
	private JButton start;
	public ServerConfig() {
		this.setBackground(new Color(84, 153, 199));
		this.setLayout(null);
		this.setBorder (new TitledBorder(null, "Servidor RMI",
				TitledBorder.CENTER, TitledBorder .TOP , null, Color.black));
		
		start = new JButton("Iniciar servidor");
		start.setBounds(160,60,140,40);
		start.addActionListener(this);
		add(start);
		
		info = new JLabel();
		info.setBounds(150,100,160,40);
		add(info);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		event.initServer();
		
	}

	public CustomEvent getEvent() {
		return event;
	}

	public void setEvent(CustomEvent event) {
		this.event = event;
	}

	public void setInfo() {
		info.setText("Se ha iniciado el servidor");
		
	}
	
}
