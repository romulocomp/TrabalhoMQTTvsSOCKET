package mqtt;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public abstract class Subscriber extends ClientMQTT implements MqttCallback {
	
	public Subscriber(String clientId,String[] topics) {
		super(clientId,topics);
	}
	
	public Subscriber(String broker, String clientId) {
		super(broker,clientId);
	}

	//String... topics => String[] topics
 	public void subscribe(String topic) throws MqttException {
		client.subscribe(topic);
	}


	@Override
	public void connectionLost(Throwable cause) {
		System.out.println("A conexão foi perdida " + clientId);
	}

	
	@Override
	public void deliveryComplete(IMqttDeliveryToken token) {
		System.out.println("Mensagem enviada com sucesso.");
	}
	
	@Override
	protected void setCallBack() {
		client.setCallback(this);
	}
		
	@Override
	public void initialize() {
		try {
			connect();
			System.out.println("Conectado ao broker: " + broker + " com sucesso");
//			String[] topics = {TopicConstants.TOPICO_TEMPERATURA,TopicConstants.TOPICO_AR_CONDICIONADO};
//			String topic = "test";
			for(String topic : this.topics) {
				subscribe(topic);
				System.out.println("Inscrito no tópico: " + topic + " com sucesso");
			}
//				subscribe(TopicConstants.TOPICO_AR_CONDICIONADO);
//				System.out.println("Inscrito no tópico: " + topic + " com sucesso");
//			}
		} catch (MqttException e) {
			e.printStackTrace();
		}
	}
	
	public abstract void messageArrived(String topic, MqttMessage message);
	

}
