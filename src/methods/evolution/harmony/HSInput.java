/**
 * 
 */
package methods.evolution.harmony;

import libs.Input;
import libs.Range;
import libs.functions.Function;

/**
 * @author giskou
 *
 */
public class HSInput extends Input {
	
	double prec;
	int mSize;
	float HMCR;
	float PAR;
	float cf;
	float w;
	int newSize;
	
	public HSInput(Function func, Range range, double steps, double prec, int memSize, int newSize, float HMCR, float PAR, float mutationRange, float convFact) {
		super(func, range, steps);
		this.prec = prec;
		this.mSize = memSize;
		this.HMCR = HMCR;
		this.PAR = PAR;
		this.cf = convFact;
		this.w = mutationRange;
		this.newSize = newSize;
	}
}
