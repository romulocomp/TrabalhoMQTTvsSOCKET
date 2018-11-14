package equipamentos;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import mqtt.Subscriber;
import mqtt.TopicConstants;

public class EquipamentoLampada extends Subscriber{

	private static final String[] topics = {TopicConstants.TOPICO_PRESENCA};

//	public EquipamentoLampada(String broker, String clientId) {
//		super(broker, clientId);
//	}
//	
	public EquipamentoLampada(String clientId) {
		super(clientId, topics);
	}

	private boolean status;	
	/**
	 * mensagem == true ligado
	 * mensagem == false desligado
	*/
	@Override
	public void messageArrived(String topic, MqttMessage message) {
		if(topic.equals(TopicConstants.TOPICO_PRESENCA)) {
			if(message.toString().equals("1")) {
				this.status = true;
				System.out.println("Lâmpada ligada");
			}
			else if(message.toString().equals("0")) {
				this.status = false;		
				System.out.println("Lâmpada desligada");
			}
//			boolean status = Boolean.parseBoolean(message.toString());
//			this.status = status;
		}
	}

	public boolean getStatus() {
		return this.status;
	}
	
	public static void main(String args[]) {
		new EquipamentoLampada("lampada");
	}
}
