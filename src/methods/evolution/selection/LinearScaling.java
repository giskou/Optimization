/**
 * 
 */
package methods.evolution.selection;

import methods.evolution.Citizen;

/**
 * @author giskou
 *
 */
public class LinearScaling extends Selection{

	private float d;
	private HistoryList hist;
	private double prev;
	
	
	public LinearScaling (int k, float d) {
		this.d = d;
		hist = new HistoryList(k);
	}
	
	@Override
	protected void evaluate(Citizen ct) {
		double b = d*prev + (1-d)*hist.getWorst();
		ct.setFitness((float) (b - ct.getValue()));
	}

}
