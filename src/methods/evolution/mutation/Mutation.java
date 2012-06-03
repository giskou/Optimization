/**
 * 
 */
package methods.evolution.mutation;

import java.util.Iterator;
import java.util.Random;

import libs.Point;
import libs.Range;
import methods.evolution.Citizen;
import methods.evolution.Population;

/**
 * @author giskou
 *
 */
public abstract class Mutation {
	
	protected float pr;
	protected Range range;
	
	protected Mutation(Range range, float pr) {
		this.pr = pr;
		this.range = range;
	}
	
	public Population mutate(Population pop) {
		Random rand = new Random(System.currentTimeMillis());
		Iterator<Citizen> it = pop.getItems().iterator();
		int dim = range.max.length;
		while (it.hasNext()) {
			Citizen c = it.next();
			Point p = c.point();
			if (pr == 0) {
				int j = rand.nextInt(dim);
				p.p[j] = mut(p.p[j],j);
			} else {
				for (int i = 0; i < dim; i++) {
					if (rand.nextDouble() < this.pr) {
						p.p[i] = mut(p.p[i],i);
					}
				}
			}
		}
		return pop;
	}
	
	protected abstract double mut(double v, int dim);
}
