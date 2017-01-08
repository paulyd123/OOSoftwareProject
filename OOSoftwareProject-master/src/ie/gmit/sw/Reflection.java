package ie.gmit.sw;

import java.lang.reflect.*;


public class Reflection {

	private Class cls;

	
	public Reflection(Class cls){
		super();
		this.cls = cls;
		getPackage();
		getInterface();
		getConstructor();
		getFields();
		getMethods();
	}

	private void getMethods() {
		
		//Gets set of methods
		Method[] methods = cls.getMethods(); 
		Class[] methodParams;

		//Loop over the methods and print its name and its return type
		for(Method m : methods){

			System.out.println("Method Name: " + m.getName());
			//Gets method return type
			Class methodReturnType = m.getReturnType(); 
			System.out.println("Method Return Type: " + methodReturnType.getName());

			//Gets method parameters
			methodParams = m.getParameterTypes(); 
			
			//Loops over method parameters and prints out each method parameter name
			for(Class mp : methodParams){

				System.out.println("Method Parameter: " + mp.getName());
			}
		}
	}
	private void getFields() {
		//Gets field and attributes
		Field[] fields = cls.getFields(); 
		
		//Loops over fields and prints out field name
		for(Field f : fields){

			System.out.println("Field Name: " + f.getName());
		}
	}
	private void getConstructor() {
		//Gets constructors
		Constructor[] cons = cls.getConstructors(); 
		Class[] constructorParams;

		//Loops over constructor and prints out parameter name
		for(Constructor c : cons){

			System.out.println("Contructor Name: " + c.getName());
			//Gets parameters
			constructorParams = c.getParameterTypes(); 
			for(Class param : constructorParams){

				System.out.println("Constructor Parameter: " + param.getName());
			}
		}
	}
	private void getInterface() {
		boolean iface = cls.isInterface();
		System.out.println("Is this Class an Interface?: " + iface);

		
		Class[] interfaces = cls.getInterfaces(); 
		
		//Loops over the interface prints out interface name
		for(Class i : interfaces){

			System.out.println("Implements Interface: " + i.getName());
		}
	}
	private void getPackage() {
		
		//Gets package
		Package pack = cls.getPackage(); 
		System.out.println("Package Name: " + pack.getName());
	}
}