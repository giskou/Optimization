/**
 * 
 */
package methods.evolution;

import java.util.Comparator;

import libs.Point;

/**
 * @author giskou ekontogi
 *
 */
public class Citizen {
	Point p;
	double value;
	int rank;
	float fitness;
	
	static class CitizenCompare implements Comparator<Citizen> {
		public int compare(Citizen c1,Citizen c2) {
			if(c1.value > c2.value)
				return +1;
			else 
				return -1;
//			if(c1.value < c2.value)
//				return -1;
//			else
//				return 0;
		}
		
//		public boolean equals(Citizen c1) {
//			if(value == c1.value) {
//				return true;
//			}
//			else {
//				return false;
//			}
//		}
	}
	
	public Citizen(Point p, double value) {
		this.p = p;
		this.value = value;
	}
	
	public double getValue() {
		return value;
	}

	public void setValue(double v) {
		this.value = v;
	}
	
	public int getRank() {
		return rank;
	}

	public void setRank(int r) {
		this.rank = r;
	}
	
	public void setFitness(float f) {
		this.fitness = f;
	}
	
	public float fitness() {
		return this.fitness;
	}
	
	public Point point() {
		return p;
	}

	public String toString() {
		return "f:" + fitness + " v:" + (float)value + " p:" + p;
	}
}