package test.api;

public class GreetingMessage {
	
	private String greeting;
	
	public GreetingMessage()
	{
		this(null);
	}

	public GreetingMessage(String greeting) {
		this.greeting = greeting;
	}

	public String getGreeting() {
		return greeting;
	}
}
