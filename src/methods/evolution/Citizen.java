/**
 * 
 */
package methods.evolution;

import java.util.Comparator;

import libs.Point;

/**
 * @author giskou
 *
 */
public class Citizen {
	Point x;
	double value;
	int rank;
	float fitness;
	
	static class CitizenCompare implements Comparator<Citizen> {
		public int compare(Citizen c1,Citizen c2) {
			if(c1.value > c2.value)
				return +1;
			else if(c1.value < c2.value)
				return -1;
			else
				return 0;
		}
	}
	
	public Citizen(Point p, double value) {
		this.x = p;
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

	public String toString() {
		return fitness + " " + value;
	}
}
