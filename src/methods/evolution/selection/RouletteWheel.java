/**
 * 
 */
package methods.evolution.selection;

import java.util.Iterator;
import java.util.TreeMap;

import methods.evolution.Citizen;
import methods.evolution.Population;

/**
 * @author giskou
 *
 */
public class RouletteWheel implements Selector {

	/**
	 *@param: Population
	 *@return selected citizen
	 */
	public Population Spin(Population p) {
		Population result = new Population();
		for (int i = 0; i < p.size(); i++) {
			float totalFit = 0;
			Iterator<Citizen> it = p.getItems().iterator();
			TreeMap<Float, Citizen> weel = new TreeMap<Float, Citizen>();
			while (it.hasNext()) {
				Citizen c = it.next();
				weel.put(totalFit, c);
				totalFit += c.fitness();
			}
			float pick = (float) (Math.random()*totalFit);
			result.add(weel.floorEntry(pick).getValue());
		}
		return result;
	}

}
