/**
 * 
 */
package methods.evolution.selection;

import java.util.Iterator;
import java.util.TreeSet;

import methods.evolution.Citizen;
import methods.evolution.Population;

/**
 * @author iskoulis ekontogi
 *
 */
public abstract class Selection {
	
	protected Population pop;
	protected Selector s;
	
	public Selection(Selector sel) {
		this.s = sel;
	}
	/**
	 *@param: population to be updated and evaluated
	 */
	public Population select(Population pop) {
		this.pop = pop;
		TreeSet<Citizen> items = pop.getItems();
		Iterator<Citizen> it = items.descendingIterator();
		int rank = 1;
		update();
		while(it.hasNext()) {
			Citizen c = it.next();
			c.setRank(rank);
			evaluate(c);
			rank++;
		}
		return this.s.Spin(pop);
	}
	
	protected abstract void evaluate(Citizen ct);
	protected abstract void update();
}
