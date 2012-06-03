/**
 * 
 */
package methods.evolution.selection;

import methods.evolution.Citizen;

/**
 * @author giskou
 *
 */
public class PowerScaling extends Selection {

	private float k;
	
	public PowerScaling (Selector selector, float power) {
		super(selector);
		this.k = power;
	}
	
	@Override
	protected void evaluate(Citizen ct) {
		float fit = (float) Math.pow(ct.getValue(), k);
		ct.setFitness(fit);
	}

	@Override
	protected void update() {
		// TODO Auto-generated method stub
		
	}
}
