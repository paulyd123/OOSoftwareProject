package ie.gmit.sw;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Tester {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		//Creating a new jar reader
		JarReader reader  = new JarReader();
		//Reading/Testing string-service from other project
		reader.getJar("C:/Users/g0029/Documents/GitHub/OOSoftwareProject/string-service.jar");
	}
}
