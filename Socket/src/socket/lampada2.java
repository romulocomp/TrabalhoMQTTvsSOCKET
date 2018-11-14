package socket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;


public class lampada2 {

	public static void main(String[] args) throws InterruptedException {

		try {
				//conecta com o servidor
				Socket socket = new Socket("localhost", 5553);
				
				//cria��o dos streams de entrada e sa�da
				ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
				ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
	
				//se identifica para o servidor
				String mensagem = "LAMPADA2";
				output.writeUTF(mensagem);
				output.flush();
				//recebe comando do servidor
				mensagem = input.readUTF();
				System.out.println("Resposta: "+ mensagem);
				//fecha streams e socket
				input.close();
				output.close();
				socket.close();
				
		//	}
		} catch(IOException ex) {
			System.out.println("Erro no lampada2: "+ex);
			Logger.getLogger(lampada2.class.getName()).log(Level.SEVERE,null,ex);
		}
		
	}
	
}
