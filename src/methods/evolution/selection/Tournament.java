/**
 * 
 */
package methods.evolution.selection;

import methods.evolution.Citizen;
import methods.evolution.Population;

/**
 * @author giskou
 *
 */
public class Tournament implements Selector {

	int size;
	
	public Tournament(int size) {
		this.size = size;
	}
	
	public Population Spin(Population pop) {
		Population result = new Population();
		int popSize = pop.size();
		Object[] cits = pop.getItems().toArray();
		for (int i = 0; i < popSize; i++) {
			Citizen min = null, c;
			for (int j = 0; j < this.size; j++) {
				if (j == 0) {
					min = (Citizen)cits[(int)(Math.random()*(popSize-1))];
				} else {
					c = (Citizen)cits[(int)(Math.random()*(popSize-1))];
					if (min.getValue() > c.getValue()) {
						min = c;
					}
				}
			}
			result.add(min);
		}
		return result;
	}

}
