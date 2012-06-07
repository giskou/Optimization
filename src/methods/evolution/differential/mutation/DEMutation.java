/**
 * 
 */
package methods.evolution.differential.mutation;

import java.util.Random;

import methods.evolution.Citizen;
import methods.evolution.Population;

/**
 * @author giskou
 *
 */
public abstract class DEMutation {
	float f;
	Random r;
	
	public DEMutation(float f) {
		this.f = f;
		r = new Random(System.currentTimeMillis());
	}
	
	public Population mutate(Population pop) {
		Population result = new Population();
		for (int i = 0; i < pop.size(); i++) {
			try {
				result.add(mut(pop, i));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	protected abstract Citizen mut(Population p, int index) throws Exception;
}
