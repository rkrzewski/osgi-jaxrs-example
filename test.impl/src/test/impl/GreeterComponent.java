package test.impl;

import test.api.Greeter;
import test.api.GreetingMessage;
import aQute.bnd.annotation.component.Component;

@Component
public class GreeterComponent implements Greeter {
	@Override
	public GreetingMessage greeting() {
		return new GreetingMessage("Howdy!");
	}    
}
