package socket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;


public class sensor {

	public static void main(String[] args) throws InterruptedException {
		double i=0;
		try {
			while(true) {
				//conecta com o servidor
				Socket socket = new Socket("localhost", 5553);
				
				//criação dos streams de entrada e saída
				ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
				ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
				
				
				//enviar dados para o servidor
				String mensagem="";
				output.writeUTF(mensagem+i);
				output.flush();
				//fecha streams e socket
				input.close();
				output.close();
				socket.close();
				Thread.sleep(1000);
				i=i+0.1;
				System.out.println("Sensor enviou");


			}
		} catch(IOException ex) {
			System.out.println("Erro no sensor1: "+ex);
			Logger.getLogger(sensor.class.getName()).log(Level.SEVERE,null,ex);
		}
		
	}
	
}
