/**
 * 
 */
package methods.swarm.aco;

import libs.Input;
import libs.Range;
import libs.functions.Function;

/**
 * @author giskou
 *
 */
public class ACOInput extends Input {

	float prec;
	int colSize;
	float p;
	float dt;
	int[] domain;
	float a;
	float b;
	boolean AS;
	
	public ACOInput(Function func, Range range, double steps, float prec,  int colSize, float p, float dt, float a, float b, boolean AS) {
		super(func, range, steps);
		this.prec = prec;
		this.colSize = colSize;
		this.p = p;
		this.dt = dt;
		this.a = a;
		this.b = b;
		this.AS = AS;
		domain = new int[range.min.length];
		for (int i = 0; i < range.min.length; i++){
			domain[i] = (int)range.min[i];
		}
	}
}
