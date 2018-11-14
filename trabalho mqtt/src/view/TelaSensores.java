package view;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import equipamentos.Presenca;
import equipamentos.Temperatura;


public class TelaSensores implements ActionListener {

	/*
	private static final String IMAGES_DIR = "images\\";
	ClockManager clock;
	MoistureManager umidade;
	PresenceManager presenca;
	TempManager temperatura;
	*/
	private JFrame frmSensores;
	private JTextField textField;
	private JTextField textField2;
	private String valPres;
	private String valTemp;
	
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

	public TelaSensores() {
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
	 */
	private void initialize() {
		frmSensores = new JFrame();
		frmSensores.getContentPane().setBackground(Color.DARK_GRAY);
		frmSensores.setTitle("SENSORES");
		frmSensores.setResizable(false);
		frmSensores.setBounds(500, 100, 400, 400);
		frmSensores.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSensores.getContentPane().setLayout(new GridLayout(4, 1, 0, 0));
		
		JPanel panel = new JPanel();
		frmSensores.getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblControleUniversal = new JLabel("CONTROLE UNIVERSAL");
		panel.add(lblControleUniversal);
		lblControleUniversal.setHorizontalAlignment(SwingConstants.CENTER);
		
		JSeparator separator_2 = new JSeparator();
		panel.add(separator_2, BorderLayout.SOUTH);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 128, 128));
		panel.add(panel_1, BorderLayout.NORTH);
		
		JLabel lblDadosDoSensor = new JLabel("Sensor Temp: ");
		lblDadosDoSensor.setForeground(new Color(255, 255, 255));
		panel_1.add(lblDadosDoSensor);
		
		textField = new JTextField();
		textField.setEditable(false);
		panel_1.add(textField);
		textField.setColumns(5);
		
		JLabel lblDadosDoSensor2 = new JLabel("Sensor Presenca: ");
		lblDadosDoSensor2.setForeground(new Color(255, 255, 255));
		panel_1.add(lblDadosDoSensor2);
		
		textField2 = new JTextField();
		textField2.setEditable(false);
		panel_1.add(textField2);
		textField2.setColumns(5);
		
		JPanel lampPanel = new JPanel();
		frmSensores.getContentPane().add(lampPanel);
		lampPanel.setLayout(new BorderLayout(0, 0));
		
//		JLabel lbTempo = new JLabel("L\u00E2mpadas");
//		lbTempo.setHorizontalAlignment(SwingConstants.CENTER);
//		lampPanel.add(lbTempo, BorderLayout.NORTH);
		
		JPanel lampSubPanel = new JPanel();
		lampPanel.add(lampSubPanel, BorderLayout.CENTER);
		lampSubPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel lampintPanel = new JPanel();
		lampSubPanel.add(lampintPanel, BorderLayout.CENTER);
		lampintPanel.setLayout(new GridLayout(2, 2, 0, 0));
		
		JLabel lblNewLabel = new JLabel("L\u00E2mpada : ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lampintPanel.add(lblNewLabel);
		
		JButton btnLamp1 = new JButton("Desligado");
		lampintPanel.add(btnLamp1);
		btnLamp1.setBackground(new Color(255, 0, 0));
		btnLamp1.addActionListener(this);
		
//		JLabel lblNewLabel_1 = new JLabel("L\u00E2mpada 2 : ");
//		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
//		lampintPanel.add(lblNewLabel_1);
//		
//		JButton btnLamp2 = new JButton("Desligado");
//		lampintPanel.add(btnLamp2);
//		btnLamp2.setBackground(new Color(255, 0, 0));
//		btnLamp2.addActionListener(this);
		
		JSeparator separator_1 = new JSeparator();
		lampPanel.add(separator_1, BorderLayout.SOUTH);
		
		JPanel tempPanel = new JPanel();
		frmSensores.getContentPane().add(tempPanel);
		tempPanel.setLayout(new BorderLayout(0, 0));
		
		JLabel lbTemp = new JLabel("Televis\u00E3o");
		lbTemp.setHorizontalAlignment(SwingConstants.CENTER);
		tempPanel.add(lbTemp, BorderLayout.CENTER);
		
		JPanel tempSubPanel = new JPanel();
		tempPanel.add(tempSubPanel, BorderLayout.SOUTH);
		tempSubPanel.setLayout(new BorderLayout(0, 0));
		
		JButton btnTele = new JButton("Desligado");
		btnTele.setBackground(new Color(255, 0, 0));
		btnTele.addActionListener(this);
		tempSubPanel.add(btnTele, BorderLayout.CENTER);
		
		JSeparator separator = new JSeparator();
		tempSubPanel.add(separator, BorderLayout.SOUTH);
		
		JPanel presPanel = new JPanel();
		frmSensores.getContentPane().add(presPanel);
		presPanel.setLayout(new BorderLayout(0, 0));
		
		JLabel lbPresenca = new JLabel("Ar - Condicionado");
		lbPresenca.setHorizontalAlignment(SwingConstants.CENTER);
		presPanel.add(lbPresenca, BorderLayout.CENTER);
		
		JButton btnAr = new JButton("Desligado");
		presPanel.add(btnAr, BorderLayout.SOUTH);
		btnAr.setBackground(new Color(255, 0, 0));
		btnAr.addActionListener(this);
		
		new Thread(new Runnable() {
			public void run() {
				while(true) {
					valPres = Presenca.getPresenca();
					valTemp = Temperatura.getTemp();
					textField.setText(valTemp);
					textField2.setText(valPres);
					try {
						Thread.sleep(1000);
					}catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
        }).start();
		/*
		 Nesse ponto é bom ter uma Thread para atualizar o valor na caixa de texto do Sensor
		 cria a Thread e chama um método get do valor atual do teu sensor
		 
		 txtField.setText( sensor.getStatus() );  //isso dentro de uma thread, vai sempre setar o texto do txtField para o valor do sensor constantemente 
		 
		 */
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
			}
			else
			{
				((JButton) ae.getSource()).setBackground(new Color(0, 255, 127));
				((JButton) ae.getSource()).setText("Ligado");
				/*
				 Nesse ponto deve ter um if ae.getActionCommand == btnLamp1 then lamp1.changeValue(false) //no caso do MQTT
				 						if ae.getActionCommand == btnLamp1 then scktlamp1.send(false) //no caso do Socket	
				 */
			}
		
	}

}
