/**
 * 
 */
package methods.evolution.selection;

import methods.evolution.Citizen;

/**
 * @author giskou
 *
 */
public class LinearRanking extends Selection {
	
	private float s;
	
	public LinearRanking (float s) {
		this.s = s;
	}

	@Override
	protected void evaluate(Citizen ct) {
		float fit = 2-s+2*(s-1)*((ct.getRank()-1)/((float)(pop.size()-1)));
		ct.setFitness(fit);
	}
}
