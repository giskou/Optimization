/**
 * 
 */
package methods.evolution;

import java.util.Iterator;
import java.util.TreeSet;

import libs.Point;
import methods.evolution.Citizen.CitizenCompare;

/**
 * @author iskoulis ekontogi
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
	/**
	 *  @return copys items
	 */
	public Population(Population pop) {
		this();
		this.items = new TreeSet<Citizen>(new CitizenCompare());
		Iterator<Citizen> itr = pop.items.iterator();
		while(itr.hasNext()){
			this.items.add(itr.next());
		}
	}
	/**
	 *  @return item with best value
	 */
	public Citizen best() {
		return items.first();
	}
	/**
	 *  Adds item to treeset Citizen
	 */
	public void add(Point p, double value) {
		this.items.add(new Citizen(p, value));
	}
	/**
	 *  Adds item to treeset Citizen
	 */
	public void add(Citizen c) {
		this.items.add(c);
	}
	/**
	 *  Removes item form treeset Citizen
	 */
	public Point remove(Point p) {
		Iterator<Citizen> itr = this.items.iterator();
		while(itr.hasNext()){
			Citizen ptr = itr.next();
			if (ptr.p == p) {
				this.items.remove(ptr);
				return ptr.p;
			}
		}
		return null;
	}
	/**
	 * @param Clears the treeset with the items
	 */
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
	/**
	 * @return the size of the items
	 */
	public int size() {
		return this.items.size();
	}
	/**
	 * @return Converts to String
	 */
	public String toString() {
		return items.toString();
	}
}
