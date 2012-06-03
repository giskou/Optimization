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
	
	public LinearRanking (Selector selector, float bias) {
		super(selector);
		this.s = bias;
	}

	@Override
	protected void evaluate(Citizen ct) {
		float fit = 2-s+2*(s-1)*((ct.getRank()-1)/((float)(pop.size()-1)));
		ct.setFitness(fit);
	}

	@Override
	protected void update() {
		// TODO Auto-generated method stub
		
	}
}
