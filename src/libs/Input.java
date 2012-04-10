/**
 * 
 */
package libs;

import libs.functions.Function;


/**
 * @author iskoulis
 *
 */
public class Input {
	
	public Function func;
	public Range range;
	public double steps;
	public int dim;
	
	public Input(Function func, Range range, double steps) {
		this.func = func;
		this.range = range;
		this.steps = steps;
		this.dim = range.min.length;
	}
	
}
