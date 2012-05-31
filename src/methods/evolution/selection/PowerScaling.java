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
	
	public PowerScaling (float k) {
		this.k = k;
	}
	
	@Override
	protected void evaluate(Citizen ct) {
		float fit = (float) Math.pow(ct.getValue(), k);
		ct.setFitness(fit);
	}
}
