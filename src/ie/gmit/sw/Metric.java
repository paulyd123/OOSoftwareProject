package ie.gmit.sw;

import java.util.Map;

/**
 * 
* @author Paul Dolan - G00297086
*  Getters and Setters for inDegree and outDegree
*  and Stability calculations
*/

public class Metric {

	private int inDegree;
	private int outDegree;
	private String className;

	/**
	 * 
	 * @return
	 * Returns className
	 */
	
    public String getClassName() {
        return className;
    }
    
    /**
     * Pulls the class name
     * 
     * @param className
     * Class Name being used
     */

    public void setClassName(String className) {
        this.className = className;
    }

    /**
     * Gets inDegree
     * @return
     * Returns inDegree
     */
	public int getInDegree() {
		return inDegree;
	}
	
	/**
	 * Sets inDegree for the class
	 * @param inDegree
	 * inDegree is the number of classes that depend on this class
	 */
	public void setInDegree(int inDegree) {
		this.inDegree = inDegree;
	}
	
	/**
	 * Gets outDegree
	 * @return
	 * Returns outDegree
	 */
	public int getOutDegree() {
		return outDegree;
	}
	
    /**
     * Sets outDegree for the class 
     * @param outDegree
     * outDegree is the number of classes this class uses
     */
	
	public void setOutDegree(int outDegree) {
		this.outDegree = outDegree;
	}
	
	/**
	 * This method calculates the stability
	 * @return
	 * Returns stability
	 */

	public double getStability(){
		float stability = 1f;
		
		if(getOutDegree() > 0)
		{
			//Calculating stability
			stability = ((float)getOutDegree() /( (float)getInDegree() + (float)getOutDegree()));
		}
		else{
			stability = 0f;
		}
		return Math.round(stability * 100d) / 100d;
		//Returns stability
		//return stability;
	}	
}