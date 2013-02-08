package test.client;

import test.api.Greeter;
import aQute.bnd.annotation.component.Activate;
import aQute.bnd.annotation.component.Component;
import aQute.bnd.annotation.component.Reference;

@Component
public class ServiceClient {

	private Greeter greeter;

	@Reference
	public void setGreeter(Greeter greeter) {
		this.greeter = greeter;
	}

	@Activate
	public void start() {
		try {
			System.out.println(greeter.greeting().getGreeting());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
