package ie.gmit.sw;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.jar.JarInputStream;
import java.util.jar.JarEntry;


public class JarReader {
	
	private ArrayList<Class> jarContents = new ArrayList<Class>();
	
	//Empty constructor
	public JarReader(){}
	
	//Retrieves the jar from the specified jar, put's each entry into an array
	public void getJar(String jarName) throws FileNotFoundException, IOException{
		JarInputStream in = new JarInputStream(new FileInputStream(new File(jarName)));
		JarEntry next = in.getNextJarEntry();
		while (next != null) {
		 if (next.getName().endsWith(".class")) {
		 String name = next.getName().replaceAll("/", "\\.");
		 name = name.replaceAll(".class", "");
		 if (!name.contains("$")) name.substring(0, name.length() - ".class".length());
		 System.out.println(name);
		 }
		 next = in.getNextJarEntry();
		}
		in.close();
	}
}
