import static org.junit.Assert.*;

import org.junit.Test;

public class ServiceBrokerTest {

	@Test
	public void test() {
		String input = "";
		String expected = "";
		String output = ServiceBroker.parseInstruction();
		
		assertEquals(expected, output);	
	}

}
