/**
 * 
 */
package methods.walk;

import libs.Input;
import libs.Range;
import libs.functions.Function;
import libs.functions.acceptance.AcceptanceFunction;
import libs.functions.cooling.CollingSchedule;

/**
 * @author iskoulis
 *
 */
public class SAInput extends Input {
	
	AcceptanceFunction af;
	CollingSchedule cs;
	
	public SAInput(Function func, Range range, double steps,AcceptanceFunction af, CollingSchedule cs) {
		super(func, range, steps);
		this.af = af;
		this.cs = cs;
	}
}
