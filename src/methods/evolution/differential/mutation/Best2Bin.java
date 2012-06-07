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
public class Best2Bin extends DEMutation {

	public Best2Bin(float f) {
		super(f);
	}

	@Override
	protected Citizen mut(Population p, int index) throws Exception {
		Object[] c = p.getItems().toArray();
		Point best = ((Citizen)c[0]).point();
		int r1, r2, r3, r4;
		do {
			r1 = super.r.nextInt(p.size()-1);
		} while (r1 == index);
		do {
			r2 = super.r.nextInt(p.size()-1);
		} while (r1 == r2 || r2 == index);
		do {
			r3 = super.r.nextInt(p.size()-1);
		} while (r1 == r3 || r2 == r3 || r3 == index);
		do {
			r4 = super.r.nextInt(p.size()-1);
		} while (r1 == r4 || r2 == r4 || r3 == r4 || r4 == index);
		Point tmp1 = Point.add(((Citizen)c[r3]).point(), ((Citizen)c[r4]).point().mull(-1));
		Point tmp2 = Point.add(((Citizen)c[r1]).point(), ((Citizen)c[r2]).point().mull(-1));
		Point tmp = Point.add(tmp1, tmp2);
		Point v = Point.add(best, tmp.mull(super.f));
		
		return new Citizen(v, 0);
	}

}
