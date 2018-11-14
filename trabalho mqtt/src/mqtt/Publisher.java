package mqtt;

import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;

public class Publisher extends ClientMQTT{

	private int qos = 2;

	public Publisher() {
		super("PublisherClientId");
	}
	
	public Publisher(String broker, String clientId) {
		super(broker,clientId);
	}
	
	public void publish(String content, String topic) throws MqttPersistenceException, MqttException {
		System.out.println("Publishing message: " + content);
		MqttMessage message = new MqttMessage(content.getBytes());
		message.setQos(qos);
		client.publish(topic, message);
		System.out.println("Message published");
	}

	@Override
	public void initialize() {
		String topic = "teste";
		try {
			connect();
			publish("Message from MqttPublishSample", topic);
			disconnect();
		} catch (MqttException me) {
			System.out.println("reason " + me.getReasonCode());
			System.out.println("msg " + me.getMessage());
			System.out.println("loc " + me.getLocalizedMessage());
			System.out.println("cause " + me.getCause());
			System.out.println("excep " + me);
			me.printStackTrace();
		}
	}
	
	public static void main(String args[])
	{
		new Publisher();
	}
	
}
