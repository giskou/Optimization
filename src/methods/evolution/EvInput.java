/**
 * 
 */
package methods.evolution;

import libs.Input;
import libs.Range;
import libs.functions.Function;
import methods.evolution.mutation.Mutation;
import methods.evolution.recombination.Recombination;
import methods.evolution.selection.Selection;

/**
 * @author giskou ekontogi
 *
 */

/**
 * Evolution Algorithms input
 *
 */
public class EvInput extends Input {
	
	Selection s;
	Recombination r;
	Mutation m;
	int pSize;
	double prec;
	
	public EvInput(Function func, Range range, double steps, double prec, Selection sele, Recombination recomb, Mutation mutat, int popSize) {
		super(func, range, steps);
		this.s = sele;
		this.r = recomb;
		this.m = mutat;
		this.pSize = popSize;
		this.prec = prec;
	}

}
