package test.client;

import test.api.Greeter;
import test.support.api.JsonProvider;
import aQute.bnd.annotation.component.Activate;
import aQute.bnd.annotation.component.Component;
import aQute.bnd.annotation.component.Reference;

import com.eclipsesource.jaxrs.consumer.ConsumerPublisher;

@Component
public class ServicePublisher {

	private JsonProvider jsonProvider;

	private ConsumerPublisher publisher;

	@Reference
	public void setJsonProvider(JsonProvider jsonProvider) {
		this.jsonProvider = jsonProvider;
	}

	@Reference
	public void setConsumerPublisher(ConsumerPublisher publisher) {
		this.publisher = publisher;
	}

	@Activate
	public void start() {
		publisher
				.publishConsumers("http://localhost:8080/services",
						new Class<?>[] { Greeter.class },
						new Object[] { jsonProvider });
	}
}
