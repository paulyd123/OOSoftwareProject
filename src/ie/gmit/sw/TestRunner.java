package ie.gmit.sw;

import java.io.FileNotFoundException;
import java.io.IOException;

public class TestRunner {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		//Creates a new jar reader
		JarReader reader = new JarReader();
		//Reads this path with jar file
		reader.readJarFile("C:/Users/g0029/documents/Github/OOSoftwareProject/stability.jar");
	}
}