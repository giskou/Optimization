/**
 * 
 */
package methods.evolution.differential.mutation;

import libs.Point;
import methods.evolution.Citizen;
import methods.evolution.Population;

/**
 * @author giskou
 *
 */
public class Best1Bin extends DEMutation {

	public Best1Bin(float f) {
		super(f);
	}

	@Override
	protected Citizen mut(Population p, int index) throws Exception {
		Object[] c = p.getItems().toArray();
		Point best = ((Citizen)c[0]).point();
		int r1, r2;
		do {
			r1 = super.r.nextInt(p.size()-1);
		} while (r1 == index);
		do {
			r2 = super.r.nextInt(p.size()-1);
		} while (r1 == r2 || r2 == index);
		Point tmp = Point.add( ((Citizen)c[r1]).point(), ((Citizen)c[r2]).point().mull(-1));
		Point v = Point.add(best, tmp.mull(super.f));
		
		return new Citizen(v, 0);
	}

}
