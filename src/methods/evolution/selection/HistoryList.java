/**
 * 
 */
package methods.evolution.selection;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author giskou
 *
 */
public class HistoryList extends LinkedList<Double> {
	
	private static final long serialVersionUID = -4964516675117737045L;
	int size;
	
	public HistoryList (int size) {
		this.size = size;
	}
	
	public void push(Double value) {
		if (super.size() == this.size) {
			super.pollLast();
			super.push(value);
		} else {
			super.push(value);
		}
	}
	
	public double getWorst() {
		Iterator<Double> it = this.iterator();
		double worst = this.getFirst();
		while(it.hasNext()) {
			double cur = it.next();
			if (cur > worst) {
				worst = cur;
			}
		}
		return worst;
	}
}
