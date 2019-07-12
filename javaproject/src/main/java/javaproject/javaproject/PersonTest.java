package javaproject.javaproject;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PersonTest {
	
	@Test
	public void souldReturnHellowWorld() {
		Person marcus = new Person();
		assertEquals("Hellow World",marcus.hellowworld());
	}
@Test
public void shouldReturnHelloMarcus() {
	Person person = new Person();
	
}
}
