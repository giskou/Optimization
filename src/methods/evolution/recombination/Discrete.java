/**
 * 
 */
package methods.evolution.recombination;

import libs.Point;
import methods.evolution.Citizen;
import methods.evolution.Population;

/**
 * @author giskou
 *
 */
public class Discrete implements Recombination {

	public Population recombine(Population pop) {
		Population result = new Population();
		Object[] parents = pop.getItems().toArray();
		int dim = ((Citizen) parents[0]).point().dim;
		for (int i = 0; i < pop.size(); i++) {
			double[] d = new double[dim];
			for (int j = 0; j < dim; j++) {
				d[j] = ((Citizen) parents[(int)(Math.random()*(pop.size()-1))]).point().p[j];
			}
			Citizen ctz = new Citizen(new Point(d), 0);
			result.add(ctz);
		}
		return result;
	}
}
