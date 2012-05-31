/**
 * 
 */
package methods.evolution.selection;

import java.util.Iterator;
import java.util.TreeSet;

import methods.evolution.Citizen;
import methods.evolution.Population;

/**
 * @author iskoulis
 *
 */
public abstract class Selection {
	
	protected Population pop;

	public void fitness(Population pop) {
		this.pop = pop;
		TreeSet<Citizen> items = pop.getItems();
		Iterator<Citizen> it = items.descendingIterator();
		int rank = 1;
		while(it.hasNext()) {
			Citizen c = it.next();
			System.out.println(c);
			c.setRank(rank);
			evaluate(c);
			System.out.println(c);
			rank++;
		}
	}
	
	protected abstract void evaluate(Citizen ct);
}
