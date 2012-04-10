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
public class RWEInput extends Input {
	
	public long gsSteps;

	public RWEInput(Function func, Range range, double steps, long gsSteps) {
		super(func, range, steps);
		this.gsSteps = gsSteps;
	}
}
