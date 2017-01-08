package ie.gmit.sw;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.*;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.*;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;

/** 
* @author Paul Dolan - G00297086
* This class takes in a jar file and reads the classes
*/


public class JarReader {

	List<Class> cls = new ArrayList<Class>();

	//Empty constructor
	public JarReader() {}
	
	/**
	 * Retrieves jar from specified jar
	 * @throws FileNotFoundException
	 * @throws IOException
	 */

	
	public void readJarFile(String jarFile) throws FileNotFoundException, IOException{
		
		//Gets handle on jar file
		File file  = new File(jarFile);
		
		//Creates a URL to file
        URL url = file.toURI().toURL();
        URL[] urls = new URL[]{url};

        ClassLoader cl = new URLClassLoader(urls);
		
		JarInputStream in = new JarInputStream(new FileInputStream(new File(jarFile)));
		JarEntry next = in.getNextJarEntry();

		while (next != null) {
			if (next.getName().endsWith(".class")) {
				String name = next.getName().replaceAll("/", "\\.");
				name = name.replaceAll(".class", "");
				if (!name.contains("$")) name.substring(0, name.length() - ".class".length());
				System.out.println(name);

				Class queryClass;
				try {
					queryClass = Class.forName(name, false, cl);
					cls.add(queryClass);
					//new Reflection(queryClass);
					//System.exit(0);
				} 
				catch (ClassNotFoundException e) {
					System.out.println("Couldn't find class '" + name + "'");
					System.exit(0);
				} 
				 System.out.println(cls.size());
			}
			next = in.getNextJarEntry();
		}
		in.close();
	}
}