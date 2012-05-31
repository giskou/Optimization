/**
 * 
 */
package methods.evolution;

import java.util.Iterator;
import java.util.TreeSet;

import libs.Point;
import methods.evolution.Citizen.CitizenCompare;

/**
 * @author iskoulis
 *
 */
public class Population {

	private TreeSet<Citizen> items;
	
	public Population() {
		setItems(new TreeSet<Citizen>(new CitizenCompare()));
	}
	
	public Population(TreeSet<Citizen> set) {
		this.items = set;
	}
	
	public Population(Population pop) {
		this();
		this.items = new TreeSet<Citizen>(new CitizenCompare());
		Iterator<Citizen> itr = pop.items.iterator();
		while(itr.hasNext()){
			this.items.add(itr.next());
		}
	}
	
	public void add(Point p, double value) {
		this.items.add(new Citizen(p, value));
	}
	
	public Point remove(Point p) {
		Iterator<Citizen> itr = this.items.iterator();
		while(itr.hasNext()){
			Citizen ptr = itr.next();
			if (ptr.x == p) {
				this.items.remove(ptr);
				return ptr.x;
			}
		}
		return null;
	}
	
	public void clear() {
		this.items.clear();
	}
	
	/**
	 * @return the items
	 */
	public TreeSet<Citizen> getItems() {
		return this.items;
	}

	/**
	 * @param items the items to set
	 */
	public void setItems(TreeSet<Citizen> items) {
		this.items = items;
	}
	
	public int size() {
		return this.items.size();
	}

	public String toString() {
		return items.toString();
	}
}
