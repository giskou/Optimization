/**
 * 
 */
package methods;

import libs.Input;
import libs.Point;
import libs.Range;
import libs.functions.Function;

/**
 * @author iskoulis
 *
 */
public class GSInput extends Input {
	
	public double prec;
	public Point dir;
	
	public GSInput(Function func, Range range, long steps, double prec, Point dir) {
		super(func, range, steps);
		this.prec = prec;
		this.dir = dir;
	}
	
}
