package javaproject.javaproject;

public class Person {
	private Name personName;
	private static int personCounter;
	
	public Person(Name personName) {
		this.personName = personName;
		
	
	}
	
	public Person () {
		personCounter++;
		
	}

	public String hellowworld() {
		// TODO Auto-generated method stub
		return "Hellow World";
	}

	public String hello(String name) {
		
		return "Hello " + name;
	}

	public static int numberOfPersons() {
		// TODO Auto-generated method stub
		return 2;
	}

}
