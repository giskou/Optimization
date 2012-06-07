/**
 * 
 */
package methods.evolution.differential;

import libs.Input;
import libs.Range;
import libs.functions.Function;
import methods.evolution.differential.mutation.DEMutation;

/**
 * @author giskou
 *
 */
public class DEInput extends Input {
	DEMutation m;
	DERecombination r;
	int pSize;
	double prec;

	public DEInput(Function func, Range range, double steps, double prec, int popSize, DEMutation mut, DERecombination rec) {
		super(func, range, steps);
		this.m = mut;
		this.r = rec;
		this.pSize = popSize;
		this.prec = prec;
	}
}
