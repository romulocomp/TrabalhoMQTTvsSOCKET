package socket;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import socket.ControleUniversal;
import socket.arcondicionado;
import socket.lampada1;
import socket.lampada2;


public class TelaSensores implements ActionListener{

	/*
	private static final String IMAGES_DIR = "images\\";
	ClockManager clock;
	MoistureManager umidade;
	PresenceManager presenca;
	TempManager temperatura;
	*/
	private JFrame frmSensores;
	private static JTextField textField;
	
	private JButton btnAr;
	private JLabel lbPresenca;
	private JPanel presPanel;
	private JSeparator separator;
	private JButton btnTele;
	private JPanel tempSubPanel;
	private JLabel lbTemp;
	private JPanel tempPanel;
	private JSeparator separator_1;
	private JButton btnLamp2;
	private JLabel lblNewLabel_1;
	private JButton btnLamp1;
	private JLabel lblNewLabel;
	private JPanel lampintPanel;
	private JPanel lampSubPanel;
	private JLabel lbTempo;
	private JPanel lampPanel;
	private JLabel lblDadosDoSensor;
	private JPanel panel_1;
	private JSeparator separator_2;
	private JLabel lblControleUniversal;
	private JPanel panel;
	private String msg;


	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaSensores window = new TelaSensores();
					window.frmSensores.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaSensores() throws InterruptedException, IOException {
		/* INSTANCIA DOS COMPONENTES PUB OU SERVIDORES
		clock = new ClockManager();
		umidade = new MoistureManager();
		presenca = new PresenceManager();
		temperatura = new TempManager();
		*/
		

		
		
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws InterruptedException 
	 * @throws IOException 
	 */
	private void initialize() throws InterruptedException, IOException {
		frmSensores = new JFrame();
		frmSensores.getContentPane().setBackground(Color.DARK_GRAY);
		frmSensores.setTitle("SENSORES");
		frmSensores.setResizable(false);
		frmSensores.setBounds(100, 100, 300, 400);
		frmSensores.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSensores.getContentPane().setLayout(new GridLayout(4, 1, 0, 0));
		
		panel = new JPanel();
		frmSensores.getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		lblControleUniversal = new JLabel("CONTROLE UNIVERSAL");
		panel.add(lblControleUniversal);
		lblControleUniversal.setHorizontalAlignment(SwingConstants.CENTER);
		
		separator_2 = new JSeparator();
		panel.add(separator_2, BorderLayout.SOUTH);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 128, 128));
		panel.add(panel_1, BorderLayout.NORTH);
		
		lblDadosDoSensor = new JLabel("Dados do Sensor: ");
		lblDadosDoSensor.setForeground(new Color(255, 255, 255));
		panel_1.add(lblDadosDoSensor);
		
		textField = new JTextField();
		textField.setEditable(false);
		panel_1.add(textField);
		textField.setColumns(5);
		
		lampPanel = new JPanel();
		frmSensores.getContentPane().add(lampPanel);
		lampPanel.setLayout(new BorderLayout(0, 0));
		
		lbTempo = new JLabel("L\u00E2mpadas");
		lbTempo.setHorizontalAlignment(SwingConstants.CENTER);
		lampPanel.add(lbTempo, BorderLayout.NORTH);
		
		lampSubPanel = new JPanel();
		lampPanel.add(lampSubPanel, BorderLayout.CENTER);
		lampSubPanel.setLayout(new BorderLayout(0, 0));
		
		lampintPanel = new JPanel();
		lampSubPanel.add(lampintPanel, BorderLayout.CENTER);
		lampintPanel.setLayout(new GridLayout(2, 2, 0, 0));
		
		lblNewLabel = new JLabel("L\u00E2mpada 1 : ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lampintPanel.add(lblNewLabel);
		
		btnLamp1 = new JButton("Desligado");
		lampintPanel.add(btnLamp1);
		btnLamp1.setBackground(new Color(255, 0, 0));
		btnLamp1.addActionListener(this);
		
		lblNewLabel_1 = new JLabel("L\u00E2mpada 2 : ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lampintPanel.add(lblNewLabel_1);
		
		btnLamp2 = new JButton("Desligado");
		lampintPanel.add(btnLamp2);
		btnLamp2.setBackground(new Color(255, 0, 0));
		btnLamp2.addActionListener(this);
		
		separator_1 = new JSeparator();
		lampPanel.add(separator_1, BorderLayout.SOUTH);
		
		tempPanel = new JPanel();
		frmSensores.getContentPane().add(tempPanel);
		tempPanel.setLayout(new BorderLayout(0, 0));
		
		lbTemp = new JLabel("Televis\u00E3o");
		lbTemp.setHorizontalAlignment(SwingConstants.CENTER);
		tempPanel.add(lbTemp, BorderLayout.CENTER);
		
		tempSubPanel = new JPanel();
		tempPanel.add(tempSubPanel, BorderLayout.SOUTH);
		tempSubPanel.setLayout(new BorderLayout(0, 0));
		
		btnTele = new JButton("Desligado");
		btnTele.setBackground(new Color(255, 0, 0));
		btnTele.addActionListener(this);
		tempSubPanel.add(btnTele, BorderLayout.CENTER);
		
		separator = new JSeparator();
		tempSubPanel.add(separator, BorderLayout.SOUTH);
		
		presPanel = new JPanel();
		frmSensores.getContentPane().add(presPanel);
		presPanel.setLayout(new BorderLayout(0, 0));
		
		lbPresenca = new JLabel("Ar - Condicionado");
		lbPresenca.setHorizontalAlignment(SwingConstants.CENTER);
		presPanel.add(lbPresenca, BorderLayout.CENTER);
		
		btnAr = new JButton(msg);
		presPanel.add(btnAr, BorderLayout.SOUTH);
		btnAr.setBackground(new Color(255, 0, 0));
		btnAr.addActionListener(this);
		
		/*
		 Nesse ponto é bom ter uma Thread para atualizar o valor na caixa de texto do Sensor
		 cria a Thread e chama um método get do valor atual do teu sensor
		 
		 txtField.setText( sensor.getStatus() );  //isso dentro de uma thread, vai sempre setar o texto do txtField para o valor do sensor constantemente 
		 
		 */
		
		new Thread(new Runnable() {
			public void run() {
				while(true) {
	      		try {
					textField.setText(ControleUniversal.Sensor());
					Thread.sleep(1000);
				} catch (InterruptedException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
			}
		}).start();
		

	}
	
	
	


	@Override
	public void actionPerformed(ActionEvent ae) {
			if(ae.getActionCommand() == "Ligado") {
				((JButton) ae.getSource()).setBackground(new Color(255, 0, 0));
				((JButton) ae.getSource()).setText("Desligado");
				
				/*
				 Nesse ponto deve ter um if ae.getActionCommand == btnLamp1 then lamp1.changeValue(true) //no caso do MQTT
				 						if ae.getActionCommand == btnLamp1 then scktlamp1.send(true) //no caso do Socket	
				 */
				
				try {
					
						if(ae.getSource()==btnAr) {
							ControleUniversal.DesligaAr();
							arcondicionado.main(null);
						}
						if(ae.getSource()==btnLamp1) {
							ControleUniversal.DesligaLampada1();
							lampada1.main(null);
						}
						if(ae.getSource()==btnLamp2) {
							ControleUniversal.DesligaLampada2();
							lampada2.main(null);
						}
						if(ae.getSource()==btnTele) {
							ControleUniversal.DesligaTV();
							tv.main(null);
						}
								
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
}
			else
			{
				((JButton) ae.getSource()).setBackground(new Color(0, 255, 127));
				((JButton) ae.getSource()).setText("Ligado");
				try {
				System.out.println("TESTEEEEE");
				if(ae.getSource()==btnAr) {
					ControleUniversal.LigaAr();
					arcondicionado.main(null);
				}
				if(ae.getSource()==btnLamp1) {
					ControleUniversal.LigaLampada1();
					lampada1.main(null);
				}
				if(ae.getSource()==btnLamp2) {
					ControleUniversal.LigaLampada2();
					lampada2.main(null);
				}
				if(ae.getSource()==btnTele) {
					ControleUniversal.LigaTV();
					tv.main(null);
				}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				/*
				 Nesse ponto deve ter um if ae.getActionCommand == btnLamp1 then lamp1.changeValue(false) //no caso do MQTT
				 						if ae.getActionCommand == btnLamp1 then scktlamp1.send(false) //no caso do Socket	
				 */
			}
		
	}

}
