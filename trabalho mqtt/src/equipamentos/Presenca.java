package equipamentos;

import org.eclipse.paho.client.mqttv3.MqttException;
import java.util.Random;

import mqtt.Publisher;
import mqtt.TopicConstants;

public class Presenca extends Publisher {

	protected static final long DELAY = 1000;
	private static final String topic = TopicConstants.TOPICO_PRESENCA;
	Random temp = new Random();
	static int aux;
	private static String a;
	
	
	public Presenca() {
		super();
		monitore();
	}

	public Presenca(String clientId) {
		super(clientId, topic);
		monitore();
	}

	public void monitore() {
		try {
			this.connect();

			new Thread(new Runnable() {

				@Override
				public void run() {
					while (true) {
						try {
							Thread.sleep(DELAY);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						changeValue();
						update();
					}
				}
			}).start();
		} catch (MqttException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	
	public void changeValue() {
		for(int i=0; i<10;i++) {
			aux = temp.nextInt(2);
		}
	}
	
	public void update() {
		try {
			this.publish(String.valueOf(aux), topic);
		} catch (MqttException e) {
			e.printStackTrace();
		}
	}
	
	public static String getPresenca() {
//		System.out.println("Presenca: "+String.valueOf(aux));
		return String.valueOf(aux);
		
	}
	
	public static void main(String args[]) {
		Presenca presenca = new Presenca();
	}
}
