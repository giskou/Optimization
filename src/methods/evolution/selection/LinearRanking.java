/**
 * 
 */
package methods.evolution.selection;

import methods.evolution.Citizen;

/**
 * @author iskoulis ekontogi
 *
 */
public class LinearRanking extends Selection {
	
	private float s;
	/**
	 *@param: selector, bias
	 */
	public LinearRanking (Selector selector, float bias) {
		super(selector);
		this.s = bias;
	}

	@Override
	/**
	 *@param: Citizen to be evaluated
	 */
	protected void evaluate(Citizen ct) {
		float fit = 2-s+2*(s-1)*((ct.getRank()-1)/((float)(pop.size()-1)));
		ct.setFitness(fit);
	}

	@Override
	protected void update() {
		// TODO Auto-generated method stub
		
	}
}
