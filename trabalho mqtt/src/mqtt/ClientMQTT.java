package mqtt;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public abstract class ClientMQTT {
	protected String broker;
	protected String clientId;
	protected MqttClient client;
	protected String[] topics;
 	
	
	public ClientMQTT() {
		this("Subs");
	}

	public ClientMQTT(String clientId) {
		this("iot.eclipse.org",clientId);
	}
		
	public ClientMQTT(String clientId, String[] topics) {
		this("iot.eclipse.org",clientId,topics);
	}
	
	public ClientMQTT(String broker, String clientId) {
		this(broker,clientId, null);
	}
	
	public ClientMQTT(String broker, String clientId, String[] topics) {
		this.topics = topics;
		this.broker ="tcp://" + broker +":1883";
		this.clientId = clientId;
		initialize();
	}

	public void connect() throws MqttException {
		MemoryPersistence persistence = new MemoryPersistence();
		this.client = new MqttClient(broker, clientId, persistence);
		MqttConnectOptions connOpts = new MqttConnectOptions();
		connOpts.setCleanSession(true);
		setCallBack();
		client.connect(connOpts);
		System.out.println("Conectado ao broker: " + broker + " com sucesso");
		System.out.println("Conectado");
	}
	
	protected void setCallBack() {
		// Não faz nada. Mas é implementado no Subscriber
	}

	public void disconnect() throws MqttException {
		client.disconnect();
		client.close();
		System.out.println("Desconectado com sucesso");
	}
	
	public abstract void initialize();

}
