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
	private double b = 0;
	
	
	public LinearScaling (Selector selector, int histSize, float d) {
		super(selector);
		this.d = d;
		hist = new HistoryList(histSize);
	}
	
	@Override
	/**
	 *@param: Citizen to be evaluated
	 */
	protected void evaluate(Citizen ct) {
		float a = (float)(b - ct.getValue());
		if (a < 0) a = 0;
		ct.setFitness(a);
	}

	@Override
	protected void update() {
		hist.push(pop.getItems().last().getValue());
		this.prev = b;
		this.b = d*prev + (1-d)*hist.getWorst();
	}

}
