package ie.gmit.sw;

import java.util.Map;


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

	public float getStability(){
		float stability = 1f;
		
		if(outDegree <= 0){
			
			//Calculating stability
			stability = ((float)outDegree / (float)inDegree + (float)outDegree);
			
		}

		return stability;
	}	
}