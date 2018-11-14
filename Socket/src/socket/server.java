package socket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class server {
	/* 1- Criar o servidor de conexões
	 * 2 - Esperar um pedido de conexão;
	 * 3 - Criar streams de entrada e saída;
	 * 4 - Protocolo;
	 * 5 - Fechar socket e streams;
	 */
	String msg;
	String tv;
	String ar;
	String  lampada1;
	String lampada2;
	String sensor="nada";
	private ServerSocket serverSocket;
	
	private void criarServerSocket(int porta) throws IOException
	{
		serverSocket = new ServerSocket(porta);
		
	}
	
	
	private Socket esperaConexao() throws IOException //bloqueia esperando conexão (sincrono)
	{
		Socket socket = serverSocket.accept();
		return socket;
	}
	
	private void fechaSocket(Socket s) throws IOException //fechar o socket quando terminar conexação
														//com cliente
	{
		s.close();
	}
	
	private void trataConexao( Socket socket) throws IOException 
	{
		// * cliente ----SOCKET----servidor
		//protocolo da aplicação
		
		try {
			
				// 3 - Criar streams de entrada e saída;
			ObjectOutputStream output=new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream input=new ObjectInputStream(socket.getInputStream());

			this.msg = input.readUTF();
			output.flush();
			System.out.println("Mensagem recebida: "+this.msg);
			
			
			switch (msg) {
			case "LAMPADA 1 LIGADA":
				this.lampada1=this.msg;
				break;
			case "LAMPADA 1 DESLIGADA":
				this.lampada1=this.msg;
				break;
			case "LAMPADA 2 LIGADA":
				this.lampada2=this.msg;
				break;
			case "LAMPADA 2 DESLIGADA":
				this.lampada2=this.msg;
				break;
			case "AR LIGADO":
				this.ar=this.msg;
				break;
			case "AR DESLIGADO":
				this.ar=this.msg;
				break;
			case "TV LIGADA":
				this.tv=this.msg;
				break;
			case "TV DESLIGADA":
				this.tv=this.msg;
				break;
			case "TV":
				output.writeUTF(this.tv);
				output.flush();
				break;
			case "LAMPADA1":
				output.writeUTF(this.lampada1);
				output.flush();
				break;
			case "LAMPADA2":
				output.writeUTF(this.lampada2);
				output.flush();
				break;
			case "AR":
				output.writeUTF(this.ar);
				output.flush();
				break;
			case "Sensor":
				break;
			default:
				this.sensor = this.msg;
			}
			
		
			output.writeUTF(this.sensor);
			output.flush();
						
	
			input.close();
			output.close();
			
		}catch( IOException e){
			//tratamento de falhas
			System.out.println("Probelma no tratamento da conexão com o cliente: "+socket.getInetAddress());
			System.out.println("Erro: "+e.getMessage());
		}finally {
			//final do tratamento do protocolo
			//4.1 - Fechar socket de comunicação entre servidor/cliente
			fechaSocket(socket);
		}
			
		
	}
	


	public static void main(String[] args) {
		try {
			server server = new server();
			System.out.println("Aguardando conexão...");
			server.criarServerSocket(5553);
			//inicialmente ser criar o Socket, no caso foi usado a porta 5553
			while(true) {
				//espera o pedido de conexão
				Socket socket = server.esperaConexao(); //protocolo 
				System.out.println("Cliente conectado...");
				
				//trata o protocolo
				server.trataConexao(socket);
				

			}
			
		} catch (IOException e) {
			//trata exceção
		}
	}

}
