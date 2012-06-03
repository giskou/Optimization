/**
 * 
 */
package methods.evolution.recombination;

import libs.Point;
import libs.Range;
import methods.evolution.Citizen;
import methods.evolution.Population;

/**
 * @author giskou
 *
 */
public class RealValued implements Recombination{

	Range range;
	float delta;
	
	public RealValued(Range range, float delta) {
		this.range = range;
		this.delta = delta;
	}
	
	@Override
	public Population recombine(Population pop) {
		int p1, p2;
		Population result = new Population();
		Object[] parents = pop.getItems().toArray();
		int dim = ((Citizen) parents[0]).point().dim;
		for (int i = 0; i < pop.size(); i++) {
			double[] d = new double[dim];
			p1 = (int)(Math.random()*(pop.size()-1));
			do {
				p2 = (int)(Math.random()*(pop.size()-1));
			} while (!parents[p2].equals(parents[p1]));
			for (int j = 0; j < dim; j++) {
				double a = ((Math.random()*(1 + (2*this.delta))) - this.delta);
				double pp1 = ((Citizen) parents[p1]).point().p[j];
				double pp2 = ((Citizen) parents[p2]).point().p[j];
				double v = a*pp1 + (1-a)*pp2;
				if (v > range.max[j]) v = range.max[j];
				if (v < range.min[j]) v = range.min[j];
				d[j] = v;
			}
			Citizen ctz = new Citizen(new Point(d), 0);
			result.add(ctz);
		}
		return result;
	}

}
