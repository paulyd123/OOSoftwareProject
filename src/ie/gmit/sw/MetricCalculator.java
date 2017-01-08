package ie.gmit.sw;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;

/**
 * 
* @author Paul Dolan - G00297086
* Metric calculator class 
*/

public class MetricCalculator {


	//Variables
	private HashMap<String, Metric> graph = new HashMap<>();
	private List<Class> jarClass;
	private String jar;


	//MetricCalculator constructor
	public MetricCalculator(List<Class> cls, String jarName) {

		this.jarClass = cls;
		this.jar = jarName;
		addClass();
		calculateMetric();
	}


	//Adds class
	public void addClass(){
		for (int i = 0; i < jarClass.size(); i++) {
			graph.put(jarClass.get(i).getName(), new Metric());
			System.out.println(jarClass.get(i).getName());
		}
		System.out.println(graph.keySet());
		System.out.println("sixe" + graph.size());
	}

	//Calculates Metric
	public void calculateMetric(){
		try {
			
			//Gets handle on jar file
			File file  = new File(jar);
			
			//Creates a URL to file
			URL url = file.toURI().toURL();
			URL[] urls = new URL[]{url};

			//Loads classes from jar file
			ClassLoader cl = new URLClassLoader(urls);

			
			for(String name : graph.keySet()){
				
			//Loads class information	
			Class queryClass = Class.forName(name, false, cl);
			System.out.println(name);
			new Reflection(queryClass);
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}