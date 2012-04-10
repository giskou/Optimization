/**
 * 
 */
package methods.walk;

import libs.Input;
import libs.Range;
import libs.functions.Function;

/**
 * @author iskoulis
 *
 */
public class RWInput extends Input {
	
	public double l;
	public double lmin;
	public double iter;

	public RWInput(Function func, Range range, double steps, double l, double lmin, double iter) {
		super(func, range, steps);
		this.l = l;
		this.lmin = lmin;
		this.iter = iter;
	}
}
