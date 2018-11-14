package equipamentos;

import org.eclipse.paho.client.mqttv3.MqttMessage;

import mqtt.Subscriber;

public abstract class Equipamento extends Subscriber{
	protected boolean status;

	public Equipamento(String clientId,String[] topics) {
		super(clientId,topics);
		status = false;
	}
	
	public boolean getStatus() {
		return status;
	}

	public abstract void messageArrived(String topic, MqttMessage message);

	
}
