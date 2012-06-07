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
public class Rand1Bin extends DEMutation {

	public Rand1Bin(float f) {
		super(f);
	}

	@Override
	protected Citizen mut(Population p, int index) throws Exception {
		Object[] c = p.getItems().toArray();
		int r1, r2, r3;
		do {
			r1 = super.r.nextInt(p.size()-1);
		} while (r1 == index);
		do {
			r2 = super.r.nextInt(p.size()-1);
		} while (r1 == r2 || r2 == index);
		do {
			r3 = super.r.nextInt(p.size()-1);
		} while (r1 == r3 || r2 == r3 || r3 == index);
		Point tmp = Point.add(((Citizen)c[r1]).point(), ((Citizen)c[r2]).point().mull(-1));
		Point v = Point.add(((Citizen)c[r3]).point(), tmp.mull(super.f));
		
		return new Citizen(v, 0);
	}
}
