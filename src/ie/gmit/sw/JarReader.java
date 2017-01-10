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

	List<Class> jarContent = new ArrayList<Class>();
	public JarReader() {}

	/**
	 * @param jarFile
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public List<Class> readJarFile(String jarFile) throws FileNotFoundException, IOException{

		//Gets handle on jar file
		File file  = new File(jarFile);
		
		//Creates a URL to file
        URL url = file.toURI().toURL();
        URL[] urls = new URL[]{url};

        //Creating class loader
        ClassLoader cl = new URLClassLoader(urls);
		
        
		JarInputStream in = new JarInputStream(new FileInputStream(new File(jarFile)));
		JarEntry next = in.getNextJarEntry();
		
		
		
		while (next != null) {
			if (next.getName().endsWith(".class")) {
				String name = next.getName().replaceAll("/", "\\.");
				name = name.replaceAll(".class", "");
				if (!name.contains("$")) name.substring(0, name.length() - ".class".length());
				
				Class cls;
				
				try {
					cls = Class.forName(name, false, cl);
					jarContent.add(cls);
					//System.exit(0);
				} 
				catch (ClassNotFoundException e) {
					System.out.println("Couldn't find class '" + name + "'");
					System.exit(0);//Exits
				}
			}
			next = in.getNextJarEntry();
		}
		//Returns jar content
		return jarContent;
	}
}