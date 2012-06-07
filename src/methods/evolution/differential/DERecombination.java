/**
 * 
 */
package methods.evolution.differential;

import java.util.Iterator;
import java.util.Random;

import libs.Point;
import methods.evolution.Citizen;
import methods.evolution.Population;

/**
 * @author giskou
 *
 */
public class DERecombination {
	
	float cc;
	
	public DERecombination(float crossover) {
		this.cc = crossover;
	}

	public Population recombine(Population pop, Population old, DEInput in) {
		Random r = new Random(System.currentTimeMillis());
		Population result = new Population();
		Iterator<Citizen> itNew = pop.getItems().iterator();
		Iterator<Citizen> itOld = old.getItems().iterator();
		while(itNew.hasNext() && itOld.hasNext()) {
			Point pNew = itNew.next().point();
			Point pOld = itOld.next().point();
			int j = r.nextInt(in.dim-1);
			double[] u = new double[in.dim];
			for (int i = 0; i < in.dim; i++) {
				if (i == j || r.nextFloat() < this.cc) {
					u[i] = pNew.p[i];
				} else {
					u[i] = pOld.p[i];
				}
			}
			result.add(new Point(u), 0);
		}
		return result;
	}

}
