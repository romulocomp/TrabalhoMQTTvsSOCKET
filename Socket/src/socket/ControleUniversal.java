package socket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControleUniversal {
	public String msg;
	
	public static String LigaLampada1() throws InterruptedException, IOException
	{
			/*
			 * 1. Estabelecer conexão com o servidor
			 * 2. Trocar mensagens com o servidor
			 */
				//cria conexão entre o ControleUniversal e o servidor
				
					Socket socket = new Socket("localhost", 5553);
					
					//criação dos streams de entrada e saída
					ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
					ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
					
					System.out.println("Enviando mensagem...");
					
					String msg = "LAMPADA 1 LIGADA";			
					output.writeUTF(msg);
					output.flush();
					System.out.println("Mensagem " +msg + " enviada...");
					
					input.close();
					output.close();
					socket.close();
					
					
		return msg;
		
		}
		

	
	public static void DesligaLampada1() throws InterruptedException
	{
		try {
			/*
			 * 1. Estabelecer conexão com o servidor
			 * 2. Trocar mensagens com o servidor
			 */
				//cria conexão entre o ControleUniversal e o servidor
				
					Socket socket = new Socket("localhost", 5553);
					
					//criação dos streams de entrada e saída
					ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
					ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
					
					System.out.println("Enviando mensagem...");
					
					String msg = "LAMPADA 1 DESLIGADA";			
					output.writeUTF(msg);
					output.flush();
					System.out.println("Mensagem " +msg + " enviada...");
					
					input.close();
					output.close();
					socket.close();
					
				
			} catch(IOException ex) {
				System.out.println("Erro no ControleUniversal: "+ex);
				Logger.getLogger(ControleUniversal.class.getName()).log(Level.SEVERE,null,ex);
			}

			
		}

	
	public static void LigaLampada2() throws InterruptedException
	{
		try {
			/*
			 * 1. Estabelecer conexão com o servidor
			 * 2. Trocar mensagens com o servidor
			 */
				//cria conexão entre o ControleUniversal e o servidor
				
					Socket socket = new Socket("localhost", 5553);
					
					//criação dos streams de entrada e saída
					ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
					ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
					
					System.out.println("Enviando mensagem...");
					
					String msg = "LAMPADA 2 LIGADA";			
					output.writeUTF(msg);
					output.flush();
					System.out.println("Mensagem " +msg + " enviada...");

					Thread.sleep(1000);
					
					input.close();
					output.close();
					socket.close();
					
				
			} catch(IOException ex) {
				System.out.println("Erro no ControleUniversal: "+ex);
				Logger.getLogger(ControleUniversal.class.getName()).log(Level.SEVERE,null,ex);
			}

			
		}
		
	
	public static void DesligaLampada2() throws InterruptedException
	{
		try {
			/*
			 * 1. Estabelecer conexão com o servidor
			 * 2. Trocar mensagens com o servidor
			 */
				//cria conexão entre o ControleUniversal e o servidor
				
					Socket socket = new Socket("localhost", 5553);
					
					//criação dos streams de entrada e saída
					ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
					ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
					
					System.out.println("Enviando mensagem...");
					
					String msg = "LAMPADA 2 DESLIGADA";			
					output.writeUTF(msg);
					output.flush();
					System.out.println("Mensagem " +msg + " enviada...");

					Thread.sleep(1000);
					
					input.close();
					output.close();
					socket.close();
					
				
			} catch(IOException ex) {
				System.out.println("Erro no ControleUniversal: "+ex);
				Logger.getLogger(ControleUniversal.class.getName()).log(Level.SEVERE,null,ex);
			}

			
		}
			

	public static void LigaAr() throws InterruptedException
	{
		try {
			/*
			 * 1. Estabelecer conexão com o servidor
			 * 2. Trocar mensagens com o servidor
			 */
				//cria conexão entre o ControleUniversal e o servidor
				
					Socket socket = new Socket("localhost", 5553);
					
					//criação dos streams de entrada e saída
					ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
					ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
					
					System.out.println("Enviando mensagem...");
					
					String msg = "AR LIGADO";			
					output.writeUTF(msg);
					output.flush();
					System.out.println("Mensagem " +msg + " enviada...");

					Thread.sleep(1000);
					
					input.close();
					output.close();
					socket.close();
					
				
			} catch(IOException ex) {
				System.out.println("Erro no ControleUniversal: "+ex);
				Logger.getLogger(ControleUniversal.class.getName()).log(Level.SEVERE,null,ex);
			}

			
		}
		
	
	public static void DesligaAr() throws InterruptedException
	{
		try {
			/*
			 * 1. Estabelecer conexão com o servidor
			 * 2. Trocar mensagens com o servidor
			 */
				//cria conexão entre o ControleUniversal e o servidor
				
					Socket socket = new Socket("localhost", 5553);
					
					//criação dos streams de entrada e saída
					ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
					ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
					
					System.out.println("Enviando mensagem...");
					
					String msg = "AR DESLIGADO";			
					output.writeUTF(msg);
					output.flush();
					System.out.println("Mensagem " +msg + " enviada...");

					Thread.sleep(1000);
					
					input.close();
					output.close();
					socket.close();
					
				
			} catch(IOException ex) {
				System.out.println("Erro no ControleUniversal: "+ex);
				Logger.getLogger(ControleUniversal.class.getName()).log(Level.SEVERE,null,ex);
			}

			
		}
			
	public static void LigaTV() throws InterruptedException
	{
		try {
			/*
			 * 1. Estabelecer conexão com o servidor
			 * 2. Trocar mensagens com o servidor
			 */
				//cria conexão entre o ControleUniversal e o servidor
				
					Socket socket = new Socket("localhost", 5553);
					
					//criação dos streams de entrada e saída
					ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
					ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
					
					System.out.println("Enviando mensagem...");
					
					String msg = "TV LIGADA";			
					output.writeUTF(msg);
					output.flush();
					System.out.println("Mensagem " +msg + " enviada...");

					Thread.sleep(1000);
					
					input.close();
					output.close();
					socket.close();
					
				
			} catch(IOException ex) {
				System.out.println("Erro no ControleUniversal: "+ex);
				Logger.getLogger(ControleUniversal.class.getName()).log(Level.SEVERE,null,ex);
			}

			
		}
		
	
	public static void DesligaTV() throws InterruptedException
	{
		try {
			/*
			 * 1. Estabelecer conexão com o servidor
			 * 2. Trocar mensagens com o servidor
			 */
				//cria conexão entre o ControleUniversal e o servidor
				
					Socket socket = new Socket("localhost", 5553);
					
					//criação dos streams de entrada e saída
					ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
					ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
					
					System.out.println("Enviando mensagem...");
					
					String msg = "TV DESLIGADA";			
					output.writeUTF(msg);
					output.flush();
					System.out.println("Mensagem " +msg + " enviada...");

					Thread.sleep(1000);
					
					input.close();
					output.close();
					socket.close();
					
				
			} catch(IOException ex) {
				System.out.println("Erro no ControleUniversal: "+ex);
				Logger.getLogger(ControleUniversal.class.getName()).log(Level.SEVERE,null,ex);
			}

			
		}


	public static String Sensor() throws InterruptedException, UnknownHostException, IOException
	{
		//try {
					
					Socket socket = new Socket("localhost", 5553);
					
					//criação dos streams de entrada e saída
					ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
					ObjectInputStream input = new ObjectInputStream(socket.getInputStream());

					output.writeUTF("Sensor");
					output.flush();
					
					String msg = input.readUTF();
					System.out.println("Sensor: "+ msg);
					

					input.close();
					output.close();
					socket.close();
					
					return msg;


			
		}

	


	
	public static void main(String[] args) throws InterruptedException, UnknownHostException, IOException {
		ControleUniversal comando = new ControleUniversal();
	}
	
}
