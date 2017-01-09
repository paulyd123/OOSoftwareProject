package ie.gmit.sw;

import java.util.Map;

/**
 * 
* @author Paul Dolan - G00297086
*  Getters and Setters for inDegree and outDegree
*/


public class Metric {

	private int inDegree;
	private int outDegree;
	
	//Gets and sets for inDegree and outDegree
	public int getInDegree() {
		return inDegree;
	}
	public void setInDegree(int inDegree) {
		this.inDegree = inDegree;
	}
	public int getOutDegree() {
		return outDegree;
	}
	public void setOutDegree(int outDegree) {
		this.outDegree = outDegree;
	}

	public double getStability(){
		float stability = 1f;
		
		//If outDegree is greater than 0
		if(outDegree <= 0){
			
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