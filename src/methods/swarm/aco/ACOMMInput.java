/**
 * 
 */
package methods.swarm.aco;

import libs.Range;
import libs.functions.Function;

/**
 * @author giskou
 *
 */
public class ACOMMInput extends ACOInput {
	
	float phMin, phMax;
	
	public ACOMMInput(Function func, Range range, double steps, float prec,
			int colSize, float p, float dt, float a, float b, float phMin, float phMax, boolean AS) {
		super(func, range, steps, prec, colSize, p, dt, a, b, AS);
		this.phMin = phMin;
		this.phMax = phMax;
	}
}