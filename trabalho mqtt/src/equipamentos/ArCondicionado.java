package equipamentos;

import org.eclipse.paho.client.mqttv3.MqttMessage;

import mqtt.TopicConstants;

public class ArCondicionado extends Equipamento{

	private int temperatura_desejada = 21;
	
	private static final String[] topics = {TopicConstants.TOPICO_TEMPERATURA,TopicConstants.TOPICO_AR_CONDICIONADO};
	
	public ArCondicionado(String clientId) {
		super(clientId,topics);
	}
	
	@Override
	public void messageArrived(String topic, MqttMessage message) {
		if(topic.equals(TopicConstants.TOPICO_TEMPERATURA)) {
			int temperatura = Integer.parseInt(message.toString());
			if(temperatura > this.temperatura_desejada){
				status = true;
				System.out.println("Ar ligado");
			}
			else{
				status= false;
				System.out.println("Ar desligado");
			}
		}
		if(topic.equals(TopicConstants.TOPICO_AR_CONDICIONADO)){
			int temp = Integer.parseInt(message.toString());
			temperatura_desejada = temp;
		}
	}
	
	public static void main(String args[]) {
		new ArCondicionado("condicionaro22323");
	}
	
}
