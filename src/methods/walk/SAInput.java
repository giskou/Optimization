/**
 * 
 */
package methods.walk;

import libs.*;
import libs.functions.Function;
import libs.functions.acceptance.AcceptanceFunction;
import libs.functions.cooling.CoolingSchedule;

/**
 * @author iskoulis
 *
 */
public class SAInput extends Input {
	
	AcceptanceFunction af;
	CoolingSchedule cs;
	double step;
	double fStar;
	double prec;
	
	public SAInput(Function func, Range range, double steps,AcceptanceFunction af, CoolingSchedule cs, double step, double fStar, double prec) {
		super(func, range, steps);
		this.af = af;
		this.cs = cs;
		this.step = step;
		this.fStar = fStar;
		this.prec = prec;
	}
}
